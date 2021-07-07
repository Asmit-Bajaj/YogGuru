package com.yogguru.dao;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.model.VideoModel;

public interface VideoDao {
	public int addVideo(VideoModel model,CommonsMultipartFile video,CommonsMultipartFile thumbnail,String path,long guruId);
	public int addVideoThumbnail(CommonsMultipartFile thumbnail,long id,String path);
	public List<VideoModel> getAllMyVideos(long id);
	public VideoModel getCurrentVideo(long id);
	public int deleteVideo(long id);
	public int addMainVideo(CommonsMultipartFile file, long id, String path);
	
	public List<VideoModel> getAllVideos();
	public int updateVideo(VideoModel model,CommonsMultipartFile video,CommonsMultipartFile thumbnail,String path,long videoId);
}
