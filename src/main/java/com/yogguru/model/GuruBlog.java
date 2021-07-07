package com.yogguru.model;

import java.util.List;

public class GuruBlog {
	private Long id;
	private String title;
	private String desc;
	private String thumbnail;
	
	private List<String>imgs;

	private Long guru_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public List<String> getImgs() {
		return imgs;
	}

	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public Long getGuru_id() {
		return guru_id;
	}

	public void setGuru_id(Long guru_id) {
		this.guru_id = guru_id;
	}

	@Override
	public String toString() {
		return "GuruBlog [id=" + id + ", title=" + title + ", desc=" + desc + ", thumbnail=" + thumbnail + ", imgs="
				+ imgs + ", guru_id=" + guru_id + "]";
	}

	public GuruBlog(Long id, String title, String desc, String thumbnail, List<String> imgs, Long guru_id) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.thumbnail = thumbnail;
		this.imgs = imgs;
		this.guru_id = guru_id;
	}

	public GuruBlog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
