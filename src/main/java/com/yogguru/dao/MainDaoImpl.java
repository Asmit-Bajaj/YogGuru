package com.yogguru.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.mysql.jdbc.PreparedStatement;
import com.yogguru.model.GuruModel;
import com.yogguru.utilities.EmailUtility;
import com.yogguru.utilities.EncryptDecryptUtility;
import com.yogguru.utilities.FileUtility;

@Component
public class MainDaoImpl implements MainDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FileUtility fileUtility;
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	private EncryptDecryptUtility edutility;
	private String query;
	
	//add the guru to database
	public boolean addGuru(GuruModel guru,String profilePicc) {
		
		query = "insert into guru(name, contact, email, pwd, state, city, address, profile_picc, "
				+ "validate_email, link,date_of_link)values(?,?,?,?,?,?,?,?,?,?,now())";
		guru.setProfile_picc(profilePicc);
		guru.setValidate_email(false);
		
		guru.setLink(null);
		
		KeyHolder keyHolder = new GeneratedKeyHolder();

	    this.jdbcTemplate.update(connection -> {
	        PreparedStatement ps = (PreparedStatement) connection
	          .prepareStatement(query);
	          ps.setString(1, guru.getName().trim());
	          ps.setString(2, guru.getContact().trim());
	          ps.setString(3, guru.getEmail().trim().toLowerCase());
	          ps.setString(4, this.edutility.getSHA256(guru.getPwd()));
	          ps.setString(5, guru.getState());
	          ps.setString(6, guru.getCity());
	          ps.setString(7, guru.getAddress().trim());
	          ps.setString(8, guru.getProfile_picc());
	          ps.setBoolean(9, guru.getValidate_email());
	          ps.setString(10, null);
	          return ps;
	        }, keyHolder);

	    long Id =  (long) keyHolder.getKey();
	    
	    String link = this.getUniqueLink(Id+"");
	    
	    //send the email to given link
	    this.updateLink(link, Id);
	    String content = "<div>\r\n" + 
	    		"        <b>Welcome to YogGuru</b>,<br><br>\r\n" + 
	    		"        Thank you for registering on our portal. You are just one step away from completing the registration.<br>\r\n" + 
	    		"        Please Follow the given link to complete the registration.<br><br><br>\r\n" + 
	    		"        <a href=\"http://localhost:8081/YogGuru/confirmGuruEmail?id="+link+"\">"
	    				+ "http://localhost:8081/YogGuru/confirmGuruEmail?id="+link+"</a>\r\n" + 
	    		"    </div>";
	    
	    return this.emailUtility.sendEmail(guru.getEmail().trim(), content,"[YogGuru] Confirm E-Mail Address");
		
	}

	//upload profile photo to server
	public String addGuruProfileImage(CommonsMultipartFile file, GuruModel guru,String path,String fileType) {
		
		String msg = null;
		String fileName = this.fileUtility.getUniqueName("YogGuru_Profile_")+"."+this.fileUtility.getExtension(fileType);
		path = path+File.separator+fileName;
		
		if(file.getSize() > 0) {
			try {
				FileOutputStream out = new FileOutputStream(path);
				out.write(file.getBytes());
				
				out.close();
				msg = path;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return msg;
	}

	//update the link after registration
	public boolean updateLink(String link, long id) {
		query = "update guru set link=? where id=?";
		
		int update = this.jdbcTemplate.update(query,link,id);
		
		if(update > 0)
			return true;
		else
			return false;
	}

	//to get the unique link
	public String getUniqueLink(String prefix) {
		String ans = this.edutility.getSHA256(prefix);
		return ans;
	}

	//check email validation
	public boolean checkGuruEmailValidation(String id) {
		query = "update guru set validate_email=? where link=? and DATEDIFF(now(),date_of_link) < 6 and validate_email = ?";
		
		int update = this.jdbcTemplate.update(query,true,id,false);
		
		if(update > 0)
			return true;
		else
			return false;
	}
	
	//check whether this email is already present in table
	public boolean checkThisEmailAlreadyExist(String email) {
		query = "select id from guru where email=?";
		List<GuruModel> list = this.jdbcTemplate.query(query,new Object[]{email},BeanPropertyRowMapper.newInstance(GuruModel.class));
		
		if(list.size() == 0)
				return false;
		else
			return true;
	}

	//check whether these credentials are correct or not
	public boolean checkLoginCredential(GuruModel model) {
		query = "select id from guru where email=? and pwd=?";
		List<GuruModel> list = this.jdbcTemplate.query(query,new Object[]{model.getEmail(),this.edutility.getSHA256(model.getPwd())},
				BeanPropertyRowMapper.newInstance(GuruModel.class));
		
		if(list.size() == 0)
				return false;
		else
			return true;
	}

	//check whether this account is validated or not
	public boolean isAccountValidated(GuruModel model) {
		query = "select id from guru where email=? and pwd=? and validate_email=?";
		List<GuruModel> list = this.jdbcTemplate.query(query,new Object[]{model.getEmail(),this.edutility.getSHA256(model.getPwd()),true},
				BeanPropertyRowMapper.newInstance(GuruModel.class));
		
		if(list.size() == 0)
				return false;
		else
			return true;
		
	}

	//get the Guru Id
	public Long getGuruId(GuruModel model) {
		query = "select id from guru where email=? and pwd=?";
		List<GuruModel> list = this.jdbcTemplate.query(query,new Object[]{model.getEmail(),this.edutility.getSHA256(model.getPwd())},
				BeanPropertyRowMapper.newInstance(GuruModel.class));
		
		return list.get(0).getId();
	}
	
}
