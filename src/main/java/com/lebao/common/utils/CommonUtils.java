package com.lebao.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.lebao.common.utils.auth.Hash;

public class CommonUtils {
	public  static  String UNSET = "<font color=\"red\">未设置</font>"; 
	public static boolean isEmpty( List<?> list ){
		return list == null || list.size() == 0 ;
	}
	public static String getVerifyCode() {
		return String.valueOf(Math.random()).substring(2, 8);
	}
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
	}
	public static boolean isEmpty( String str ){
		return str == null || str.trim().equals("") ;
	}
	public static String getTime(){
		Date nowTime=new Date();
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		return time.format(nowTime);
	}
	public static String getYear(){
		Date nowTime=new Date();
		SimpleDateFormat time=new SimpleDateFormat("yyyy"); 
		return time.format(nowTime);
	}
	public static String getDay(Date nowTime){
		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		return time.format(nowTime);
	}
	
	public static boolean isEmpty(String [] strings){
		return strings == null || strings.length == 0 ;
	}
	public static Date getDate(String time) throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.parse(time);
	}
	public static int parseInt( String str ){
		int rs = 0 ;
		try{
			rs = Integer.parseInt(str) ;
		}catch(Exception e){
			
		}
		return rs ;
	}
	public static String toJson( Object obj ){
		Gson g = new Gson() ;
		return g.toJson(obj) ;
	}
	private static String concealString(String sourceString, int from, int to){
		String newstring = null;
		String source = null;
		if(sourceString == null){
			return null;
		}
		source = sourceString.trim();
		
		if(from >= 0 && to <= source.length() && from < to){
			newstring = source.substring(0, from);
			for(int i=0, n=to-from; i<n; i++){
				newstring = newstring.concat("*");
			}
			newstring = newstring.concat(source.substring(to));
		}else if(from >=0 && to > source.length()){
			newstring = source.substring(0, from);
			for(int i=0, n=source.length()-from; i<n; i++){
				newstring = newstring.concat("*");
			}

		}else{
			newstring = source;
		}
		
		return newstring;
	}
	/**
     * Encrypt password.
     *
     * @param password
     *            the password
     * @return the string
     */
    public static String encryptPassword(String password) {
        return Hash.sha2InHex(password);
    }

    public static String getSubTime(String source){
    	if(StringUtils.isNotBlank(source)){
    		source = source.substring(0, 19);
    	}
    	return source;
    }
}
