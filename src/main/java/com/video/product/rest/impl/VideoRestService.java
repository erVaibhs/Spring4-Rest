package com.video.product.rest.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.video.product.dto.Video;
import com.video.product.rest.IVideoRestService;
import com.video.product.rest.response.VideoResponse;

@Service
public class VideoRestService implements IVideoRestService{
	private static Logger LOGGER = Logger.getLogger(VideoRestService.class);
	
	
	@Bean
	public RestTemplate restTemplate() {
		  RestTemplate restTemplate = new RestTemplate();
		    
		  restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		    return restTemplate;
	}

	public List<Video> get() {
		ResponseEntity<VideoResponse> restResponse = null;
		try{
			restResponse =  restTemplate().getForEntity("https://demo2697834.mockable.io/movies", VideoResponse.class);
		}catch(Exception e){
			
			LOGGER.error("Error occured while calling video rest api ", e);
		}
		LOGGER.info("response "+ restResponse.toString());
		return null != restResponse ? restResponse.getBody().getEntries() : new ArrayList<Video>();
	}

	
}
