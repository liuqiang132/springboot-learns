package com.liuqiang.controller;


import com.liuqiang.service.ElasticsearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

@RestController
public class ElasticsearchController {

    @Autowired
    private ElasticsearchService elasticsearchService;


    /**
     * 解析网页插入数据到es中
     * @param keyWords
     * @return
     * @throws IOException
     */
    @GetMapping("/esInsertData/{keyWords}")
    public Boolean esInsertData(@PathVariable("keyWords") String keyWords) throws IOException {
        return elasticsearchService.parse(URLDecoder.decode(keyWords, "utf-8"));
    }

    /**
     * 实现搜索功能
     * @return
     */
    @GetMapping("/search/{keyWords}/{pageNO}/{pageSize}")
    public List<Map<String,Object>> JDSearch(@PathVariable("keyWords") String keyWords,
                                             @PathVariable("pageNO") int pageNO,
                                             @PathVariable("pageSize") int pageSize) throws IOException {
        return elasticsearchService.search(URLDecoder.decode(keyWords, "utf-8"),pageNO,pageSize);

    }

}
