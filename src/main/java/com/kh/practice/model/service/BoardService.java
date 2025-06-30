package com.kh.practice.model.service;

import java.util.List;
import java.util.Map;

import com.kh.practice.model.vo.Board;

public interface BoardService {
	List<Board> selectAllBoard();
	Board selectBoardByNo(int boardNo);
	List<Board> searchBoard(Map<String, String> map);
}
