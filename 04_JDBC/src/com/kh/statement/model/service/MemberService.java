package com.kh.statement.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;
import java.util.function.Function;

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
	private Connection conn = null;
	
	public MemberService() {
		super();
		this.conn = getConnection();
	}
	
	public int save(Member member) {
		int result = new MemberDao().save(conn,member);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}

	private <T> T executeQurey(Function<Connection, T> daoFunction) {
		Connection conn = null;
		T result = null;
		conn = getConnection();
		result = daoFunction.apply(conn);
		close(conn);
		return result;
	}
	
	public List<Member> findAll() {
		return executeQurey(new MemberDao()::findAll);
	}

	public Member findById(String userId) {
		return executeQurey(conn -> new MemberDao().findById(conn, userId));
	}

	public List<Member> findByKeyword(String keyword) {
		return executeQurey(conn -> new MemberDao().findByKeyword(conn, keyword));
	}

	public int update(PasswordDTO pd) {
		if(pd.getNewPassword().length() > 20) {
			return 0;
		}
		Member member = new MemberDao().findById(conn, pd.getUserId());
		if(member == null) {
			return 0;
		}
		int result = new MemberDao().update(conn, pd);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		
		return result;
	}

	public int delete(Member member) {
		int result = new MemberDao().delete(conn,member);
		if(result > 0) {
			commit(conn);
		}
		close(conn);
		return result;
	}
	
	
	
	
	
	
	
	
	
}
