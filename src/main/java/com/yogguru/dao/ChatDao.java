package com.yogguru.dao;

import java.util.List;

import com.yogguru.model.ChatBoxModel;
import com.yogguru.model.GuruModel;

public interface ChatDao {
	public List<GuruModel> getAllGurus();
	public int addQueryChat(ChatBoxModel model);
	public List<ChatBoxModel> myChats(Long id);
	public ChatBoxModel getCurrChat(Long id);
	public int sendChatResponse(ChatBoxModel model);
}
