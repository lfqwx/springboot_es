package com.lfq.repository.es;

import com.lfq.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: 𝓛.𝓕.𝓠
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,Integer> {
}
