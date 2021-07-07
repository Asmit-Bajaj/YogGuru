package com.yogguru.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.jdbc.PreparedStatement;
import com.yogguru.model.BlogImages;
import com.yogguru.model.GuruBlog;
import com.yogguru.utilities.FileUtility;

@Component
public class BlogDaoImpl implements BlogDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	private String query;
	
	@Autowired
	FileUtility fileUtility;
	
	
	@Override
	public int addBlog(GuruBlog model, List<CommonsMultipartFile> blogImgs, CommonsMultipartFile thumbnail,
			String path,long guruId) {
		//first add the information of guru
		
		query = "insert into blog(title,`desc`,guru_id)values(?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.jdbcTemplate.update(connection -> {
	        PreparedStatement ps = (PreparedStatement) connection
	          .prepareStatement(query);
	          ps.setString(1,model.getTitle());
	          ps.setString(2, model.getDesc());
	          ps.setLong(3, guruId);
	          return ps;
	        }, keyHolder);

	    long Id =  (long) keyHolder.getKey();
		
	    //now add the blog images and thumbnail
	    int flag = 1;
	    
	    if(thumbnail.getSize() > 0) {
	    	//add the thumbnail
	    	flag = this.addBlogThumbnail(thumbnail, Id, path);
	    }
	    
	    if(blogImgs.size() > 0) {
	    	//add the blogs imgs
	    	flag = this.addBlogImages(blogImgs, Id, path);
	    }
	    
	    
		return flag;
	}

	@Override
	public int addBlogImages(List<CommonsMultipartFile> files,long id,String path) {
		int flag= 0;
		int idx = 1;
		String temp_path = "";
		
		for(CommonsMultipartFile file : files) {
			String fileName = "YogGuru_Blog_img_"+idx+"_"+id+"."+this.fileUtility.getExtension(file.getContentType());
			temp_path = path+File.separator+fileName;
			
			if(file.getSize() > 0) {
				try {
					//upload file to server path
					FileOutputStream out = new FileOutputStream(temp_path);
					out.write(file.getBytes());
					
					out.close();
					
					//System.out.println(temp_path);
					
					//now save it to database
					
					query = "insert into blog_images(blog_id,path)values(?,?)";
					
					flag = this.jdbcTemplate.update(query,id,temp_path);
					idx++;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		return flag;
	}

	@Override
	public int addBlogThumbnail(CommonsMultipartFile file,long id,String path) {
		String msg = null;
		String fileName = "YogGuru_Blog_thumbnail_"+id+"."+this.fileUtility.getExtension(file.getContentType());
		path = path+File.separator+fileName;
		int flag= 0;
		
		if(file.getSize() > 0) {
			try {
				//upload file to server path
				FileOutputStream out = new FileOutputStream(path);
				out.write(file.getBytes());
				
				out.close();
				
				System.out.println(path);
				
				//now save it to database
				
				query = "update blog set thumbnail=? where id=?";
				
				flag = this.jdbcTemplate.update(query,path,id);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return 1;
		}
		
		return flag;
	}

	//method to get the blogs of current guru
	@Override
	public List<GuruBlog> getAllMyBlogs(long id) {
		List<GuruBlog> allBlogs = new ArrayList<GuruBlog>();
		
		//get all my blogs
		
		query = "select * from blog where guru_id=?";
		
		allBlogs = this.jdbcTemplate.query(query,new Object[]{id},
				BeanPropertyRowMapper.newInstance(GuruBlog.class));
//		List<String>imgs = new ArrayList<>();
//		
//		for(int i=0;i<allBlogs.size();i++) {
//			query = "select path from blog_images where blog_id=?";
//			
//			imgs = this.jdbcTemplate.query(query,new Object[]{allBlogs.get(i).getId()},
//					BeanPropertyRowMapper.newInstance(String.class));
//			
//			allBlogs.get(i).setImgs(imgs);
//		}
		
		return allBlogs;
	}

	@Override
	public GuruBlog getCurrentBlog(long id) {
		//get this blog id
		List<GuruBlog> blog = new ArrayList();
		
		query = "select * from blog where id=?";
		
		blog = this.jdbcTemplate.query(query,new Object[]{id},
				BeanPropertyRowMapper.newInstance(GuruBlog.class));
		
		GuruBlog blog1;
		
		blog1 = blog.get(0);
		
		query = "select path from blog_images where blog_id=?";
		
		List<BlogImages> blogImgs = new ArrayList<>();
		blogImgs = this.jdbcTemplate.query(query,new Object[] {blog1.getId()},
				BeanPropertyRowMapper.newInstance(BlogImages.class)); 
		
		
		//System.out.println(imgs.get(0));
		//blog1.setImgs(new ArrayList<>());
		List<String> imgs = new ArrayList<>();
		
		for(int i=0;i<blogImgs.size();i++) {
			imgs.add(blogImgs.get(i).getPath());
			
		}
		
		blog1.setImgs(imgs);
		System.out.println(blog1);
		
		return blog1;
	}

	//to delete the current blog
	public int deleteBlog(long id) {
		//first delete the images of blog from server
		GuruBlog blog = this.getCurrentBlog(id);
		
		List<String> imgs = blog.getImgs();
		File file;
		
		for(int i=0;i<imgs.size();i++) {
			file = new File(imgs.get(i));
			file.delete();
		}
		
		//now delete the thumbnail
		
		if(blog.getThumbnail() != null) {
			file = new File(blog.getThumbnail());
			file.delete();
		}
		
		//now finally delete the record from database
		
		query = "delete from blog where id=?";
		
		int flag = this.jdbcTemplate.update(query,id);
		
		query = "delete from blog_images where blog_id=?";
		
		flag = this.jdbcTemplate.update(query,id);
		
		return flag;
	}

	//get all the blogs of all gurus
	public List<GuruBlog> getAllBlogs() {
		List<GuruBlog> allBlogs = new ArrayList<GuruBlog>();
		
		//get all my blogs
		
		query = "select * from blog";
		
		allBlogs = this.jdbcTemplate.query(query,
				BeanPropertyRowMapper.newInstance(GuruBlog.class));
		
		return allBlogs;
	}

}
