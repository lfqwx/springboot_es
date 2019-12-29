package com.lfq.repository.mysql;

import com.lfq.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: 𝓛.𝓕.𝓠
 */
public interface MysqlRepository extends JpaRepository<MysqlBlog,Integer>{
}
