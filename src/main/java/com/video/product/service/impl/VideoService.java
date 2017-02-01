package com.video.product.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.video.product.dto.Video;
import com.video.product.rest.IVideoRestService;
import com.video.product.service.IVideoService;

@Service
public class VideoService implements IVideoService {

	private static Logger LOGGER = Logger.getLogger(VideoService.class);
	
	@Autowired
	private IVideoRestService videoRestService;

	public List<Video> getAll() {
		LOGGER.info("call video rest service to fetch video list");
		return videoRestService.get();
	}
	
	public Video getVideoById(String id) {
		LOGGER.info("get a video from video rest service by id "+ id);
		
		List<Video> videos = videoRestService.get();
		
		return videos.stream().filter(v -> v.getId().equals(id) ).findAny().orElse(null);
	}

	
}
