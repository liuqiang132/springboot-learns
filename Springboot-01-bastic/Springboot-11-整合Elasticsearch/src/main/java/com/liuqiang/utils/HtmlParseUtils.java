package com.liuqiang.utils;


import com.liuqiang.docment.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class HtmlParseUtils {


    public  List<Book> htmlParse(String keyword) throws IOException {
        //目标解析的网页
        String url = "https://search.jd.com/Search?keyword=" + keyword+"&enc=utf-8";

        Document document = Jsoup.parse(new URL(url),30000);

        //获取id=J_goodsList
        Element goodsList = document.getElementById("J_goodsList");
        //获取li标签
        Elements elements = goodsList.getElementsByTag("li");

        List<Book> books = new ArrayList<>();
        //遍历
        for (Element element : elements) {
            //element====li标签
            String img = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String title = element.getElementsByClass("p-name").eq(0).text();
            Book book = new Book();
            book.setImg(img);
            book.setName(title);
            book.setPrice(price);

            books.add(book);

        }

        return books;
    }
}
