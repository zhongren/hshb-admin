package com.lebao.controller;

import com.lebao.file.AppConfig;
import com.lebao.file.UploadUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BaseController {

    private Logger logger = Logger.getLogger(UploadController.class);

    @Autowired
    private UploadUtil uploadUtil;

    @Autowired
    private AppConfig appConfig;

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
