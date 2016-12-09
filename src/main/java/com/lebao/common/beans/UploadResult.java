package com.lebao.common.beans;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;


/*
//成功时
{
        "error" : 0,
        "url" : "http://www.example.com/path/to/file.ext"
}
//失败时
{
        "error" : 1,
        "message" : "错误信息"
}
 */

public class UploadResult {
    public static String success(String url) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("error", 0);
        result.put("url", url);
        Gson gson = new Gson();
        return gson.toJson(result);
    }

    public static String fail(String errorMsg) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("error", 1);
        result.put("message", errorMsg);
        Gson gson = new Gson();
        return gson.toJson(result);
    }
}
