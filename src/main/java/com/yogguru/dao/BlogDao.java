package com.yogguru.dao;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.model.GuruBlog;

public interface BlogDao {
	public int addBlog(GuruBlog model,List<CommonsMultipartFile> files,CommonsMultipartFile file,String path,long guruId);
	public int addBlogImages(List<CommonsMultipartFile> blogImgs,long id,String path);
	public int addBlogThumbnail(CommonsMultipartFile thumbnail,long id,String path);
	public List<GuruBlog> getAllMyBlogs(long id);
	public GuruBlog getCurrentBlog(long id);
	public int deleteBlog(long id);
	
	public List<GuruBlog> getAllBlogs();
}
