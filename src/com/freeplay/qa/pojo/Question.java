package com.freeplay.qa.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Question implements Comparable<Question> {

	private int qid;
	private int uid;
	private String qtitle;
	private String qcontent;
	private Date starttime;
	private Date endtime;
	private int qstate;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public int getQstate() {
		return qstate;
	}

	public void setQstate(int qstate) {
		this.qstate = qstate;
	}

	public String toString() {
		return this.qtitle + "\n" + this.qcontent;
	}
	
	@Override
	public int compareTo(Question o) {
		if (this.getQid() == o.getQid())
			return 0;
		else if (this.getQid() > o.getQid())
			return -1;
		else
			return 1;
	}
}
