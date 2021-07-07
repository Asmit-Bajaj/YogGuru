package com.yogguru.dao;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.model.GuruModel;

public interface MainDao {
	public boolean addGuru(GuruModel guru,String profilePicc);
	public String addGuruProfileImage(CommonsMultipartFile file,GuruModel guru,String path,String fileType);
	public boolean updateLink(String link,long id);
	public String getUniqueLink(String prefix);
	
	public boolean checkGuruEmailValidation(String id);
	public boolean checkThisEmailAlreadyExist(String email);
	
	public boolean checkLoginCredential(GuruModel model);
	
	public boolean isAccountValidated(GuruModel model);
	public Long getGuruId(GuruModel model);
}
