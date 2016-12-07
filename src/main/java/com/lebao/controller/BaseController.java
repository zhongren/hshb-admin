package com.lebao.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.io.StringWriter;
import java.util.*;

public class BaseController {
	@Autowired
	private MessageSource msgSource ;
	//private Logger logger = Logger.getLogger(BaseController.class);


	protected DataTableVo parseData4DT(HttpServletRequest request) {
		DataTableVo dt = new DataTableVo();
		try {
			String sEcho = request.getParameter("sEcho");
			String start = request.getParameter("iDisplayStart");
			int iDisplayStart = StringUtils.isBlank(start) ? 0 : Integer.parseInt(start);

			String length = request.getParameter("iDisplayLength");
			int iDisplayLength = StringUtils.isBlank(length) ? 10 : Integer.parseInt(length);

			int sortColId = StringUtils.isBlank(request.getParameter("iSortCol_0")) ? 0
					: Integer.parseInt(request.getParameter("iSortCol_0"));

			String sortColName = request.getParameter("mDataProp_" + sortColId);
			String sortOrder = request.getParameter("sSortDir_0");

			dt.setsEcho(sEcho);
			dt.setiDisplayLength(iDisplayLength);
			dt.setiDisplayStart(iDisplayStart);
			dt.setSortField(sortColName);
			dt.setSortType(sortOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dt;
	}

	/**
	 * Format data to json of datatable
	 * 
	 * @param dt
	 * @return
	 */
	protected String formateData2DT(DataTableVo dt) {
		if (dt == null) {
			return null;
		}
		StringWriter writer = new StringWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(writer, dt);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return writer.toString();
	}
	/**
	 * Build a fail message 
	 * @param code
	 * @param msgType
	 * @return
	 */
	protected String buildFailMessage( String code , int msgType){
		return buildMessage( ResultModal.FAIL ,ResultModal.FAIL_CODE, code , null , msgType ) ;
	}
	/**
	 * Build a success message
	 * 
	 * @param code
	 * @param msgType
	 * @return
	 */
	protected String buildSuccessMessage(String code, int msgType) {
		return buildMessage(ResultModal.SUCCESS,ResultModal.SUCCESS_CODE, code, null, msgType);
	}
	
	/**
	 * DataTableVo templete
	 * @author Lain
	 *
	 */
	public class DataTableVo {
		private String sEcho ;
		private int iDisplayStart ;
		private int iDisplayLength ;
		private int iTotalRecords ;
		private int iTotalDisplayRecords ;
		private List<Object> aaData ;
		private String sortField ;
		private String sortType ;
		
		public String getsEcho() {
			return sEcho;
		}
		public void setsEcho(String sEcho) {
			this.sEcho = sEcho;
		}
		public int getiDisplayStart() {
			return iDisplayStart;
		}
		public String getSortField() {
			return sortField;
		}
		public void setSortField(String sortField) {
			this.sortField = sortField;
		}
		public String getSortType() {
			return sortType;
		}
		public void setSortType(String sortType) {
			this.sortType = sortType;
		}
		public void setiDisplayStart(int iDisplayStart) {
			this.iDisplayStart = iDisplayStart;
		}
		public int getiDisplayLength() {
			return iDisplayLength;
		}
		public void setiDisplayLength(int iDisplayLength) {
			this.iDisplayLength = iDisplayLength;
		}
		
		public int getiTotalRecords() {
			return iTotalRecords;
		}
		public void setiTotalRecords(int iTotalRecords) {
			this.iTotalRecords = iTotalRecords;
			setiTotalDisplayRecords(iTotalRecords) ;
		}
		
		public int getiTotalDisplayRecords() {
			return iTotalDisplayRecords;
		}
		public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
			this.iTotalDisplayRecords = iTotalDisplayRecords;
		}
		@SuppressWarnings("unchecked")
		public void setData(Object aaData) {
			if( aaData instanceof List ){
				this.aaData = (List<Object>)aaData;
			}else{
				this.aaData = new ArrayList<Object>() ;
				this.aaData.add( aaData ) ;
			}
		}
		
		public List<Object> getAaData(){
			return aaData ;
		}
	}
	public class ResultModal{
		public static final String SUCCESS = "success" ; 
		public static final String FAIL = "fail" ;
		public static final String FAIL_CODE = "-1" ;
		public static final String SUCCESS_CODE = "200" ;
		public static final int DIALOG = 0 ;
		public static final int MESSAGE = 1 ;
		public static final int DATA = 2 ;
		public static final int NO_MESSAGE = -1 ;
		private int msgType ;		
		private String state ;		
		private String code ;		
		private String msg ;		
		private Object data ;		
		public ResultModal( String state , String code , String msg , Object data , int msgType){
			this.state = state ;
			this.code = code ;
			this.msg = msg ;
			this.data = data ;
			this.msgType = msgType ;
		}
		public ResultModal(){
			
		}
		
		public int getMsgType() {
			return msgType;
		}
		public void setMsgType(int msgType) {
			this.msgType = msgType;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	}
	/**
	 * Build message
	 * @param status
	 * @param code
	 * @param data
	 * @param msgType
	 * @return
	 */
	protected String buildMessage( String status ,String code ,String msg ,  Object data , int msgType ){
		StringWriter writer = new StringWriter() ;
		try{
			 msg = msgSource.getMessage(msg, null , msg , Locale.CHINA) ;
			ResultModal resultModal = new ResultModal( status , code , msg , data , msgType );
			ObjectMapper mapper = new ObjectMapper() ;
			mapper.writeValue(writer, resultModal);
			writer.flush();
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(writer.toString());
		return writer.toString() ;
	}
	/**
	 * Get parameter start width a prefix 
	 * @param request
	 * @param prefix
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String , Object> getParametersStartWidth( HttpServletRequest request , String prefix ){
		Map<String, String[]> omp = request.getParameterMap();
		Map< String , Object > nmp = new HashMap<String , Object>() ;
		Set<String> keys = omp.keySet();
		for(String key : keys ){
			if( key.startsWith(prefix) ){
				String nkey = key.substring( prefix.length() ) ;
				if( ! StringUtils.isEmpty( nkey ) ){
					Gson g = new Gson() ;
					List<Object> obj = g.fromJson( g
							.toJson( omp.get(key)),ArrayList.class ) ;
					nmp.put(nkey, obj.get(0) ) ;
				}
			}
		}
		return nmp ;
	}
}
