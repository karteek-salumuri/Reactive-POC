package com.reactive.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.reactive.demo.entity.EPS;
import com.reactive.demo.entity.MainRoot;
import com.reactive.demo.entity.TestClass;
import com.reactive.demo.interfaces.IRequestService;

import reactor.core.publisher.Mono;

@Service
public class RequestService implements IRequestService {

	public String initialRequestProcess(MainRoot mainRoot) {
		
		List<EPS> listEPSObj = mainRoot.getEps();
		List<String> list = new ArrayList<>();
		String str = "";
		
		if (listEPSObj.size() > 0) {
		
			List<Mono<TestClass>> obj = listEPSObj.stream()
					.map(e -> invokeMethodOne(e))
					.collect(Collectors.toList());
			
			if (obj.size() > 0)
			{
				list = obj.stream()
						.map(e -> invokeMethodTwo(e))
						.toList();
				
				if (list.size() > 0)
					str = String.join(",", list);
			}
			else 
				return str;
		}
		else 
			return str;
		
		return str;
	}

	private Mono<TestClass> invokeMethodOne(EPS eps) {
		
		return Mono.just(new TestClass("Test"));
	}
	
	private String invokeMethodTwo(Mono<TestClass> testClass) {
		
		return "Test";
	}
	
}
