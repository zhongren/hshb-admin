package com.lebao.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
/**
 * 
 * @author
 * 功能：文件上传核心算法，将file转换成流，再以字节流的形式创建新的文件
 */
@Service
public class PubUpload {
	
	void copy(File f1, File f2) {
		try {
			InputStream fr = new FileInputStream(f1);
			OutputStream fw = new FileOutputStream(f2);
			byte buffer[] = new byte[1024];
			int length = 0;
			while ((length = fr.read(buffer)) != -1) {
				fw.write(buffer, 0, length);
			}
			fw.close();
			fr.close();
		} catch (IOException ioe) {
			
			//System.out.println(ioe);
		} catch (Exception e) {
			//System.out.println(e);
		}
	}

	public String bcopy(File f1, File f2, String fs) {
		File f3;
		String returnValue = "0";
		if (f1.exists()) {
			if (!f2.exists()) {
				f2.mkdirs();
			}
			f3 = new File(f2, fs);
			copy(f1, f3);
			returnValue = "1";
		} else {
			//System.out.println("要拷贝的文件不存在!");
		}

		return returnValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*PubUpload fc = new PubUpload();
		File f1, f2;
		f1 = new File("G:/GlemJC/pro/com.zend.php.core_9.0.2.201202240955.jar");
		f2 = new File("G:/GlemJC/upload");// 创建新的目录名称，服务器存放文件的目录
		fc.bcopy(f1, f2, "com.zend.php.core_9.0.2.201202240955.jar");*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String str1 = sdf.format(new Date());
		
		long id = new Date().getTime();
		
		long l1 = id / (2000 * 2000);

		long l2 = (id % (2000 * 2000)) / 2000;

		long l3 = id % 2000;
		System.out.println(String.format("%d/%d/%d/N0/", l1, l2, l3)+"------"+str1+"------"+RandomStringUtils.randomAlphanumeric(5));
//		filename = String.format("p_%d%d%d_%s.%s", l1, l2, l3, TimeStamp.getTime(TimeStamp.YYYYMMDDhhmmssxxx), ext);
	}
}

