package com.freeplay.qa.resource;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.freeplay.qa.dao.AnswerDao;
import com.freeplay.qa.dao.QuestionDao;
import com.freeplay.qa.pojo.Answer;
import com.freeplay.qa.pojo.Question;
import com.freeplay.qa.response.AnswerResponse;
import com.freeplay.qa.response.QuestionResponse;
import com.freeplay.qa.response.Result;
import com.freeplay.qa.util.HibernateSessionFactory;

/**
 * QARessource
 * 
 * @author Fengdalu
 */
@Path("/qa")
public class QAResource {
	/**
	 * Ask A Question
	 * 
	 * @param request
	 * @return
	 */
	@POST
	@Path("ask")
	@Produces({ MediaType.APPLICATION_JSON })
	public QuestionResponse ask(@FormParam("title") String title,
			@FormParam("desc") String description,
			@FormParam("uid") String suid, @Context HttpServletRequest request) {
		QuestionResponse questionResponse = new QuestionResponse();

		HttpSession session = request.getSession(true);
		// Access Control
		if (session.getAttribute("login") != "yes") {
			questionResponse.setResult(Result.DENY.toString());
			return questionResponse;
		}

		// make Insert
		int uid = Integer.parseInt(suid);
		if (QuestionDao.getQuestionByTitle(title) == null) {
			QuestionDao.insert(uid, title, description);
			questionResponse.setResult(Result.SUCCESS.toString());
			int qid = QuestionDao.getQuestionByTitle(title).getQid();
			questionResponse.setQid(String.valueOf(qid));
		}

		return questionResponse;
	}

	/**
	 * get quetsion by qid
	 */
	@GET
	@Path("ask/{qid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Question ask(@PathParam("qid") String qid) {
		try {
			return QuestionDao.getQuestion(Integer.parseInt(qid));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get quetsion by uid
	 */
	@GET
	@Path("user_ask/{uid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Question> askByUid(@PathParam("uid") String uid) {
		try {
			return QuestionDao.getQuestionByUid(Integer.parseInt(uid));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Answer A Question
	 * 
	 * @param request
	 * @return
	 * @return
	 */
	@POST
	@Path("answer")
	@Produces({ MediaType.APPLICATION_JSON })
	public AnswerResponse answer(@FormParam("acontent") String acontent,
			@FormParam("uid") String suid, @FormParam("qid") String sqid,
			@Context HttpServletRequest request) {
		AnswerResponse answerResponse = new AnswerResponse();

		HttpSession session = request.getSession(true);

		// Access Control
		if (session.getAttribute("login") != "yes") {
			answerResponse.setResult(Result.DENY.toString());
			return answerResponse;
		}

		/*
		 * Add Quesion
		 */
		int uid = Integer.parseInt(suid);
		int qid = Integer.parseInt(sqid);
		answerResponse.setResult(Result.SUCCESS.toString());
		AnswerDao.insert(uid, qid, acontent);
		return answerResponse;
	}

	/*
	 * Zan a Question
	 */
	@POST
	@Path("zan")
	@Produces({ MediaType.APPLICATION_JSON })
	public AnswerResponse zan(@FormParam("aid") String aid,
			@Context HttpServletRequest request) {
		AnswerResponse answerResponse = new AnswerResponse();

		HttpSession session = request.getSession(true);

		// Access Control
		if (session.getAttribute("login") != "yes") {
			answerResponse.setResult(Result.DENY.toString());
			return answerResponse;
		}

		Answer answer = AnswerDao.getAnswer(Integer.parseInt(aid));
		System.out.println(aid);
		if (answer != null) {
			answer.setAlevel(answer.getAlevel() + 1);
			HibernateSessionFactory.getSession().save(answer);
			answerResponse.setResult(Result.SUCCESS.toString());
		} else {
			answerResponse.setResult(Result.FAIL.toString());
		}
		return answerResponse;
	}

	/**
	 * get answer by question
	 * 
	 * @param request
	 * @return
	 * @return
	 */
	@GET
	@Path("answer/{qid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Answer> answer(@PathParam("qid") String qid) {
		try {
			return AnswerDao.getAnswerByQid(Integer.parseInt(qid));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * get answer by user
	 * 
	 * @param request
	 * @return
	 * @return
	 */
	@GET
	@Path("user_answer/{uid}")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<Answer> uanswer(@PathParam("uid") String uid) {
		System.out.println(uid);
		try {
			return AnswerDao.getAnswerByUid(Integer.parseInt(uid));
		} catch (Exception e) {
			return null;
		}
	}

}
