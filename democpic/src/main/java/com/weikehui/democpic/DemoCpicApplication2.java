package com.weikehui.democpic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zzuhui
 */
public class DemoCpicApplication2 {

    public static void main(String[] args) {
	    String host = "http,https://ali-stock.showapi.com";
	    String path = "/real-stockinfo";
	    String method = "GET";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE 你自己的AppCode");
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("code", "600887");
	    querys.put("needIndex", "1");
	    querys.put("need_k_pic", "1");


	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
//	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
//	    	System.out.println(response.toString());
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}
