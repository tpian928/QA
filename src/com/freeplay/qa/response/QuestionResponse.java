package com.freeplay.qa.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Quesion Resp
 * 
 * @author Fengdalu
 */
@XmlRootElement
public class QuestionResponse extends Response {
	private String qid;

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

}
