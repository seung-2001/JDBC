package com.kh.statement.run;

import com.kh.common.JDBCTemplate;
import com.kh.common.Template;
import com.kh.statement.view.MemberView;

public class MemberRun {

	public static void main(String[] args) {
		//JDBCTemplate.registerDriver();
		
		//Template.getSqlSession();
		MemberView mv = new MemberView();
		mv.mainMenu();
		
		
	}

}
