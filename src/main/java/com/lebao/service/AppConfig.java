package com.lebao.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Author: zr
 * Date  : 2016/12/9 17:15
 */
@Component
public class AppConfig {
    @Value("${image_allow_type}")
    public String IMAGE_ALLOW_TYPE;
    @Value("${news_image_content}")
    public String NEWS_IMAGE_CONTENT;
}
