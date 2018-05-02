package com.ohhoonim.api.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeoulDataController {
	
	@RequestMapping("/api/concert.do")
	public String concert(@RequestParam Map<String, String> req) {
		
		return "api/concert";
	}
	
	//http://openAPI.seoul.go.kr:8088/(인증키)/xml/SearchConcertDetailService/1/5/23075/ 
	// 61536b7957646f6e363957474a4746
	@RequestMapping("/api/SearchConcertDetailService.do")
	@ResponseBody
	public Object SearchConcertDetailService( @RequestParam Map<String, String> req) throws Exception {
		String authKey = "61536b7957646f6e363957474a4746";
		String service = "SearchConcertDetailService";
		int startPage = 1;
		int endPage = 5;
		StringBuffer strUrl = new StringBuffer();
		strUrl = strUrl.append("http://openAPI.seoul.go.kr:8088/"); 
		strUrl = strUrl.append(authKey); 
		strUrl = strUrl.append("/json/"); 
		strUrl = strUrl.append(service); 
		strUrl = strUrl.append("/"); 
		strUrl = strUrl.append(startPage); 
		strUrl = strUrl.append("/"); 
		strUrl = strUrl.append(endPage); 
		strUrl = strUrl.append("/"); 
		
		URL url = new URL(strUrl.toString());
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		StringBuffer xml = new StringBuffer();
		String line = "";
		while((line = br.readLine()) != null) {
			xml = xml.append(line);
		}
		
		br.close();
		
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		rtnMap.put("xml", xml.toString());
		
		return rtnMap;
	}
}
