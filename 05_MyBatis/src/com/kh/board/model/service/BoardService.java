package com.kh.board.model.service;

import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.dao.BoardRepository;
import com.kh.board.model.dto.BoardDTO;
import com.kh.board.model.vo.Board;
import com.kh.common.JDBCTemplate;
import com.kh.common.Template;
import com.kh.statement.model.service.MemberService;
import com.kh.statement.model.vo.Member;

public class BoardService {
	private Connection conn = null;
	
	public  BoardService(){
		super();
		this.conn  = JDBCTemplate.getConnection();
	}

	public int insertBoard(BoardDTO bd) {
		// 내가 입력한 값을 가지고
		// BOARD테이블에 한 행 INSERT해줘~
		int result = 0;
		
		// 1. 값의 유효성 검증
		if("".equals(bd.getBoardTitle().trim())) {
			return result;
		}
		// 제목 : 안녕하세요, 내용 : 반갑습니다, 아이디 : admin
		// 2. 인증 / 인가
		Member member = new MemberService().findById(bd.getBoardWriter());
		
		if(member != null) {
			int userNo = member.getUserNo();
			Board board = new Board(0, 
									bd.getBoardTitle(),
									bd.getBoardContent(),
									String.valueOf(userNo),
									null,
									null);
			result = new BoardDao().insertBoard(conn,board);
			
		}
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public List<Board> selectBoardList() {
		/*
		List<Board> boards = new BoardDao().selectBoardList(conn);
		new BoardDao().outputHTML(conn);
		JDBCTemplate.close(conn);
		*/
		SqlSession session = Template.getSqlSession();
		
		List<Board> boards = new BoardRepository().selectBoardList(session);
		
		session.close();
		
		return boards;
	}
	
	public Board selectBoard(int boardNo) {
		
		// 아 이거 보드 넘버 시퀀스 가지고 만든건데...
		// 직접 한땀한땀한거 아닌데 시퀀스 가지고 한건데...
		// 1부터 시작인데 이거 막 이상한 숫자 0이하값 들어오면 갈 필요 없는데...
		// DB가면 돈드는데... 아까운데...
		SqlSession session = Template.getSqlSession();
		
		Board board = null;
		
		if(boardNo > 0) {
			board = new BoardRepository().selectBoard(session,boardNo);
		}
		
		session.close();
		
		return board;
	}
	
	public int deleteBoard(int boardNo) {
		int result = new BoardDao().deleteBoard(conn, boardNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
