package com.kh.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.kh.controller.EmployeeController;
import com.kh.model.vo.Employee;

public class EmployeeView {
	private EmployeeController ec = new EmployeeController();
	private Scanner sc = new Scanner(System.in);
	public void mainMenu() {
		
		while(true) {
			System.out.println("=====================================");
			System.out.println("회사 서비스 메뉴");
			System.out.println("1. 회사원 전체 조회");
			System.out.println("2. 부서별 조회");
			System.out.println("3. 직급별 조회");
			System.out.println("4. 사원 상세 조회");
			System.out.println("5. 상위 급여 사원 조회");
			System.out.println("6. 하위 급여 사원 조회");
			System.out.println("7. 사원 추가");
			System.out.println("8. 사원 정보 수정");
			System.out.println("9. 퇴사 할사람~~");
			System.out.println("0. 종료");
			System.out.print("번호를 입력하세요 > ");
			int menuNo = 11;
			try {
				menuNo = sc.nextInt();
				sc.nextLine();
			} catch(InputMismatchException e) {
				e.printStackTrace();
				System.out.println("야 이것도 입력 못하냐");
			}
		
			
			switch(menuNo) {
			case 1 : findAll(); break;
			case 2 : searchdeptCode();break;
			case 3 : searchjobName(); break;
			case 4 : searchempId();break;
			case 5 : searchTop();break;
			case 6 : searchRow();break;
			case 7 : save();break;
			case 8 : update();break;
			case 9 : delete();break;
			case 0 : return;
			default : System.out.println("잘못 입력했다"); break;
			}
		}
		
	}
	private void findAll() {
		System.out.println("===========================");
		List<Employee> employees = ec.findAll();
		
		if(employees.isEmpty()) {
			System.out.println("결과없음");
		} else {
			for(Employee emp : employees) {
				System.out.print("사번 : " + emp.getEmpId() + ",");
				System.out.print("\t사원명 : " + emp.getEmpName()+ ",");
				System.out.print("\t급여 : " + emp.getSalary()+ ",");
				System.out.print("\t부서명 : " + emp.getDeptCode()+ ",");
				System.out.print("\t부서명 : " + emp.getJobCode());
				System.out.println();
				
			}
		}
		
	}

	private void searchdeptCode() {
		System.out.println("============================");
		System.out.println("부서별 사원 조회 입니다.");
		System.out.print("부서를 입력해주세요 : ");
		String deptcode = sc.nextLine();
		
		List<Employee> employees = ec.searchdeptCode(deptcode);
		
		if(employees.isEmpty()) {
			System.out.println("결과없음");
		} else {
			for(Employee emp : employees) {
				System.out.print("사번 : " + emp.getEmpId() + ",");
				System.out.print("\t사원명 : " + emp.getEmpName()+ ",");
				System.out.print("\t급여 : " + emp.getSalary()+ ",");
				System.out.print("\t부서명 : " + emp.getDeptCode()+ ",");
				System.out.print("\t부서명 : " + emp.getJobCode());
				System.out.println();
				
			}
		}
		
		
		
	}
	private void searchjobName() {
		System.out.println("==============================");
		System.out.println("직급별 사원 조회 입니다.");
		System.out.print("직급을 입력해주세요 : ");
		String jobname = sc.nextLine();
		
		List<Employee> employees = ec.searchjobName(jobname);
		
		if(employees.isEmpty()) {
			System.out.println("결과없음");
		} else {
			for(Employee emp : employees) {
				System.out.print("사번 : " + emp.getEmpId() + ",");
				System.out.print("\t사원명 : " + emp.getEmpName()+ ",");
				System.out.print("\t급여 : " + emp.getSalary()+ ",");
				System.out.print("\t부서명 : " + emp.getDeptCode()+ ",");
				System.out.print("\t부서명 : " + emp.getJobCode());
				System.out.println();
				
			}
		}
	}
	
	private void searchempId() {
		System.out.println("사원 상세 조회입니다.");
		System.out.print("사번을 입력해주세요 : ");
		String empId = sc.nextLine();
		
		Employee employee  = ec.searchempId(empId);
		
		if(employee != null) {
			System.out.print("사번 : " + employee.getEmpId() + ",");
			System.out.print("\t사원명 : " + employee.getEmpName()+ ",");
			System.out.print("\t급여 : " + employee.getSalary()+ ",");
			System.out.print("\t부서명 : " + employee.getDeptCode()+ ",");
			System.out.print("\t부서명 : " + employee.getJobCode());
			System.out.println();
		}
		
	}
	
	private void searchTop() {
		System.out.println("급여 Top5 사원");
		List<Employee> employees = ec.searchTop();
		
		if(employees.isEmpty()) {
			System.out.println("결과없음");
		} else {
			for(Employee emp : employees) {
				System.out.print("사번 : " + emp.getEmpId() + ",");
				System.out.print("\t사원명 : " + emp.getEmpName()+ ",");
				System.out.print("\t급여 : " + emp.getSalary()+ ",");
				System.out.print("\t부서명 : " + emp.getDeptCode()+ ",");
				System.out.print("\t부서명 : " + emp.getJobCode());
				System.out.println();
				
			}
		}
	}
	private void searchRow() {
		System.out.println("급여 하위5 사원");
		List<Employee> employees = ec.searchRow();
		
		if(employees.isEmpty()) {
			System.out.println("결과없음");
		} else {
			for(Employee emp : employees) {
				System.out.print("사번 : " + emp.getEmpId() + ",");
				System.out.print("\t사원명 : " + emp.getEmpName()+ ",");
				System.out.print("\t급여 : " + emp.getSalary()+ ",");
				System.out.print("\t부서명 : " + emp.getDeptCode()+ ",");
				System.out.print("\t부서명 : " + emp.getJobCode());
				System.out.println();
			}
		}
	}
	private void save() {
		System.out.println("사원 등록 !!");
		System.out.print("사번을 입력하세요 > ");
		String empId = sc.nextLine();
		System.out.print("사원명을 입력하세요 > ");
		String empName = sc.nextLine();
		System.out.print("주민번호를 입력하세요 > ");
		String empNo = sc.nextLine();
		System.out.print("부서코드를 입력하세요 > ");
		String deptCode = sc.nextLine();
		System.out.print("직급코드를 입력하세요 > ");
		String jobCode = sc.nextLine();
		System.out.print("급여등급을 입력하세요 > ");
		String salLevel = sc.nextLine();
		System.out.print("급여를 입력하세요 > ");
		int salary = sc.nextInt();
		sc.nextLine();
		
		int result = ec.save(empId, empName, empNo, deptCode,jobCode, salLevel,salary);
		
		if(result> 0) {
			System.out.println("사원등록에 성공하셨습니다");
		}else {
			System.out.println("사원등록에 실패하셨습니다");
		}
	}
	
	private void update() {
		System.out.println("=======================================");
		System.out.println("사원 정보 수정 메뉴");
		System.out.print("사번을 입력하세요 > ");
		String empId = sc.nextLine();
		System.out.print("부서코드를 입력하세요 > ");
		String deptCode = sc.nextLine();
		System.out.print("직급코드를 입력하세요 > ");
		String jobCode = sc.nextLine();
		System.out.print("급여를 입력하세요 > ");
		int salary = sc.nextInt();
		
		int result = ec.update(empId,deptCode,jobCode,salary);
		if(result> 0) {
			System.out.println("정보수정에 성공하셨습니다");
		}else {
			System.out.println("정보수정에 실패하셨습니다");
		}
	}
	private void delete() {
		System.out.println("=====================================");
		System.out.println("퇴사 기무띵");
		System.out.print("사번을 입력하세요 > ");
		String empId = sc.nextLine();
		int result = ec.delete(empId);
		if(result > 0) {
			System.out.println("퇴사 성공!");
		}else {
			System.out.println("실패ㅐ!");
		}
		
	}
}
