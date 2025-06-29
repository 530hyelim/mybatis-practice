package com.kh.practice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.practice.model.service.MemberService;
import com.kh.practice.model.service.MemberServiceImpl;
import com.kh.practice.model.vo.Member;

@WebServlet("/member/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberServiceImpl();
       
    public InsertMemberServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list = service.selectAllMember();
		Member m = new Member(
				list.size() + 1,
				request.getParameter("userId"),
				request.getParameter("userPwd"),
				request.getParameter("userName"),
				request.getParameter("email"));
		int updateCount = service.inserMember(m);
		if (updateCount == 1) response.sendRedirect(request.getContextPath());
		// 아니면 우짜까
	}

}
