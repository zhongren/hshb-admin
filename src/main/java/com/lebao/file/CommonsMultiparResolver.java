package com.lebao.file;

/**
 * Created by Server on 2016/4/15.
 */
public class CommonsMultiparResolver extends org.springframework.web.multipart.commons.CommonsMultipartResolver {
    /**
     * 用于过滤百度编辑器上传文件时阻止 commonsMultipartResolver 对文件进行包装
     */
    @Override
    public boolean isMultipart(javax.servlet.http.HttpServletRequest request) {
        String uri = request.getRequestURI();
        //System.out.println(uri);
        //过滤使用百度EmEditor的URI
        if (uri.indexOf("ueditor/config") > 0) {
          //  System.out.println("commonsMultipartResolver 放行");
            return false;
        }
      //  System.out.println("commonsMultipartResolver 拦截");
        return super.isMultipart(request);
    }
}