package com.hiddenleaf.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.hiddenleaf.service.dto.RestEmailDTO;  

@Component
public class EmailWorkFlow {
	
	@Autowired
	RestTemplate restTemplate;
	
	public Boolean emailProcess(RestEmailDTO restEmailDTO) { 
		return emailProcess(restEmailDTO,null);
	}
	
	public Boolean emailProcess(RestEmailDTO restEmailDTO,FileSystemResource file) {   
		String notificationURL = "http://13.126.173.6:9092/";
		String url = notificationURL + "api/sendEmail"; 
		LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();   
		
		System.out.println("restEmailDTO.getIsFileAttached()-->"+restEmailDTO.getIsFileAttached());
		
		map.add("mailContent", restEmailDTO);
				
		if(restEmailDTO.getIsFileAttached() && file!=null) {
			map.add("fileList", file);
		}

		HttpHeaders headers = new HttpHeaders();  
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);   
		HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(  
				map, headers);    
		System.out.println("request Entity" + requestEntity.toString());
		try {
		  ResponseEntity<Boolean> result = restTemplate.postForEntity(url, requestEntity, Boolean.class);
		  return result.getBody(); 
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured : " + e.toString());
		}
		 return new Boolean(false) ;
		}       
} 
