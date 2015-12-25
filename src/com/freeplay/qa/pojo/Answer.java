package com.freeplay.qa.pojo;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Answer {
	private int aid;
	private int uid;
	private int qid;
	private String acontent;
	private Date atime;
	private int alevel;
	private int alike;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public int getAlevel() {
		return alevel;
	}
	public void setAlevel(int alevel) {
		this.alevel = alevel;
	}
	
	public String toString()
	{
		return uid + "\n" + acontent;
	}
	public int getAlike() {
		return alike;
	}
	public void setAlike(int alike) {
		this.alike = alike;
	}

}
