package com.lebao.common.utils;



import javax.servlet.http.HttpServletRequest;



public class UrlUtil {
    public static String getBaseUrl(HttpServletRequest request){
        String path=request.getSession().getServletContext().getRealPath("");
        return path;
    }
}
