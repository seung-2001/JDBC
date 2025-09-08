package com.kh.statement.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.statement.model.dto.PasswordDTO;
import com.kh.statement.model.vo.Member;

public class MemberDao {

	public int save(SqlSession session, Member member) {
		/*
		 * int result = 0;
		 * PreparedStatement pstmt = null;
		 * String sql = prop.getProperty("save"); 
		 * try{
		 * 	pstmt = conn.prepareStatement(sql);
		 *  pstmt.setString(1, member.getUserId());
		 *  pstmt.setString(1, member.getUserPwd());
		 * 	...
		 * 	result = pstmt.excuteUpdate();
		 *  } catch(IOException e){
		 * 		e.printStackTrace();
		 *  } finally{
		 * 		JDBCTemplate.close(pstmt);
		 *  }
		 *  return result;
		 * }
		 * 
		 * Sqlsession이 제공하는 메소드를 통해 SQL문을 찾아서 실행하고 결과도 받아볼 수 있음
		 * sqlSession.SQL문메서도("매퍼파일의namespace.해당SQL문의id속성값");
		 */
		//int result = session.insert("memberMapper.save", member);	
		//return result;
		return session.insert("memberMapper.save", member);
	}

	public List<Member> findAll(SqlSession session) {
		// 조회결과가 존재하지 않는다면 빈 리스트를 반환
		
		return session.selectList("memberMapper.findAll");
	}

	public Member findById(SqlSession session, String userId) {
		//Member member = session.selectOne("memberMapper.findById",userId);
		
		// 조회결과가 존재하지 않다면 null 반환
		return session.selectOne("memberMapper.findById",userId);
	}

	public List<Member> findByKeyword(SqlSession session, String keyword) {
		
		
		
		return session.selectList("memberMapper.findByKeyword", keyword);
	}

	public int update(SqlSession session, PasswordDTO pd) {
		return session.insert("memberMapper.update", pd);
	}

	public int delete(SqlSession session, Member member) {
		return session.delete("memberMapper.delete", member);
	}

	

	
}
