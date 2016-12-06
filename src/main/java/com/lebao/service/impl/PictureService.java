package com.lebao.service.impl;

import com.google.gson.Gson;
import com.lebao.common.utils.FtpUtil;
import com.lebao.common.utils.Sequence;
import com.lebao.service.i.IPictureService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Server on 2016/7/15.
 */
@Service
public class PictureService implements IPictureService {

    private String FTP_ADDRESS;

    private int FTP_PORT;

    private String FTP_USERNAME;

    private String FTP_PASSWORD;

    private String FTP_BATH_PATH;

    private String IMAGE_BATH_URL;


    public String uploadPicture(MultipartFile uploadFile) {
        Map result = new HashMap();
        Gson gson = new Gson();
        try {
            String oldNmae = uploadFile.getOriginalFilename();

            String newName = Sequence.nextId() + getSuffix(oldNmae);

            String filePath = new DateTime().toString("/yyyy/MM/dd");

            boolean struts = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BATH_PATH,
                    filePath, newName, uploadFile.getInputStream());
            // 返回结果
            //  System.out.println(struts);
            if (!struts) {// 上传失败
                result.put("error", 1);
                result.put("message", "上传失败");
                return gson.toJson(result);
            } else {
                result.put("error", 0);
                result.put("url", IMAGE_BATH_URL + filePath + "/" + newName);

                return gson.toJson(result);
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("error", 1);
            result.put("message", "上传失败");
            return gson.toJson(result);
        }

    }

    /**
     * 获取后缀名
     *
     * @param str
     * @return
     */
    public String getSuffix(String str) {
        return str.substring(str.indexOf("."));
    }
}
