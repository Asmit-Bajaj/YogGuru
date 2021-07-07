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
import com.yogguru.model.VideoModel;
import com.yogguru.utilities.FileUtility;

@Component
public class VideoDaoImpl implements VideoDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private String query;

	@Autowired
	FileUtility fileUtility;

	@Override
	public int addVideo(VideoModel model, CommonsMultipartFile video, CommonsMultipartFile thumbnail, String path,
			long guruId) {
		// first add the information of guru

		query = "insert into video(title,`desc`,guru_id)values(?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(connection -> {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, model.getTitle());
			ps.setString(2, model.getDesc());
			ps.setLong(3, guruId);
			return ps;
		}, keyHolder);

		long Id = (long) keyHolder.getKey();

		// now add the video thumbnail
		int flag = 1;

		if (thumbnail.getSize() > 0) {
			// add the thumbnail
			flag = this.addVideoThumbnail(thumbnail, Id, path);
		}

		// now add the video
		if (video.getSize() > 0) {
			// add the video
			flag = this.addMainVideo(video, Id, path);
		}

		return flag;
	}

	@Override
	public int addMainVideo(CommonsMultipartFile file, long id, String path) {
		String msg = null;
		String fileName = "YogGuru_Video_" + id + "." + this.fileUtility.getExtension(file.getContentType());
		path = path + File.separator + fileName;
		int flag = 0;

		if (file.getSize() > 0) {
			try {
				// upload file to server path
				FileOutputStream out = new FileOutputStream(path);
				out.write(file.getBytes());

				out.close();

				System.out.println(path);

				// now save it to database

				query = "update video set video=? where id=?";

				flag = this.jdbcTemplate.update(query, path, id);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return 1;
		}

		return flag;

	}

	@Override
	public int addVideoThumbnail(CommonsMultipartFile file, long id, String path) {
		String msg = null;
		String fileName = "YogGuru_Video_thumbnail_" + id + "." + this.fileUtility.getExtension(file.getContentType());
		path = path + File.separator + fileName;
		int flag = 0;

		if (file.getSize() > 0) {
			try {
				// upload file to server path
				FileOutputStream out = new FileOutputStream(path);
				out.write(file.getBytes());

				out.close();

				System.out.println(path);

				// now save it to database

				query = "update video set thumbnail=? where id=?";

				flag = this.jdbcTemplate.update(query, path, id);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return 1;
		}

		return flag;
	}

	// method to get the blogs of current guru
	@Override
	public List<VideoModel> getAllMyVideos(long id) {
		List<VideoModel> allVideos = new ArrayList();

		// get all my blogs

		query = "select * from video where guru_id=?";

		allVideos = this.jdbcTemplate.query(query, new Object[] {id},
				BeanPropertyRowMapper.newInstance(VideoModel.class));
		

		return allVideos;
	}

	@Override
	public VideoModel getCurrentVideo(long id) {
		// get this blog id
		List<VideoModel> video = new ArrayList();

		query = "select * from video where id=?";

		video = this.jdbcTemplate.query(query, new Object[] { id }, BeanPropertyRowMapper.newInstance(VideoModel.class));

		
		//System.out.println(blog1);

		return video.get(0);
	}

	// to delete the current blog
	public int deleteVideo(long id) {
		// first delete the images of blog from server
		VideoModel video = this.getCurrentVideo(id);

		
		// now delete the thumbnail
		File file;
		
		if (video.getThumbnail() != null) {
			file = new File(video.getThumbnail());
			file.delete();
		}

		//now delete the video
		
		file = new File(video.getVideo());
		file.delete();
		
		// now finally delete the record from database

		query = "delete from video where id=?";

		int flag = this.jdbcTemplate.update(query, id);

		return flag;
	}

	// get all the blogs of all gurus
	public List<VideoModel> getAllVideos() {
		List<VideoModel> allVideos = new ArrayList();

		// get all my videos

		query = "select * from video";

		allVideos = this.jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(VideoModel.class));

		return allVideos;
	}

	@Override
	public int updateVideo(VideoModel model, CommonsMultipartFile video, CommonsMultipartFile thumbnail, String path,
			long videoId) {
		//first retrieve all the data
		VideoModel videoModel = this.getCurrentVideo(videoId);
		int flag = 1;
		
		if(thumbnail  != null) {
			//delete old thumbnail
			if(videoModel.getThumbnail() != null) {
				File file = new File(videoModel.getThumbnail());
				file.delete();
			}
			
			//now add the new thumbnail
			
			flag = this.addVideoThumbnail(thumbnail, videoId, path); 
		}
		
		if(video  != null) {
			//delete old video
			if(videoModel.getVideo() != null) {
				File file = new File(videoModel.getVideo());
				file.delete();
			}
			
			//now add the new video
			
			flag = this.addMainVideo(video, videoId, path); 
		}
		
		//System.out.println(model.getTitle()+" "+videoModel.getDesc());
		//now update the record
		query = "update video set title=?,`desc`=? where id=?";
		flag = this.jdbcTemplate.update(query, model.getTitle(), model.getDesc(),videoId);
		
		return flag;
	}

}
