package com.freeplay.qa.response;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * MapResponse To return JSON DATA
 * 
 * @author Fengdalu
 */
@XmlRootElement
public class Response {
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
