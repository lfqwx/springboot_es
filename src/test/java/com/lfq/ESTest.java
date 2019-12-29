package com.lfq;

import com.lfq.entity.es.EsBlog;
import com.lfq.repository.es.EsRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;

/**
 * @author: 𝓛.𝓕.𝓠
 */
public class ESTest extends ApplicationTests {
    @Autowired
    private EsRepository esRepository;

    /**
     * 找到的数据来自ES
     */
    @Test
    public void testES(){
        Iterable<EsBlog> blogs = esRepository.findAll();
        Iterator<EsBlog> it = blogs.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
