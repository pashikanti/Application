package com.indus.servlets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class SendFCMNotification extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger("SendMail.Class");
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess( request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mTitle = request.getParameter("title");
		String mMessage = request.getParameter("message");
		
		String url="https://fcm.googleapis.com/fcm/send";
		URL object=new URL(url);
		String authKey = "AAAA16uB2l4:APA91bEJGPV-b2wPv24JOErn5vt0M48z5eKmeofNGoRumi-l492PcBRkxo2TrpZigokEdkuAFcvrsQkv6PUj5WwMS0GgYMMeU21WCYuG1gHwL_sZmthx4QHyoTEouSC9XC0Wc9fWHOj8";
		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		//con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");
		con.setRequestProperty("Authorization","key="+authKey+"");

		JSONObject cred   = new JSONObject();
		JSONObject auth   = new JSONObject();
		JSONObject parent = new JSONObject();

		try {
			/*cred.put("username","adm");
			cred.put("password", "pwd");
			auth.put("tenantName", "adm");
			auth.put("passwordCredentials", cred);
			parent.put("auth", auth);*/
			cred.put("title",mTitle);
			System.out.println("Notification Title"+cred);
			cred.put("body", mMessage);
			System.out.println("Notification Message"+cred);
			cred.put("sound", "default");
			cred.put("click_action", "FCM_PLUGIN_ACTIVITY");
			cred.put("icon", " http://www.indushealthplus.ae/images/favicon.ico");
			parent.put("notification", cred);
			auth.put("title", "title");
			auth.put("detail", "message");
			parent.put("data", auth);
		//	parent.put("to","c13UgqrE0aE:APA91bHUxqZPzTfgjb3fncNoQ8eNTmvGRO2dHLV8Va3VPvvIGlb0ixaBHo-d7jXA13WT9GcoZzv4B5UDIbmAAk9lrD8eFRiCcqBUxtSegA1I8HLo4j0JZSWfl9N9nw_h27fa9zbE1h7H");
			parent.put("to","/topics/all");

			OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
			System.out.println("===="+parent.toString());
			wr.write(parent.toString());
			wr.flush();
			/*OutputStream os = con.getOutputStream();
			os.write(parent.toString().getBytes("UTF-8"));
			os.close();*/
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//display what returns the POST request

		StringBuilder sb = new StringBuilder();  
		int HttpResult = con.getResponseCode(); 
		if (HttpResult == HttpURLConnection.HTTP_OK) {
		    BufferedReader br = new BufferedReader(
		            new InputStreamReader(con.getInputStream(), "utf-8"));
		    String line = null;  
		    while ((line = br.readLine()) != null) {  
		        sb.append(line + "\n");  
		    }
		    br.close();
		    System.out.println("" + sb.toString());  
		} else {
		    System.out.println(con.getResponseMessage());  
		}  
	}
}


