package com.lfq.entity.mysql;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author: 𝓛.𝓕.𝓠
 */
@Data
@Table(name = "es_blog")
@Entity
public class MysqlBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext") //数据库字段与属性类型不匹配
    private String content;
    private Date createTime;
    private Date updateTime;
}
