package com.kh.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.view.EmployeeView;

public class EmployeeRun {

	public static void main(String[] args) {
		JDBCTemplate.registerDriver();
		/*
		Properties prop = new Properties();
		
		try {
			//prop.store(new FileOutputStream("driver.properties"), "setting for DBMS");
			prop.storeToXML(new FileOutputStream("member-mapper.xml"), "MEMBER SQL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		EmployeeView employee = new EmployeeView();
		employee.mainMenu();
	}

}
