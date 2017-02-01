package com.video.product.service;

import java.util.List;

import com.video.product.dto.Video;

public interface IVideoService {
	
	List<Video> getAll();
	
	Video getVideoById(String id);

}
