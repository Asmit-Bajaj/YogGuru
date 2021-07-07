package com.yogguru.model;

public class LiveClassModel {
	private String title;
	private String desc;
	private String thumbnail;
	private Long guru_id;
	private Long id;
	private String startDate;
	private String platform;
	private String link;

	private String timeDur;

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

	public Long getGuru_id() {
		return guru_id;
	}

	public void setGuru_id(Long guru_id) {
		this.guru_id = guru_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTimeDur() {
		return timeDur;
	}

	public void setTimeDur(String timeDur) {
		this.timeDur = timeDur;
	}

	public LiveClassModel(String title, String desc, String thumbnail, Long guru_id, Long id, String startDate,
			String platform, String link, String timeDur) {
		super();
		this.title = title;
		this.desc = desc;
		this.thumbnail = thumbnail;
		this.guru_id = guru_id;
		this.id = id;
		this.startDate = startDate;
		this.platform = platform;
		this.link = link;
		this.timeDur = timeDur;
	}

	public LiveClassModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "LiveClassModel [title=" + title + ", desc=" + desc + ", thumbnail=" + thumbnail + ", guru_id=" + guru_id
				+ ", id=" + id + ", startDate=" + startDate + ", platform=" + platform + ", link=" + link + ", timeDur="
				+ timeDur + "]";
	}

}
