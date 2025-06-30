package com.kh.practice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.practice.model.service.BoardService;
import com.kh.practice.model.service.BoardServiceImpl;
import com.kh.practice.model.vo.Board;

@WebServlet("/board/search")
public class SearchBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardServiceImpl();
       
    public SearchBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 검색결과를 request scope에 담아서 forward
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		Map<String, String> map = new HashMap<>();
		map.put("searchKey", searchKey);
		map.put("searchValue", searchValue);
		
		List<Board> list = service.searchBoard(map);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/index2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
