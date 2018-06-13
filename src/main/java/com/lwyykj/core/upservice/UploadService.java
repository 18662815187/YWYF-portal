package com.lwyykj.core.upservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	public String uploadPic(MultipartFile pic, String name,HttpServletRequest request,HttpServletResponse response);
}
