package com.video.product.rest.response;

import java.util.List;

import com.video.product.dto.Video;

public class VideoResponse {
	
	
	private Integer totalCount;
	private List<Video> entries;
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<Video> getEntries() {
		return entries;
	}
	public void setEntries(List<Video> entries) {
		this.entries = entries;
	}
	
	

}
