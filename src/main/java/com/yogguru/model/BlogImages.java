package com.yogguru.model;

public class BlogImages {
	private Long blog_id;
	private String path;
	
	public Long getBlog_id() {
		return blog_id;
	}
	
	public void setBlog_id(Long blog_id) {
		this.blog_id = blog_id;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public BlogImages(Long blog_id, String path) {
		super();
		this.blog_id = blog_id;
		this.path = path;
	}
	
	public BlogImages() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
