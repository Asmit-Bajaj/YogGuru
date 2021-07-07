package com.yogguru.dao;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.model.LiveClassModel;

public interface LiveClassDao {
	public int addLiveClass(LiveClassModel model,CommonsMultipartFile file,String path,long guruId);
	public int addLiveClassThumbnail(CommonsMultipartFile thumbnail,long id,String path);
}
