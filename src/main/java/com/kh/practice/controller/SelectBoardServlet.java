package com.kh.practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.practice.model.service.BoardService;
import com.kh.practice.model.service.BoardServiceImpl;
import com.kh.practice.model.vo.Board;

@WebServlet("/board/selectBoard")
public class SelectBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardServiceImpl();
       
    public SelectBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Board b = service.selectBoardByNo(Integer.parseInt(request.getParameter("boardNo")));
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(b, response.getWriter());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
