package com.kh.view;

import java.util.Scanner;

public class ProductsView {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			System.out.println("=== 생상품 조회 서비스입니다. ===");
			System.out.println("1. 생산품 추가");
			System.out.println("2. 생상품 전체 조회");
			System.out.println("3. 생상품 식별코드로 조회");
			System.out.println("9. 종료");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1:
				printAll();
				break;
			case 2:
				break;
			case 3:
				break;
			case 9:
				break;
			default:
				System.out.println("서비스를 종료합니다.");
				return;
			}

		}

	}

	private void printAll() {
		System.out.println("========================================");
		
		
	}

}
