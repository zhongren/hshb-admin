package com.lebao.controller;

import com.google.gson.Gson;
import com.lebao.common.beans.AjaxResult;
import com.lebao.common.beans.UploadResult;
import com.lebao.file.UploadUtil;
import com.lebao.service.AppConfig;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BaseController {

    private Logger logger = Logger.getLogger(UploadController.class);

    @Autowired
    private UploadUtil uploadUtil;


    @Autowired
    private AppConfig appConfig;




    @RequestMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile) {
        System.out.println("开始上传");
        try {
            boolean result = false;
            //取得可上传的文件类型
            List<String> fileTypes = this.getAllowFiles(appConfig.IMAGE_ALLOW_TYPE);
            //获取文件名
            String fileName = uploadFile.getOriginalFilename();
            // 获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            // 对扩展名进行小写转换
            ext = ext.toLowerCase();
            //文件类型检查
            if(!fileTypes.contains(ext)){
                return UploadResult.fail("不是合法的格式");
            }
            // 新的文件名
            String newFileName = new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date())
                    + (int) (Math.random() * 10000) + "." + ext;
            String imgFolderName = appConfig.NEWS_IMAGE_CONTENT;
            String floderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File file = this.creatFolder(imgFolderName, floderName, newFileName);
            String folderNameYear = floderName.substring(0, 4);
            String folderNameMonth = floderName.substring(4, 6);
            String folderNameDay = floderName.substring(6, 8);
            FileCopyUtils.copy(uploadFile.getInputStream(), new FileOutputStream(file));
            String returnImgUrl = folderNameYear + "/" + folderNameMonth + "/" + folderNameDay + "/" + newFileName;
            returnImgUrl = returnImgUrl.replaceAll("\\\\", "/");
            result = true;
            if (!result) {
                return UploadResult.fail("视频上传失败");
            }
            return JinTongResult.build(JinTongResult.SUCCESS, "视频上传成功", video_download_uri+returnImgUrl);
        } catch (Exception e) {
            return JinTongResult.fail("视频上传发生异常");
        }
    }


    /**
     * 获取可以上传的文件类型
     * @param allowFiles
     * @return
     */
    public List<String> getAllowFiles(String allowFiles) {
        List<String> fileTypes = new ArrayList<String>();
        String types[] = allowFiles.split(",");
        for (int i = 0; i < types.length; i++) {
            String type=types[i].toLowerCase();
            fileTypes.add(type);
        }
        return fileTypes;
    }


    /**
     * 创建文件夹
     *
     * @param imgFolderName
     *            图片存储路径
     * @param folderName
     *            二级文件夹
     * @param fileName
     *            文件名
     * @return
     */
    public File creatFolder(String imgFolderName, String folderName, String fileName) {
        File file = null;
        // imgFolderName = imgFolderName.replaceAll("/", ""); //去掉"/"
        imgFolderName = imgFolderName.replaceAll(" ", ""); // 替换半角空格
        imgFolderName = imgFolderName.replaceAll(" ", ""); // 替换全角空格

        // folderName = folderName.replaceAll("/", ""); //去掉"/"
        folderName = folderName.replaceAll(" ", ""); // 替换半角空格
        folderName = folderName.replaceAll(" ", ""); // 替换全角空格

        File firstFolder = new File(imgFolderName); // 一级文件夹
        if (firstFolder.exists()) { // 如果一级文件夹存在，则检测二级文件夹
            file = createSonFolder(firstFolder, folderName, fileName);
        } else { // 如果一级不存在，则创建一级文件夹
            firstFolder.mkdir();
            file = createSonFolder(firstFolder, folderName, fileName);
        }
        return file;
    }

    /**
     * 创建年月日三级文件夹
     *
     * @param firstFolder
     *            根文件
     * @param folderName
     *            年月日文件夹名
     * @param fileName
     *            文件名
     * @return
     */
    public File createSonFolder(File firstFolder, String folderName, String fileName) {
        File file = null;

        String folderNameYear = folderName.substring(0, 4);
        String folderNameMonth = folderName.substring(4, 6);
        String folderNameDay = folderName.substring(6, 8);

        File yearFolder = new File(firstFolder, folderNameYear);
        if (yearFolder.exists()) { // 如果二级文件夹也存在，则创建文件
            File monthFolder = new File(yearFolder, folderNameMonth); // 三级文件夹
            if (monthFolder.exists()) {
                File dayFolder = new File(monthFolder, folderNameDay); // 四级文件夹
                if (dayFolder.exists()) {
                    file = new File(dayFolder, fileName);
                } else {
                    dayFolder.mkdir();
                    file = new File(dayFolder, fileName);
                }
            } else {
                monthFolder.mkdir();
                File dayFolder = new File(monthFolder, folderNameDay);
                if (dayFolder.exists()) {
                    file = new File(dayFolder, fileName);
                } else {
                    dayFolder.mkdir();
                    file = new File(dayFolder, fileName);
                }
            }
        } else { // 如果二级文件夹不存在，则创建二级文件夹
            yearFolder.mkdir(); // 创建完二级文件夹后，再合建文件
            File monthFolder = new File(yearFolder, folderNameMonth);
            if (monthFolder.exists()) {
                File dayFolder = new File(monthFolder, folderNameDay);
                if (dayFolder.exists()) {
                    file = new File(dayFolder, fileName);
                } else {
                    dayFolder.mkdir();
                    file = new File(dayFolder, fileName);
                }
            } else {
                monthFolder.mkdir();
                File dayFolder = new File(monthFolder, folderNameDay);
                if (dayFolder.exists()) {
                    file = new File(dayFolder, fileName);
                } else {
                    dayFolder.mkdir();
                    file = new File(dayFolder, fileName);
                }
            }
        }
        return file;
    }

	/*
    /**
	 * 文件导入测试
	 * @param Filedata
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException

	@RequestMapping("import")
	@ResponseBody
	public Object upload(MultipartFile Filedata, Model model) throws UnsupportedEncodingException{
		try {


			String webpath="";

			String fileName = Filedata.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf(".") + 1,
                   fileName.lastIndexOf(".") + 4);

			logger.debug("fileName" + fileName ) ;
			logger.debug("fileType" + fileType ) ;

			if (fileType.toLowerCase().equals("xls") || fileType.toLowerCase().equals("xlsx")) {

				//Filedata.getInputStream()
				ExcelReader excelReader = new ExcelReader(Filedata.getInputStream());

				List<String [] > recordData = excelReader.getAllData(0);
				long s1 = System.nanoTime();
				Iterator<String[]> it=recordData.iterator();

				while(it.hasNext()){
					Object[] arr=(Object[])it.next();
					logger.debug(arr[0]+"  "+ arr[1] + " " + arr[2] + " "+arr[3] + " " + arr[4]);
				}
				long s2 = System.nanoTime();


				logger.debug("poi write 65536 rows to excel:" + (s2-s1));

			}else{
	        	// throw new BusinessServiceException("导入的文件格式不正确，应该不是excel文件");
	            this.logger.debug("导入的文件格式不正确，应该不是excel文件");
	        }

		} catch (Exception e) {
			logger.error("upload file fail" , e);
		}
		return new String("上传成功".getBytes() , "ISO-8859-1") ;

	}
	*/

    /**
     * 上传积分商品图片
     */

    @RequestMapping("/scoreshop/{picUrl}")
    @ResponseBody
    public String uploadScoreShop(MultipartFile Filedata, @PathVariable("picUrl") String picUrl) {
        if ("picUrl".equals(picUrl)) {
            logger.debug(" 添加小图片 ");
        }
        String uploadname = uploadUtil.getFile(Filedata, UploadUtil.PIC_SCORESHOP_KEY);
        return uploadname;
    }

    /**
     * 删除商品图片
     */

    @RequestMapping("/delFj/scoreshop")
    @ResponseBody
    public String delScoreShop(HttpServletRequest request) {
        String scoreShopDir = appConfig.getScoreshopDir();
        String ScoreShopSmallDir = appConfig.getScoreshopSmallDir();
        String fileUrl = request.getParameter("fileUrl");
        String delUrl = "", delSmallUrl = "";
        delUrl = scoreShopDir + "/" + fileUrl;
        delSmallUrl = ScoreShopSmallDir  + "/" + fileUrl;
        File delFile = new File(delUrl);
        delFile.delete();
        File delSmallFile = new File(delSmallUrl);
        delSmallFile.delete();
        logger.debug("  _ delUrl   " + delUrl + ", _delSmallUrl :" + delSmallUrl);
        return this.buildSuccessMessage("goodsPic_delete_success", ResultModal.MESSAGE);
    }





    /**
     * 上传商品图片
     */

    @RequestMapping("/goods/{picUrl}")
    @ResponseBody
    public String uploadGoods(MultipartFile Filedata, @PathVariable("picUrl") String picUrl) {
        if ("picUrl".equals(picUrl)) {
            logger.debug(" 添加小图片 ");
        }
        if ("picUrl2".equals(picUrl)) {
            logger.debug(" 添加大图片 ");
        }
        String uploadname = uploadUtil.getFile(Filedata, UploadUtil.PIC_GOODS_KEY);
        return uploadname;
    }

    /**
     * 删除商品图片
     */

    @RequestMapping("/delFj/goods")
    @ResponseBody
    public String delGoods(HttpServletRequest request) {
        String goodsDir = appConfig.getGoodsDir();
        String goodsSmallDir = appConfig.getGoodsSmallDir();
        String fileUrl = request.getParameter("fileUrl");
        String delUrl = "", delSmallUrl = "";
        delUrl = goodsDir + "/" + fileUrl;
        delSmallUrl = goodsSmallDir  + "/" + fileUrl;
        File delFile = new File(delUrl);
        delFile.delete();
        File delSmallFile = new File(delSmallUrl);
        delSmallFile.delete();
        logger.debug("  _ delUrl   " + delUrl + ", _delSmallUrl :" + delSmallUrl);
        return this.buildSuccessMessage("goodsPic_delete_success", ResultModal.MESSAGE);
    }
    /**
     * 上传广告图片
     */
    @RequestMapping("/adv/{picUrl}")
    @ResponseBody
    public String uploadAdv(MultipartFile Filedata, @PathVariable("picUrl") String picUrl) {
        if ("picUrl".equals(picUrl)) {
            logger.debug(" 添加小图片 ");
        }
        if ("picUrl2".equals(picUrl)) {
            logger.debug(" 添加大图片 ");
        }
        String uploadName = uploadUtil.getFile(Filedata, UploadUtil.PIC_ADV_KEY);
        return uploadName;
    }
    /**
     * 删除广告图片
     */
    @RequestMapping("/delFj/adv")
    @ResponseBody
    public String delAdv(HttpServletRequest request) {

        String fileUrl = request.getParameter("fileUrl");
        String delUrl = "", delSmallUrl = "";
        String shoperDir = appConfig.getShoperDir();
        String shoperSmallDir = appConfig.getShoperSmallDir();
        delUrl = shoperDir + "/" + fileUrl;
        File delFile = new File(delUrl);
        delFile.delete();
        delSmallUrl = shoperSmallDir + "/" + fileUrl;
        File delSmallFile = new File(delSmallUrl);
        delSmallFile.delete();
        logger.debug("  _ delUrl   " + delUrl + ", _delSmallUrl  " + delSmallFile);
        return this.buildSuccessMessage("shoperPic_delete_success", ResultModal.MESSAGE);
    }
    /**
     * 上传商家图片
     */
    @RequestMapping("/shoper/{picUrl}")
    @ResponseBody
    public String uploadShoper(MultipartFile Filedata, @PathVariable("picUrl") String picUrl) {
        if ("picUrl".equals(picUrl)) {
            logger.debug(" 添加小图片 ");
        }
        if ("picUrl2".equals(picUrl)) {
            logger.debug(" 添加大图片 ");
        }
        String uploadName = uploadUtil.getFile(Filedata, UploadUtil.PIC_SHOPER_KEY);
        return uploadName;
    }

    /**
     * 删除商家图片
     */
    @RequestMapping("/delFj/shoper")
    @ResponseBody
    public String delShoper(HttpServletRequest request) {

        String fileUrl = request.getParameter("fileUrl");
        String delUrl = "", delSmallUrl = "";
        String shoperDir = appConfig.getShoperDir();
        String shoperSmallDir = appConfig.getShoperSmallDir();
        delUrl = shoperDir + "/" + fileUrl;
        File delFile = new File(delUrl);
        delFile.delete();
        delSmallUrl = shoperSmallDir + "/" + fileUrl;
        File delSmallFile = new File(delSmallUrl);
        delSmallFile.delete();
        logger.debug("  _ delUrl   " + delUrl + ", _delSmallUrl  " + delSmallFile);
        return this.buildSuccessMessage("shoperPic_delete_success", ResultModal.MESSAGE);
    }

}
