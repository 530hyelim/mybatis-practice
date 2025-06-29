package com.kh.practice.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.practice.model.vo.Member;

public class MemberDaoImpl implements MemberDao {

	@Override
	public List<Member> selectAllMember(SqlSession session) { // 매개변수 세션 추가함
		return session.selectList("member.selectAllMember");
	}

	@Override
	public Member selectMemberById(SqlSession session, String userId) {
		return session.selectOne("member.selectMemberById", userId);
	}

	@Override
	public int inserMember(SqlSession session, Member m) {
		return session.insert("member.insertMember", m);
	}

	@Override
	public List<Member> selectMemberByName(SqlSession session, String name) {
		return session.selectList("member.selectMemberByName", name);
	}

}
