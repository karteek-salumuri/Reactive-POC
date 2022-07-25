package com.reactive.demo.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MainRoot")
public class MainRoot {
	
	@XmlElement(name = "EPS")
	private List<EPS> epsList;

	public List<EPS> getEps() {
		return epsList;
	}

	public void setEps(List<EPS> eps) {
		this.epsList = eps;
	}

}
