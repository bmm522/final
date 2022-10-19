package com.firstserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins="http://127.0.0.1:5501/", allowedHeaders="http://127.0.0.1:5501/")
@RestController
@RequestMapping("/first")
public class TestController {
	
	@PostMapping("/msg")
	public Map<String, Object> message(DTO dto) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		System.out.println("통신성공");
		System.out.println(dto.getTest());
		dto.setResult("통신성공");
		System.out.println(dto.getResult());
		map.put("result",dto.getResult());
		return map;
	}
}
