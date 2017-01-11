package com.lebao.service;


import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.lebao.common.beans.SearchBean;
import com.lebao.common.dbhelp.page.Page;

import com.lebao.common.utils.QRUtil;
import com.lebao.common.utils.TimeUtil;
import com.lebao.common.utils.UrlUtil;
import com.lebao.converter.UserConverter;

import com.lebao.dao.user.UserDao;
import com.lebao.file.AppConfig;
import com.lebao.po.User;

import com.lebao.vo.UserVo;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: zr
 * Date  : 2016/12/6 18:13
 */
@Service
public class UserService {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    UserDao userDao;
    @Autowired
    UserConverter userConverter;

    public Page<UserVo> getPage(SearchBean s) throws SQLException {
        int myPageSize = 0;//每页记录数
        int curPage = 0;//显示页
        int pageCount = 0;//页数
        int recordCount = 0;//总记录数
        Page<User> userPage = userDao.getPage(s);
        List<UserVo> list = userConverter.convert2V(userPage.getData());
        recordCount = userPage.getRecordCount();
        pageCount = userPage.getPageCount();
        curPage = userPage.getCurPage();
        myPageSize = userPage.getPageSize();
        Page<UserVo> pageBean = new Page<UserVo>(myPageSize, list, curPage, pageCount, recordCount);
        return pageBean;
    }

    public Long save(UserVo vo) {
        vo.setCreateTime(TimeUtil.now());
        vo.setUpdateTime(TimeUtil.now());
        User user = userConverter.convert2P(vo);
        Long uid = userDao.save(user);
        return uid;
    }

    public void update(UserVo vo) {
        User user = userConverter.convert2P(vo);
        userDao.save(user);
    }

    public void delete(Long id) {
        UserVo vo = findOne(id);
        User user = userConverter.convert2P(vo);
        userDao.delete(user);
    }

    public UserVo findOne(Long id) {
        User user = userDao.findOne(id);
        return userConverter.convert2V(user);
    }

    /**
     * 生成二维码
     *
     * @param uid
     * @return
     * @throws Exception
     */
    public String saveQR(Long uid,String name) throws Exception {
        String content = appConfig.getSERVER_NAME() + "/qr/user?uid=" + uid;
        String path = appConfig.getUSER_QR();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = null;
        bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, hints);
        File file1 = new File(path, name+".jpg");
        QRUtil.writeToFile(bitMatrix, "jpg", file1);
        return appConfig.getSERVER_USER_QR()+"/" + name+".jpg";
    }

    public boolean deleteQR(Long uid) throws Exception {
        String path = appConfig.getUSER_QR();
        UserVo u=findOne(uid);
        File file = new File(path, u.getName()+".jpg");
        if(file.exists()){
            file.delete();
        }
        return true;
    }
}
