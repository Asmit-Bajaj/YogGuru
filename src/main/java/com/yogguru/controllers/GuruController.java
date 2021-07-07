package com.yogguru.controllers;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yogguru.dao.BlogDao;
import com.yogguru.dao.ChatDao;
import com.yogguru.dao.LiveClassDao;
import com.yogguru.dao.VideoDao;
import com.yogguru.model.ChatBoxModel;
import com.yogguru.model.GuruBlog;
import com.yogguru.model.LiveClassModel;
import com.yogguru.model.VideoModel;

@Controller
@RequestMapping("/Guru")
public class GuruController {

	@Autowired
	private BlogDao blogDao;

	@Autowired
	private VideoDao videoDao;

	@Autowired
	private LiveClassDao liveClassDao;

	@Autowired
	private ChatDao chatDao;

	@RequestMapping("")
	public String getGuruHome(HttpSession sess) {
		// if id is set then show home page
		if (sess.getAttribute("guruId") != null)
			return "guruHome";
		else
			return "redirect:/login";
	}

	@RequestMapping("/AddBlog")
	public String getAddBlogForm(HttpSession sess) {
		if (sess.getAttribute("guruId") != null)
			return "add_blog";
		else
			return "redirect:/login";
	}

	@RequestMapping("/MyBlogs")
	public String getMyBlogs(HttpSession sess, Model model) {
		if (sess.getAttribute("guruId") != null) {
			model.addAttribute("allBlogs", this.blogDao.getAllMyBlogs((Long) sess.getAttribute("guruId")));
			return "myBlogs";
		} else
			return "redirect:/login";
	}

	@RequestMapping(path = { "/AddBlogSubmit" }, method = RequestMethod.POST)
	public String addANewBlog(@ModelAttribute GuruBlog model,
			@RequestParam("blogThumbnail") CommonsMultipartFile thumbnail,
			@RequestParam("blogImgs") List<CommonsMultipartFile> blogImgs, HttpSession ss) {
		if (ss.getAttribute("guruId") != null) {
			String path = ss.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "blog";
			System.out.println(path);

			// for(CommonsMultipartFile file : blogImgs) {
			// System.out.println(file.getOriginalFilename());
			// }

			int flag = blogDao.addBlog(model, blogImgs, thumbnail, path, (Long) ss.getAttribute("guruId"));

			if (flag == 1)
				ss.setAttribute("addBlogMsg", "Blog Added Successfully !!!!");
			else
				ss.setAttribute("addBlogMsg", "Something Went Wrong !!!!");

			// redirect to addBlog
			return "redirect:/Guru/AddBlog";

		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping(path = { "/ReadBlog" }, method = RequestMethod.GET)
	public String getCurrentBlog(@RequestParam("id") String id, HttpSession ss, Model model) {
		// get the current blog
		if (ss.getAttribute("guruId") != null) {

			GuruBlog blog = this.blogDao.getCurrentBlog(Long.parseLong(id));
			model.addAttribute("blog", blog);

			List<GuruBlog> allMyBlogs = this.blogDao.getAllMyBlogs(blog.getGuru_id());
			model.addAttribute("allMyBlogs", allMyBlogs);
			return "readBlog";

		} else {
			return "redirect:/index";
		}

	}

	@RequestMapping(path = { "/DeleteBlog" })
	public String deleteBlog(HttpSession ss, @RequestParam("id") String id) {
		if (ss.getAttribute("guruId") != null) {
			this.blogDao.deleteBlog((Long) Long.parseLong(id));
			ss.setAttribute("rm_succ", "1");
			return "redirect:/Guru/MyBlogs";
		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping("/AddVideo")
	public String getAddVideoForm(HttpSession sess) {
		if (sess.getAttribute("guruId") != null)
			return "add_video";
		else
			return "redirect:/login";
	}

	@RequestMapping("/EditVideo")
	public String getEditVideoForm(@RequestParam("id") String id, HttpSession sess, Model model) {
		if (sess.getAttribute("guruId") != null) {
			VideoModel videoModel = this.videoDao.getCurrentVideo(Long.parseLong(id));
			model.addAttribute("video", videoModel);
			return "editVideo";
		} else
			return "redirect:/login";
	}

	@RequestMapping("/MyVideos")
	public String getMyVideos(HttpSession sess, Model model) {
		if (sess.getAttribute("guruId") != null) {
			model.addAttribute("allVideos", this.videoDao.getAllMyVideos((Long) sess.getAttribute("guruId")));
			return "myVideos";
		} else
			return "redirect:/login";
	}

	@RequestMapping(path = { "/AddVideoSubmit" }, method = RequestMethod.POST)
	public String addANewVideo(@ModelAttribute VideoModel model,
			@RequestParam("videoThumbnail") CommonsMultipartFile thumbnail,
			@RequestParam("mainVideo") CommonsMultipartFile video, HttpSession ss) {
		if (ss.getAttribute("guruId") != null) {
			String path = ss.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "videos";
			System.out.println(path);

			// for(CommonsMultipartFile file : blogImgs) {
			// System.out.println(file.getOriginalFilename());
			// }

			int flag = videoDao.addVideo(model, video, thumbnail, path, (Long) ss.getAttribute("guruId"));

			if (flag == 1)
				ss.setAttribute("addVideoMsg", "Video Added Successfully !!!!");
			else
				ss.setAttribute("addVideoMsg", "Something Went Wrong !!!!");

			// redirect to addBlog
			return "redirect:/Guru/AddVideo";

		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping(path = { "/EditVideoSubmit" }, method = RequestMethod.POST)
	public String updateVideo(@ModelAttribute VideoModel model,
			@RequestParam("videoThumbnail") CommonsMultipartFile thumbnail,
			@RequestParam("mainVideo") CommonsMultipartFile video, HttpSession ss,
			@RequestParam("thumbnailChg") String thumbnailChg, @RequestParam("videoChg") String videoChg) {

		if (ss.getAttribute("guruId") != null) {
			String path = ss.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "videos";

			System.out.println(path);
			System.out.println(model);

			int flag;
			if (thumbnailChg.equals("1") && videoChg.equals("1")) {
				flag = videoDao.updateVideo(model, video, thumbnail, path, model.getId());
			} else if (thumbnailChg.equals("1")) {
				flag = videoDao.updateVideo(model, null, thumbnail, path, model.getId());
			} else if (videoChg.equals("1")) {
				flag = videoDao.updateVideo(model, video, null, path, model.getId());
			} else {
				flag = videoDao.updateVideo(model, null, null, path, model.getId());
			}

			if (flag == 1) {
				ss.setAttribute("editVideoMsg", "Video Updated Successfully !!!!");
				// System.out.println("Hello world");
			} else {
				ss.setAttribute("editVideoMsg", "Something Went Wrong !!!!");
				// System.out.println("Hello dom");
			}
			// redirect to addBlog
			return "redirect:/Guru/EditVideo?id=" + model.getId();

		} else {
			return "redirect:/index";
		}

	}

	@RequestMapping(path = { "/ShowVideo" }, method = RequestMethod.GET)
	public String getCurrentVideo(@RequestParam("id") String id, HttpSession ss, Model model) {
		// get the current blog
		if (ss.getAttribute("guruId") != null) {

			VideoModel video = this.videoDao.getCurrentVideo(Long.parseLong(id));
			model.addAttribute("video", video);

			return "showVideo";

		} else {
			return "redirect:/index";
		}

	}

	@RequestMapping(path = { "/DeleteVideo" })
	public String deleteVideo(HttpSession ss, @RequestParam("id") String id) {
		if (ss.getAttribute("guruId") != null) {
			this.videoDao.deleteVideo((Long) Long.parseLong(id));
			ss.setAttribute("rm_succ", "1");
			return "redirect:/Guru/MyVideos";
		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping("/AddLiveClass")
	public String getAddLiveClassForm(HttpSession sess) {
		if (sess.getAttribute("guruId") != null)
			return "addLiveClass";
		else
			return "redirect:/login";
	}

	@RequestMapping(path = { "/AddLiveClassSubmit" }, method = RequestMethod.POST)
	public String addANewLiveClass(@ModelAttribute LiveClassModel model,
			@RequestParam("liveClassThumbnail") CommonsMultipartFile thumbnail, HttpSession ss) {
		if (ss.getAttribute("guruId") != null) {
			String path = ss.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "resources"
					+ File.separator + "liveclass";
			System.out.println(path);

			System.out.println(model);
			int flag = liveClassDao.addLiveClass(model, thumbnail, path, (Long) ss.getAttribute("guruId"));

			if (flag == 1)
				ss.setAttribute("addLiveClassMsg", "Class Added Successfully !!!!");
			else
				ss.setAttribute("addLiveClassMsg", "Something Went Wrong !!!!");

			// redirect to addBlog
			return "redirect:/Guru/AddLiveClass";

		} else {
			return "redirect:/index";
		}
	}

	@RequestMapping("/MyChats")
	public String getMyChats(HttpSession sess, Model model) {
		if (sess.getAttribute("guruId") != null) {
			model.addAttribute("allChats", this.chatDao.myChats((Long) sess.getAttribute("guruId")));
			return "myChat";
		} else
			return "redirect:/login";
	}

	@RequestMapping("/AnswerChat")
	public String getAnswerChatForm(@RequestParam("id") String id, Model model,HttpSession sess) {
		if (sess.getAttribute("guruId") != null) {
			ChatBoxModel chat = this.chatDao.getCurrChat(Long.parseLong(id));

			model.addAttribute("chat", chat);

			return "answerChat";
		} else
			return "redirect:/login";
	}
	
	@RequestMapping(path= {"/SubmitAnswerChatForm"}, method = RequestMethod.POST)
	public String submitAnswerChatForm(@ModelAttribute ChatBoxModel model,HttpSession sess) {
		if (sess.getAttribute("guruId") != null) {
			int flag = this.chatDao.sendChatResponse(model);

			if(flag == 1) {
				sess.setAttribute("chatAnsMsg", "Response Submiited Successfully !!");
			}else {
				sess.setAttribute("chatAnsMsg", "Something Went Wrong At The Server !!");
			}
			return "redirect:/Guru/MyChats";
		} else
			return "redirect:/login";
	}
}
