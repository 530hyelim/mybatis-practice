package com.kh.practice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.practice.model.service.MemberService;
import com.kh.practice.model.service.MemberServiceImpl;
import com.kh.practice.model.vo.Member;

@WebServlet("/member/selectAll")
public class SelectAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberServiceImpl();
       
    public SelectAllMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = service.selectAllMember();
		Gson gson = new Gson();
		response.setContentType("application/json; charset=UTF-8");
		gson.toJson(list, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
