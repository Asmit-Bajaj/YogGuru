package com.yogguru.model;

public class ChatBoxModel {
	private Long Id;
	private String name;
	private String email_id;
	private Long guru_id;
	private String query;
	private Boolean isAnswered;
	private String response;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public Long getGuru_id() {
		return guru_id;
	}

	public void setGuru_id(Long guru_id) {
		this.guru_id = guru_id;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return "ChatBoxModel [Id=" + Id + ", name=" + name + ", email_id=" + email_id + ", guru_id=" + guru_id
				+ ", query=" + query + ", isAnswered=" + isAnswered + ", response=" + response + "]";
	}

	public ChatBoxModel(Long id, String name, String email_id, Long guru_id, String query, Boolean isAnswered,
			String response) {
		super();
		Id = id;
		this.name = name;
		this.email_id = email_id;
		this.guru_id = guru_id;
		this.query = query;
		this.isAnswered = isAnswered;
		this.response = response;
	}

	public ChatBoxModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
