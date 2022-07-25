package com.reactive.demo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.entity.MainRoot;
import com.reactive.demo.interfaces.IRequestService;

@RestController
@RequestMapping("/request")
public class RequestHandlerContoller {
	
	@Autowired
	private IRequestService service;

	@PostMapping(path = "/post-method",consumes = {MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> processRequest(@RequestBody MainRoot data){
		String response = service.initialRequestProcess(data);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}
	
}
