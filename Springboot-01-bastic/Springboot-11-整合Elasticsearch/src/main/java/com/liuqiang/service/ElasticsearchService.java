package com.liuqiang.service;

import com.alibaba.fastjson.JSON;
import com.liuqiang.docment.Book;
import com.liuqiang.utils.HtmlParseUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class ElasticsearchService {


    @Autowired
    private HtmlParseUtils htmlParseUtils;


    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 解析网页并存入es中
     * @param keyWord
     * @return
     */
    public Boolean parse(String keyWord) throws IOException {

        //解析网页
        List<Book> bookList = htmlParseUtils.htmlParse(keyWord);
        //批量插入查询出的数据
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("2s");
        for (int i = 0; i < bookList.size(); i++) {
            bulkRequest.add(
                    new IndexRequest("jd_goods")
                            .source(JSON.toJSONString(bookList.get(i)), XContentType.JSON));
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return bulk.hasFailures();
    }

    /**
     * 搜索功能
     * @return
     */
    public List<Map<String,Object>> search(String keyWords, int pageNo, int pageSize) throws IOException {
        if (pageNo<=1){
            pageNo=1;
        }

        //获取索引
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        //条件搜索
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //分页
        searchSourceBuilder.from(pageNo);
        searchSourceBuilder.size(pageSize);


        TermQueryBuilder builder = QueryBuilders.termQuery("name", keyWords);
        searchSourceBuilder.query(builder);
        searchSourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        //执行搜索
        searchRequest.source(searchSourceBuilder);
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        //解析结果
        List<Map<String,Object>>  result= new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {

            //封装结果
            result.add(hit.getSourceAsMap());
        }

        return result;

    }

}
