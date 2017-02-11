package com.video.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.video.product.dto.Video;
import com.video.product.service.IVideoService;

@RestController
public class VideoProductController {
	
	private static Logger LOGGER = Logger.getLogger(VideoProductController.class);
	
	@Autowired
	private IVideoService videoservice;
	
	@CrossOrigin
	@RequestMapping("/videos")
	@ResponseBody
	public List<Video> getVideos(){
		LOGGER.info(" get a request to fetch all videos");
		return videoservice.getAll();
	}
	
	@CrossOrigin
	@RequestMapping("/video/{id}")
	public List<Video> getVideoById(@PathVariable final String id){
		LOGGER.info("get video by id  index change"+ id);
		List<Video> list = new ArrayList<>();
		list.add(videoservice.getVideoById(id));
		return list;
	}
	
	
}
