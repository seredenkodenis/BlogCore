package com.denis.helping.model;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Article implements Serializable, Comparable<Article> {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column
    @Lob
    private  String content;
    @Column
    private long creationTime;
    @Column
    private String tag;
    @Column
    private String shortTitle;
    @Column
    private String shortContent;

    public Article(){
    }


    public Article(String title, String content, String tag){
        this.title = title;
        this.content = content;
        this.creationTime = System.currentTimeMillis();
        this.tag = tag;
    }


    @Override
    public int compareTo(Article that) {
        return Long.compare(this.creationTime, that.creationTime);
    }


    public void setContent(String content) {
        this.content = content;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }


    public String getTitle() {
        return title;
    }


    public long getCreationTime() {
        return creationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTag() {
        return tag;
    }

    public String getShortContent() {
        return shortContent;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setCreationTime(long creationTime) {
        this.creationTime = creationTime;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

