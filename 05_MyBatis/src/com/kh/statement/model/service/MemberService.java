package com.kh.statement.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.common.Template;
import com.kh.statement.model.dao.MemberDao;
import com.kh.statement.model.dto.PasswordDTO;
import com.kh.statement.model.vo.Member;

// 클라이언트의 요청처리
// 제어흐름 --> 컨트롤러
// 핵심로직 실행 --> 서비스
/*
 * 비즈니스 로직 실행(의사결정코드) -> 데이터 가공, 중복 체크, 연산 처리, 암호화
 * 트랜잭션 관리
 * 여러 DAO를 조합
 * 예외 처리 및 변환
 * 보안 및 권한 검사
 */
public class MemberService {
	
	private MemberDao memberDao = new MemberDao();
	
	public int save(Member member) {
		/*
		 * Connection conn = JDBCTemplate.getConnection();
		 * 
		 * int result = new MemberDao().save(conn, member);
		 * 
		 * if(result > 0{
		 * 		JDBCTemplate.close(conn);
		 * }
		 * 
		 * return result;
		 * 
		 * 
		 */
		SqlSession session = Template.getSqlSession();
		
		int result = memberDao.save(session, member);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

	public List<Member> findAll() {
		
		SqlSession session = Template.getSqlSession();
		
		List<Member> members = memberDao.findAll(session);
		
		session.close();
		
		return members;
	}
	
	public Member findById(String userId) {
		
		SqlSession session = Template.getSqlSession();
		
		Member member = memberDao.findById(session, userId);
		
		session.close();
		
		return member;
		
	}
	
	public List<Member> findByKeyword(String keyword){
		
		SqlSession session = Template.getSqlSession();
		
		List<Member> members = memberDao.findByKeyword(session, keyword);
		
		session.close();
		
		return members;
	}

	public int update(PasswordDTO pd) {
		SqlSession session = Template.getSqlSession();
		
		int result = memberDao.update(session, pd);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}

	public int delete(Member member) {
		SqlSession session = Template.getSqlSession();
		
		int result = memberDao.delete(session, member);
		
		if(result > 0) {
			session.commit();
		}
		
		session.close();
		
		return result;
	}
	
	
	
	
	
}
