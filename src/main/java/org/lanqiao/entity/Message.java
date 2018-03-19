package org.lanqiao.entity;

import java.util.Date;

public class Message {
    private Integer id;

    private String author;

    private String comment;

    private Date createTime;
    

    public Message(String author, String comment, Date createTime) {
		super();
		this.author = author;
		this.comment = comment;
		this.createTime = createTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}