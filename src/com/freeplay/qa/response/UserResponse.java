package com.freeplay.qa.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserResponse extends Response {
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
