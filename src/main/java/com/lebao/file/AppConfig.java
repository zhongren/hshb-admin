package com.lebao.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {
    @Value("#{appSetting['server_name']}")
    public String SERVER_NAME;
    @Value("#{appSetting['user_qr']}")
    public String USER_QR;
    @Value("#{appSetting['image_allow_type']}")
    public String IMAGE_ALLOW_TYPE;
    @Value("#{appSetting['news_image_content']}")
    public String NEWS_IMAGE_CONTENT;
    @Value("#{appSetting['root']}")
    public String ROOT;

    @Value("#{appSetting['root_dir']}")
    private String rootDir;

    @Value("#{appSetting['root_small_dir']}")
    private String rootSmallDir;
    @Value("#{appSetting['scoreshop_dir']}")
    private String scoreshopDir;

    @Value("#{appSetting['scoreshop_small_dir']}")
    private String scoreshopSmallDir;
    @Value("#{appSetting['goods_dir']}")
    private String goodsDir;

    @Value("#{appSetting['goods_small_dir']}")
    private String goodsSmallDir;

    @Value("#{appSetting['shoper_dir']}")
    private String shoperDir;

    @Value("#{appSetting['shoper_small_dir']}")
    private String shoperSmallDir;

    @Value("#{appSetting['adv_dir']}")
    private String advDir;

    @Value("#{appSetting['adv_small_dir']}")
    private String advSmallDir;

    @Value("#{appSetting['news_dir']}")
    private String newsDir;

    @Value("#{appSetting['image_max_size']}")
    private String imageMaxSize;

    @Value("#{appSetting['image_allow_files']}")
    private String imageAllowFiles;

    @Value("#{appSetting['root_path']}")
    private String rootPath;

    @Value("#{appSetting['news_path']}")
    private String newsPath;

    @Value("#{appSetting['news_small_dir']}")
    private String newsSmallDir;

    @Value("#{appSetting['datas_dir']}")
    private String datasDir;

    @Value("#{appSetting['datas_path']}")
    private String datasPath;

    @Value("#{appSetting['datas_allow_files']}")
    private String datasAllowFiles;

    @Value("#{appSetting['HTMLDIR']}")
    private String HTMLDIR;

    @Value("#{appSetting['HTMLURLBASE']}")
    private String HTMLURLBASE;

    public String getScoreshopDir() {
        return scoreshopDir;
    }

    public void setScoreshopDir(String scoreshopDir) {
        this.scoreshopDir = scoreshopDir;
    }

    public String getScoreshopSmallDir() {
        return scoreshopSmallDir;
    }

    public void setScoreshopSmallDir(String scoreshopSmallDir) {
        this.scoreshopSmallDir = scoreshopSmallDir;
    }

    public String getAdvDir() {
        return advDir;
    }

    public void setAdvDir(String advDir) {
        this.advDir = advDir;
    }

    public String getAdvSmallDir() {
        return advSmallDir;
    }

    public void setAdvSmallDir(String advSmallDir) {
        this.advSmallDir = advSmallDir;
    }

    public String getShoperDir() {
        return shoperDir;
    }

    public void setShoperDir(String shoperDir) {
        this.shoperDir = shoperDir;
    }

    public String getShoperSmallDir() {
        return shoperSmallDir;
    }

    public void setShoperSmallDir(String shoperSmallDir) {
        this.shoperSmallDir = shoperSmallDir;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getRootSmallDir() {
        return rootSmallDir;
    }

    public void setRootSmallDir(String rootSmallDir) {
        this.rootSmallDir = rootSmallDir;
    }

    public String getSERVER_NAME() {
        return SERVER_NAME;
    }

    public void setSERVER_NAME(String SERVER_NAME) {
        this.SERVER_NAME = SERVER_NAME;
    }

    public String getGoodsDir() {
        return goodsDir;
    }

    public void setGoodsDir(String goodsDir) {
        this.goodsDir = goodsDir;
    }

    public String getGoodsSmallDir() {
        return goodsSmallDir;
    }

    public void setGoodsSmallDir(String goodsSmallDir) {
        this.goodsSmallDir = goodsSmallDir;
    }

    public String getNewsDir() {
        return newsDir;
    }

    public void setNewsDir(String newsDir) {
        this.newsDir = newsDir;
    }

    public String getNewsPath() {
        return newsPath;
    }

    public void setNewsPath(String newsPath) {
        this.newsPath = newsPath;
    }

    public String getNewsSmallDir() {
        return newsSmallDir;
    }

    public void setNewsSmallDir(String newsSmallDir) {
        this.newsSmallDir = newsSmallDir;
    }

    public String getHTMLDIR() {
        return HTMLDIR;
    }

    public void setHTMLDIR(String hTMLDIR) {
        HTMLDIR = hTMLDIR;
    }

    public String getHTMLURLBASE() {
        return HTMLURLBASE;
    }

    public void setHTMLURLBASE(String hTMLURLBASE) {
        HTMLURLBASE = hTMLURLBASE;
    }

    public String getDatasAllowFiles() {
        return datasAllowFiles;
    }

    public void setDatasAllowFiles(String datasAllowFiles) {
        this.datasAllowFiles = datasAllowFiles;
    }

    public String getDatasDir() {
        return datasDir;
    }

    public void setDatasDir(String datasDir) {
        this.datasDir = datasDir;
    }

    public String getDatasPath() {
        return datasPath;
    }

    public void setDatasPath(String datasPath) {
        this.datasPath = datasPath;
    }

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    public String getImageMaxSize() {
        return imageMaxSize;
    }

    public void setImageMaxSize(String imageMaxSize) {
        this.imageMaxSize = imageMaxSize;
    }

    public String getImageAllowFiles() {
        return imageAllowFiles;
    }

    public void setImageAllowFiles(String imageAllowFiles) {
        this.imageAllowFiles = imageAllowFiles;
    }

    public String getUSER_QR() {
        return USER_QR;
    }

    public void setUSER_QR(String USER_QR) {
        this.USER_QR = USER_QR;
    }

    public String getIMAGE_ALLOW_TYPE() {
        return IMAGE_ALLOW_TYPE;
    }

    public void setIMAGE_ALLOW_TYPE(String IMAGE_ALLOW_TYPE) {
        this.IMAGE_ALLOW_TYPE = IMAGE_ALLOW_TYPE;
    }

    public String getNEWS_IMAGE_CONTENT() {
        return NEWS_IMAGE_CONTENT;
    }

    public void setNEWS_IMAGE_CONTENT(String NEWS_IMAGE_CONTENT) {
        this.NEWS_IMAGE_CONTENT = NEWS_IMAGE_CONTENT;
    }

    public String getROOT() {
        return ROOT;
    }

    public void setROOT(String ROOT) {
        this.ROOT = ROOT;
    }
}
