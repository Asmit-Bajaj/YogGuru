package com.yogguru.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.yogguru.model.ChatBoxModel;
import com.yogguru.model.GuruBlog;
import com.yogguru.model.GuruModel;
import com.yogguru.utilities.EmailUtility;
import com.yogguru.utilities.EncryptDecryptUtility;
import com.yogguru.utilities.FileUtility;

@Component
public class ChatDaoImpl implements ChatDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private FileUtility fileUtility;
	
	@Autowired
	private EmailUtility emailUtility;
	
	@Autowired
	private EncryptDecryptUtility edutility;
	
	private String query;
	
	@Override
	public List<GuruModel> getAllGurus() {
		query = "select id,name from guru";
		
		List<GuruModel> list = this.jdbcTemplate.query(query,
				BeanPropertyRowMapper.newInstance(GuruModel.class));
		
		return list;
	}

	@Override
	public int addQueryChat(ChatBoxModel model) {
		String query = "insert into chatbox(name, query, email_id, guru_id, isAnswered)values(?,?,?,?,?)";
		
		int flag = this.jdbcTemplate.update(query,model.getName(),model.getQuery(),model.getEmail_id(),model.getGuru_id(),false);
		
		return flag;
	}

	@Override
	public List<ChatBoxModel> myChats(Long id) {
		query = "select * from chatbox where guru_id=?";
		List<ChatBoxModel>list = this.jdbcTemplate.query(query,new Object[]{id},
				BeanPropertyRowMapper.newInstance(ChatBoxModel.class));
		
		return list;
	}

	@Override
	public ChatBoxModel getCurrChat(Long id) {
		query = "select * from chatbox where id=?";
		List<ChatBoxModel> list = this.jdbcTemplate.query(query,new Object[]{id},
				BeanPropertyRowMapper.newInstance(ChatBoxModel.class));
		
		return list.get(0);
	}

	@Override
	public int sendChatResponse(ChatBoxModel model) {
		//store the response
			query = "update chatbox set response =?,isAnswered=true where id=?";
			int flag = this.jdbcTemplate.update(query,model.getResponse(),model.getId());
			
			//now send the mail
			
			String guruName = "";
			//first get the guru name
			
			query = "select name from guru where id=?";
			List<GuruModel> list = this.jdbcTemplate.query(query,new Object[]{model.getGuru_id()},
					BeanPropertyRowMapper.newInstance(GuruModel.class));
			
			guruName = list.get(0).getName();
			
			
		 String content = "<div>\r\n" + 
		    		"        <b>Chat Response By "+guruName+" </b>,<br><br>\r\n" + 
				 "Your Chat : "+model.getQuery()+
		    		" <br><br><br>\r\n" + "Response : "+"<br><br><div style='white-space: pre-wrap;'>"+model.getResponse()+"</div><br><br>\r\n" + 
		    				"\r\n" + 
		    		"    </div>";
		  
		   this.emailUtility.sendEmail(model.getEmail_id().trim(), content,"[YogGuru] Chat Response");
		   
		   return flag;
	}
}
