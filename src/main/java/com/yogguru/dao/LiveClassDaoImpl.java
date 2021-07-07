package com.yogguru.dao;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mysql.jdbc.PreparedStatement;
import com.yogguru.model.LiveClassModel;
import com.yogguru.utilities.FileUtility;

@Component
public class LiveClassDaoImpl implements LiveClassDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	private String query;

	@Autowired
	FileUtility fileUtility;

	@Override
	public int addLiveClass(LiveClassModel model, CommonsMultipartFile thumbnail, String path, long guruId) {
		// first add the information of live class

		query = "insert into liveclass(title, `desc`, date, platform, link, guru_id,duration)values(?,?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(connection -> {
			PreparedStatement ps = (PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, model.getTitle());
			ps.setString(2, model.getDesc());
			ps.setString(3, model.getStartDate());
			ps.setString(4, model.getPlatform());
			ps.setString(5, model.getLink());
			ps.setLong(6, guruId);
			ps.setString(7, model.getTimeDur());
			return ps;
		}, keyHolder);

		long Id = (long) keyHolder.getKey();

		// now add thethumbnail
		int flag = 1;

		if (thumbnail.getSize() > 0) {
			// add the thumbnail
			flag = this.addLiveClassThumbnail(thumbnail, Id, path);
		}

		return flag;
	}

	@Override
	public int addLiveClassThumbnail(CommonsMultipartFile file, long id, String path) {
		String msg = null;
		String fileName = "YogGuru_liveclass_thumbnail_" + id + "." + this.fileUtility.getExtension(file.getContentType());
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

				query = "update liveclass set thumbnail=? where id=?";

				flag = this.jdbcTemplate.update(query, path, id);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return 1;
		}

		return flag;

	}

}
