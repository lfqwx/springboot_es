package com.lfq.controller;

import com.lfq.entity.es.EsBlog;
import com.lfq.entity.mysql.MysqlBlog;
import com.lfq.repository.es.EsRepository;
import com.lfq.repository.mysql.MysqlRepository;
import lombok.Data;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author: 𝓛.𝓕.𝓠
 */
@RestController
public class DataController {
    @Autowired
    private MysqlRepository mysqlRepository;
    @Autowired
    private EsRepository esRepository;

    /**
     * 默认展示所有信息(最新在前)
     */
    @GetMapping("/blogs")
    public List blogs(){
        return mysqlRepository.queryAll();
    }
    @PostMapping("/search")
    public Object search(@RequestBody Param param){
        HashMap<String, Object> map = new HashMap<>();
        StopWatch watch = new StopWatch();
        watch.start();
        String type = param.getType();
        if(type.equalsIgnoreCase("mysql")){
            //mysql
            List<MysqlBlog> mysqlBlogs = mysqlRepository.queryBlogs(param.getKeyword());
            map.put("list",mysqlBlogs);

        }else if(type.equalsIgnoreCase("es")){
            //es
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title",param.getKeyword()));
            builder.should(QueryBuilders.matchPhraseQuery("content",param.getKeyword()));
            String s = builder.toString();//有点类似StringBuilder拼接字符串
            System.out.println(s);
            Page<EsBlog> search = (Page<EsBlog>) esRepository.search(builder);
            List<EsBlog> content = search.getContent();
            map.put("list",content);
        }else{
            return "参数类型有误！";
        }
        watch.stop();
        long times = watch.getTotalTimeMillis();
        map.put("duration",times);
        return map;
    }




    /**
     * 内部Param参数类
     */
    @Data
    public class Param{
        private String type;//使用的查询方式
        private String keyword;//查询的关键字
    }

}
