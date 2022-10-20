package com.firstserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

//@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
@RequestMapping("/first")
public class TestController {
	
	@PostMapping("/msg")
	@ResponseBody
	public Map<String, Object> message(@RequestBody String data) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(data);
		String test = element.getAsJsonObject().get("test").getAsString();
//		String result = element.getAsJsonObject().get("result").getAsString();
		System.out.println("test : " + test );
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		String result = "통신성공";
		map.put("result",result);
		return map;
	}
}
