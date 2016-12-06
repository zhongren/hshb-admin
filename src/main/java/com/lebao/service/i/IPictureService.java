package com.lebao.service.i;

import org.springframework.web.multipart.MultipartFile;

public interface IPictureService {

	public String uploadPicture(MultipartFile uploadFile);
}
