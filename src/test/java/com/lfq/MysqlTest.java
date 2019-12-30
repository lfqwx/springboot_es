package com.lfq;

import com.lfq.entity.mysql.MysqlBlog;
import com.lfq.repository.mysql.MysqlRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 𝓛.𝓕.𝓠
 */
public class MysqlTest extends ApplicationTests {
    @Autowired
    private MysqlRepository repository;

    @Test
    public void test(){
        MysqlBlog one = repository.findOne(4);
        System.out.println(one);
    }
}
