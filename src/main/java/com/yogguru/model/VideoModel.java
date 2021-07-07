package com.yogguru.model;

public class VideoModel {
	private Long id;
	private String title;
	private String desc;
	private Long guru_id;
	private String thumbnail;
	private String video;
	
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
	public Long getGuru_id() {
		return guru_id;
	}
	public void setGuru_id(Long guru_id) {
		this.guru_id = guru_id;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	
	@Override
	public String toString() {
		return "VideoModel [id=" + id + ", title=" + title + ", desc=" + desc + ", guru_id=" + guru_id + ", thumbnail="
				+ thumbnail + ", video=" + video + "]";
	}
	
	public VideoModel(Long id, String title, String desc, Long guru_id, String thumbnail, String video) {
		super();
		this.id = id;
		this.title = title;
		this.desc = desc;
		this.guru_id = guru_id;
		this.thumbnail = thumbnail;
		this.video = video;
	}
	public VideoModel() {
		super();
		
	}
	
	
	
}
