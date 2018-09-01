package com.entity;

import java.sql.Timestamp;

public class Comment {
	private int id;
	private long mid;
      private String username;
      private String content;
      private int user_id;
  	private Timestamp publishdate;  
	public Timestamp getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(Timestamp publishdate) {
		this.publishdate = publishdate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public  void setContent(String content) {
		this.content = content;
	}

}
