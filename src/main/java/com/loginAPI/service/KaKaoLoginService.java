//package com.loginAPI.service;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//
//public class KaKaoLoginService {
//
//	public String kakaoLogin(String code) {
//		String accessToken = "";
//		String refreshToken = "";
//		String reqURL = "https://kauth.kakao.com/oauth/token";
//		
//		try {
//			URL url = new URL(reqURL);
//			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//			conn.setRequestMethod("POST");
//			conn.setDoOutput(true);
//			
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
//			StringBuilder sb = new StringBuilder();
//			sb.append("grant_type=authorization_code");
//			sb.append("&client_id=af36eabfc8fcdd03f7de39d67d7d2f1b");
//			sb.append("&redirect_uri=http://localhost:8080/login");
//			sb.append("&code="+code);
//			
//			bw.write(sb.toString());
//			bw.flush();
//			
//			int responseCode = conn.getResponseCode();
//			System.out.println("response code = " + responseCode);
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			
//			String line = "";
//			String result = "";
//			
//			while((line = br.readLine())!=null ) {
//				result += line;
//			}
//			
//			System.out.println("response body = "+result);
//			
//			JsonParser parser =new JsonParser();
//			JsonElement element = parser.parse(result);
//			
//			accessToken = element.getAsJsonObject().get("access_token").getAsString();
//			refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
//			
//			br.close();
//			bw.close();
//		}catch(Exception e) { 
//			e.printStackTrace();
//			
//		}
//		return accessToken;
//	}
//
//}
