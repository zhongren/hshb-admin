import com.google.gson.Gson;
import com.lebao.common.utils.TimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Server on 2016-07-20.
 */
public class xunzhong {

    /**
     * post请求
     * @param url
     * @param json
     * @return
     */

    public static String doPost(String url,String json,String Authorization ){
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        String response = null;
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-type", "application/json;charset=utf-8");
        post.setHeader("Authorization", Authorization);
        try {
            StringEntity s = new StringEntity(json);
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                response = result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(response);
        return response;
    }
    // 加密
    public static String getBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }
    private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    public static void main( String [] ars ){
/*

  System.out.println(Authorization);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setHeader("Authorization", Authorization);

        String AUTH_TOKEN="8d646e9b411a4cbdb30170f441ea3982";

        String ACCOUNT_SID="aedb86df8da740a2804eb2da63aecd2a";
        String time=TimeUtil.format(new Date(), TimeUtil.SOURCE_1);
        String jiami=ACCOUNT_SID+"|"+time;
        String Authorization= getBase64(jiami);

        String temp=ACCOUNT_SID+AUTH_TOKEN+time;
        String Sign=MD5(temp);

        String url="http://api.ytx.net/201512/sid/aedb86df8da740a2804eb2da63aecd2a/sms/TemplateSMS.wx?Sign="+Sign+"";

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("action","templateSms");
        map.put("appid","3f9af51f60a644daa8f7c2dc335c981b");
        map.put("mobile","13073339156");
        map.put("templateId","1");
        String datas[]={"0001","1"};
        map.put("datas",datas);

        Gson gson=new Gson();
        String json=gson.toJson(map);


            doPost(url,json,Authorization);
 */
        xunzhong xunzhong=new xunzhong();
        xunzhong.aaa();
    }
class JinTongResult{
    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    JinTongResult(Object data) {
        this.status = 1;
        this.msg = "success";
        this.data = data;
    }

}
      public  void aaa(){
          JinTongResult jinTongResult=new JinTongResult("hello");
          Gson gson=new Gson();
          System.out.println(gson.toJson(jinTongResult));
      }

}