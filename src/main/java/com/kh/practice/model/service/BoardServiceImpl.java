package com.kh.practice.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.kh.practice.common.SqlSessionTemplate;
import com.kh.practice.model.dao.BoardDao;
import com.kh.practice.model.dao.BoardDaoImpl;
import com.kh.practice.model.vo.Board;

public class BoardServiceImpl implements BoardService{
	private BoardDao dao = new BoardDaoImpl();

	@Override
	public List<Board> selectAllBoard() {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Board> list = dao.selectAllBoard(session);
		session.close();
		return list;
	}

	@Override
	public Board selectBoardByNo(int boardNo) {
		SqlSession session = SqlSessionTemplate.getSession();
		Board b = dao.selectBoardByNo(session, boardNo);
		session.close();
		return b;
	}

	@Override
	public List<Board> searchBoard(Map<String, String> map) {
		SqlSession session = SqlSessionTemplate.getSession();
		List<Board> list = dao.searchBoard(session, map);
		session.close();
		return list;
	}

}
