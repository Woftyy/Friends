package com.entity;

import java.sql.Timestamp;

/*
 * 动态实体类
 * 杨译
 */
public class Moment {
    private long id;    
    private int uid;   
    private String content; 
	private Timestamp publishdate;  
    private String img;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Timestamp publishdate) {
		this.publishdate = publishdate;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	} 
    
    
}
