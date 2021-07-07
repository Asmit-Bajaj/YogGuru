package com.yogguru.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yogguru.dao.BlogDao;
import com.yogguru.dao.ChatDao;
import com.yogguru.dao.VideoDao;
import com.yogguru.model.ChatBoxModel;
import com.yogguru.model.GuruBlog;
import com.yogguru.model.GuruModel;
import com.yogguru.model.VideoModel;

@Controller
@RequestMapping("User")
public class UserController {

	@Autowired
	private BlogDao blogDao;
	@Autowired
	private VideoDao videoDao;
	
	@Autowired
	private ChatDao chatDao;

	@RequestMapping("/AllBlogs")
	public String getAllBlogs(Model model) {

		List<GuruBlog> blogs = this.blogDao.getAllBlogs();
		model.addAttribute("allBlogs", blogs);
		return "allBlogs";
	}

	@RequestMapping(path = { "/ReadBlog" }, method = RequestMethod.GET)
	public String getCurrentBlog(@RequestParam("id") String id, HttpSession ss, Model model) {
		// get the current blog

		GuruBlog blog = this.blogDao.getCurrentBlog(Long.parseLong(id));
		model.addAttribute("blog", blog);
		
		List<GuruBlog> allMyBlogs = this.blogDao.getAllMyBlogs(blog.getGuru_id());
		model.addAttribute("allMyBlogs",allMyBlogs);
		
		return "readBlog";

	}

	@RequestMapping("/AllVideos")
	public String getAllVideos(Model model) {

		List<VideoModel> videos = this.videoDao.getAllVideos();
		model.addAttribute("allVideos", videos);
		return "allVideos";
	}

	@RequestMapping(path = { "/ShowVideo" }, method = RequestMethod.GET)
	public String getCurrentVideo(@RequestParam("id") String id, HttpSession ss, Model model) {
		// get the current video

		VideoModel video = this.videoDao.getCurrentVideo(Long.parseLong(id));
		model.addAttribute("video", video);

		return "showVideo";

	}
	
	@RequestMapping("/Chat")
	public String getChatForm(Model model) {
		List<GuruModel>list = this.chatDao.getAllGurus();
		model.addAttribute("allGurus",list);
		
		return "chatUser";
	}
	
	@RequestMapping("/SubmitChatForm")
	public String addQueryChatFormSubmit(@ModelAttribute ChatBoxModel model,@RequestParam("guru") String guru_id,
			HttpSession ss) {
		
		model.setGuru_id(Long.parseLong(guru_id));
		
		int flag = this.chatDao.addQueryChat(model);
		
		if(flag == 1) {
			ss.setAttribute("addQueryMsg", "Your Chat Is Submitted Successfully !! The Instructor Will Provide The Response"
					+ " Soon");
		}else {
			ss.setAttribute("addQueryMsg", "Something Went Wrong At The Server !!!");
		}
		
		return "redirect:/User/Chat";
	}
}
