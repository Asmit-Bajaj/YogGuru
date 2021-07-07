package com.yogguru.model;

public class GuruModel {
	private Long id;
	private String name;
	private String contact;
	private String email;
	private String pwd;
	private String address;
	private String state;
	private String city;
	private String profile_picc;
	private Boolean validate_email;
	private String link;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getProfile_picc() {
		return profile_picc;
	}
	
	public void setProfile_picc(String profile_picc) {
		this.profile_picc = profile_picc;
	}
	
	public Boolean getValidate_email() {
		return validate_email;
	}
	
	public void setValidate_email(Boolean validate_email) {
		this.validate_email = validate_email;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	@Override
	public String toString() {
		return "GuruModel [id=" + id + ", name=" + name + ", contact=" + contact + ", email=" + email + ", pwd=" + pwd
				+ ", address=" + address + ", state=" + state + ", city=" + city + ", profile_picc=" + profile_picc
				+ ", validate_email=" + validate_email + ", link=" + link + "]";
	}
	
	public GuruModel(Long id, String name, String contact, String email, String pwd, String address, String state,
			String city, String profile_picc, Boolean validate_email, String link) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.pwd = pwd;
		this.address = address;
		this.state = state;
		this.city = city;
		this.profile_picc = profile_picc;
		this.validate_email = validate_email;
		this.link = link;
	}
	
	public GuruModel() {
		
	}
		
}
