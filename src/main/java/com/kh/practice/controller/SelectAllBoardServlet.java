package com.kh.practice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.practice.model.service.BoardService;
import com.kh.practice.model.service.BoardServiceImpl;
import com.kh.practice.model.vo.Board;

@WebServlet("/board/selectAllBoard")
public class SelectAllBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardServiceImpl();
       
    public SelectAllBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전체 게시글 목록 조회 후 request scope에 저장.
		List<Board> list = service.selectAllBoard();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/index2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
