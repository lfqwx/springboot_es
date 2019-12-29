package com.lfq.controller;

import com.lfq.entity.mysql.MysqlBlog;
import com.lfq.repository.mysql.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: 𝓛.𝓕.𝓠
 */
@Controller
public class TestController {
    @Autowired
    private MysqlRepository mysqlRepository;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/all")
    @ResponseBody
    public List findAll(){
        List<MysqlBlog> all = mysqlRepository.findAll();
        System.out.print(all.size());
        return all;
    }

}
