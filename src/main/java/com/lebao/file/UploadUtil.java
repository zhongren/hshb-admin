package com.lebao.file;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 上传工具类
 *
 */
@Service
public class UploadUtil {

	private static final Logger log = Logger.getLogger(UploadUtil.class);
	
	@Autowired
	private AppConfig appConfig;
	@Autowired
	private PicDwind picServer;
	@Autowired
	private PubUpload pubUploadServer;
	
	public static final String PIC_NEWS_KEY = "pic_news_key";

	public static final String PIC_HEADIMG_KEY = "pic_headimg_key";
	
	public static final String DATA_TEACHER_KEY = "data_teacher_key";
	public static final String PIC_SCORESHOP_KEY = "pic_scoreshop_key";
	public static final String PIC_GOODS_KEY = "pic_goods_key";
	public static final String PIC_SHOPER_KEY = "pic_shoper_key";
	public static final String PIC_ADV_KEY = "pic_adv_key";
	//定义shoppickey
	public static final String PIC_SHOPTOP_KEY = "pic_shopTop_key";
	public static final String PIC_SHOPPIC_KEY = "pic_shopPic_key";
	
	
	/** 通过传入页面读取到的文件，处理后保存到本地磁盘，并返回一个已经创建好的File 
    * @param imgFile 从页面中读取到的文件 
    * @return 
	* @throws IOException 
    */  
   @SuppressWarnings({ "rawtypes" })
   public String getFile(MultipartFile imgFile,String picType) {  
	   //图片返回总路径
	   String returnImgUrl = null;
	   //大图片存储路径
	   String imgFolderName = "";
	   //小图片存储路径
	   String imgSmallFolderName = "";
	   //大图片返回路径
	   String imgReturnPath = "";
	   
	   if(picType.equals("") || picType == null){
		   imgFolderName = appConfig.getRootDir();
		   imgSmallFolderName = appConfig.getRootSmallDir();
		   imgReturnPath = appConfig.getRootPath();
	   } else if(picType.equals("pic_news_key")){
		   imgFolderName = appConfig.getNewsDir();
		   imgSmallFolderName = appConfig.getNewsSmallDir();
	   }else if(picType.equals("pic_scoreshop_key")){
		   imgFolderName = appConfig.getScoreshopDir();
		   imgSmallFolderName = appConfig.getScoreshopSmallDir();
	   }else if(picType.equals("pic_goods_key")){
		   imgFolderName = appConfig.getGoodsDir();
		   imgSmallFolderName = appConfig.getGoodsSmallDir();
	   }else if(picType.equals("pic_shoper_key")){
		   imgFolderName = appConfig.getShoperDir();
		   imgSmallFolderName = appConfig.getShoperSmallDir();
	   }else if(picType.equals("pic_adv_key")){
		   imgFolderName = appConfig.getAdvDir();
		   imgSmallFolderName = appConfig.getAdvSmallDir();
	   }


	   //取得可上传的文件类型
       List fileTypes = this.getAllowFiles(appConfig.getImageAllowFiles());
       String fileName = imgFile.getOriginalFilename();  
       //获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
        String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());  
        //对扩展名进行小写转换  
        ext = ext.toLowerCase();  
        //新的图片文件名
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date()) + 
        		(int)(Math.random()*10000) + "." + ext;

        File file = null; 
        if(fileTypes.contains(ext)) { //如果扩展名属于允许上传的类型，则创建文件  
        	try {
        		String floderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
 	           	file = this.creatFolder(imgFolderName, floderName, newFileName);  
 	           	imgFile.transferTo(file);
        		
	        	//压缩图片
				File smallFile = null;
				smallFile = this.creatFolder(imgSmallFolderName, floderName, newFileName); 
				String path = smallFile.getPath().toString().replaceAll("\\\\", "/");
				picServer.compressPic(file, path.substring(0, path.lastIndexOf("/")+1), 
					newFileName, 120, 120, true);
	        	
				String folderNameYear = floderName.substring(0, 4);
		        String folderNameMonth = floderName.substring(4, 6);
		        String folderNameDay = floderName.substring(6, 8);  
		        
                returnImgUrl = folderNameYear + "/" + folderNameMonth + "/" + folderNameDay + "/" + newFileName;
                returnImgUrl = returnImgUrl.replaceAll("\\\\", "/"); 
           } catch (IllegalStateException e) {  
               e.printStackTrace();  
           } catch (IOException e) {  
               e.printStackTrace();  
           }  
        }  
        return returnImgUrl;  
   } 
   
	//上传图片
	@SuppressWarnings("rawtypes")
	public String uploadDatasFile(MultipartFile datasFile,String type){
		String returnDatasUrl = null;
		String datasDir = "";
		String datasPath = "";
		if(type.equals("") || type == null){
			datasDir = appConfig.getRootDir();
			datasPath = appConfig.getRootPath();
		} else if (type.equals("pic_news_key")){
			datasDir = appConfig.getDatasDir();
			datasPath = appConfig.getDatasPath();
		}
		
		//取得可上传的文件类型  
		List fileTypes = this.getAllowFiles(appConfig.getDatasAllowFiles());
		
		String fileName = datasFile.getOriginalFilename();  
		//获取上传文件类型的扩展名,先得到.的位置，再截取从.的下一个位置到文件的最后，最后得到扩展名  
		String ext = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());  
		//对扩展名进行小写转换  
		ext = ext.toLowerCase();  
		//新的文件名
		String newFileName = new SimpleDateFormat("yyyyMMddHHmmssms").format(new Date()) + 
				(int)(Math.random()*10000) + "." + ext;
		File file = null;
		if(fileTypes.contains(ext)){
           	try {
           		String floderName = new SimpleDateFormat("yyyyMMdd").format(new Date());
               	file = this.creatFolder(datasDir, floderName, newFileName);
				datasFile.transferTo(file);
				
				String folderNameYear = floderName.substring(0, 4);
		        String folderNameMonth = floderName.substring(4, 6);
		        String folderNameDay = floderName.substring(6, 8);  
		        
		        returnDatasUrl = folderNameYear + "/" + folderNameMonth + "/" + folderNameDay + "/" + newFileName;
		        returnDatasUrl = returnDatasUrl.replaceAll("\\\\", "/"); 
		        returnDatasUrl = datasPath + returnDatasUrl;
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			returnDatasUrl = "error";
		}
		return returnDatasUrl;
	}
   
	/**
	* 取得可上传的文件类型
	* @param allowFiles
	* @return
	*/
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List getAllowFiles(String allowFiles){
		List fileTypes = new ArrayList();
		String types[] = allowFiles.split(",");
		for(int i = 0;i<types.length;i++){
			fileTypes.add(types[i]);
		}
		return fileTypes;
	}
	
	/**
	* 转换文件大小
	* @param fileS
	* @return
	*/ 
	public String formetFileSize(long fileS) { 
		DecimalFormat df = new DecimalFormat("#.00"); 
		String fileSizeString = ""; 
		if (fileS < 1024) { 
			fileSizeString = df.format((double) fileS) + "B"; 
		} else if (fileS < 1048576) { 
			fileSizeString = df.format((double) fileS / 1024) + "K"; 
		} else if (fileS < 1073741824) { 
			fileSizeString = df.format((double) fileS / 1048576) + "M"; 
		} else { 
			fileSizeString = df.format((double) fileS / 1073741824) + "G"; 
		} 
		return fileSizeString; 
	}
	
   /**
    * 创建文件夹
    * @param imgFolderName 图片存储路径
    * @param folderName 二级文件夹
    * @param fileName 文件名
    * @return
    */
    public File creatFolder(String imgFolderName,String folderName,String fileName) {  
         File file = null;  
         //imgFolderName = imgFolderName.replaceAll("/", "");               //去掉"/"  
         imgFolderName = imgFolderName.replaceAll(" ", "");               //替换半角空格  
         imgFolderName = imgFolderName.replaceAll(" ", "");               //替换全角空格  
          
         //folderName = folderName.replaceAll("/", "");             //去掉"/"  
         folderName = folderName.replaceAll(" ", "");             //替换半角空格  
         folderName = folderName.replaceAll(" ", "");             //替换全角空格

         File firstFolder = new File(imgFolderName);         //一级文件夹  
         if(firstFolder.exists()) {                             //如果一级文件夹存在，则检测二级文件夹  
        	 file = createSonFolder(firstFolder,folderName,fileName);
         }else {                                                //如果一级不存在，则创建一级文件夹
             firstFolder.mkdir();
             file = createSonFolder(firstFolder,folderName,fileName);
         }  
         return file;  
    }
    
    /**
     * 创建年月日三级文件夹
     * @param firstFolder 根文件
     * @param folderName 年月日文件夹名
     * @param fileName 文件名
     * @return
     */
    public File createSonFolder(File firstFolder,String folderName,String fileName){
    	File file = null;
    	
    	String folderNameYear = folderName.substring(0, 4);
        String folderNameMonth = folderName.substring(4, 6);
        String folderNameDay = folderName.substring(6, 8);
    	
    	File yearFolder = new File(firstFolder,folderNameYear);  
        if(yearFolder.exists()) {                        //如果二级文件夹也存在，则创建文件  
            File monthFolder = new File(yearFolder,folderNameMonth);  //三级文件夹 
            if(monthFolder.exists()){
           	 File dayFolder = new File(monthFolder,folderNameDay); //四级文件夹 
           	 if(dayFolder.exists()){
           		 file = new File(dayFolder,fileName);
           	 }else{
           		 dayFolder.mkdir();
           		 file = new File(dayFolder,fileName);
           	 }
            }else{
           	 monthFolder.mkdir();
           	 File dayFolder = new File(monthFolder,folderNameDay);
           	 if(dayFolder.exists()){
           		 file = new File(dayFolder,fileName);
           	 }else{
           		 dayFolder.mkdir();
           		 file = new File(dayFolder,fileName);
           	 }
            }
        }else {                                            //如果二级文件夹不存在，则创建二级文件夹  
       	 yearFolder.mkdir();  							//创建完二级文件夹后，再合建文件
       	 File monthFolder = new File(yearFolder,folderNameMonth);  
            if(monthFolder.exists()){
           	 File dayFolder = new File(monthFolder,folderNameDay);
           	 if(dayFolder.exists()){
           		 file = new File(dayFolder,fileName);
           	 }else{
           		 dayFolder.mkdir();
           		 file = new File(dayFolder,fileName);
           	 }
            }else{
           	 monthFolder.mkdir();
           	 File dayFolder = new File(monthFolder,folderNameDay);
           	 if(dayFolder.exists()){
           		 file = new File(dayFolder,fileName);
           	 }else{
           		 dayFolder.mkdir();
           		 file = new File(dayFolder,fileName);
           	 }
            }         
        } 
        return file;
    }
    
//    public void folder(String imgFolderName,String folderName,String fileName){
//    	File file = null;  
//        //imgFolderName = imgFolderName.replaceAll("/", "");               //去掉"/"  
//        imgFolderName = imgFolderName.replaceAll(" ", "");               //替换半角空格  
//        imgFolderName = imgFolderName.replaceAll(" ", "");               //替换全角空格  
//         
//        //folderName = folderName.replaceAll("/", "");             //去掉"/"  
//        folderName = folderName.replaceAll(" ", "");             //替换半角空格  
//        folderName = folderName.replaceAll(" ", "");             //替换全角空格
//    	
//    	File firstFolder = new File(imgFolderName);         //一级文件夹  
//        if(firstFolder.exists()) {                             //如果一级文件夹存在，则检测二级文件夹  
//            File secondFolder = new File(firstFolder,folderName);  
//            if(secondFolder.exists()) {                        //如果二级文件夹也存在，则创建文件  
//                file = new File(secondFolder,fileName);  
//            }else {                                            //如果二级文件夹不存在，则创建二级文件夹  
//                secondFolder.mkdir();  
//                file = new File(secondFolder,fileName);        //创建完二级文件夹后，再合建文件  
//            }  
//        }else {                                                //如果一级不存在，则创建一级文件夹  
//            firstFolder.mkdir();  
//            File secondFolder = new File(firstFolder,folderName);  
//            if(secondFolder.exists()) {                        //如果二级文件夹也存在，则创建文件  
//                file = new File(secondFolder,fileName);  
//            }else {                                            //如果二级文件夹不存在，则创建二级文件夹  
//                secondFolder.mkdir();  
//                file = new File(secondFolder,fileName);  
//            }  
//        }
//    }
    
    
    	
}
