package com.kh.view;

import java.util.List;
import java.util.Scanner;

import com.kh.controller.ProductsController;
import com.kh.model.vo.Products;

public class ProductsView {
	private ProductsController pc = new ProductsController();
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			System.out.println("=== 생상품 조회 서비스입니다. ===");
			System.out.println("1. 생산품 추가");
			System.out.println("2. 생상품 전체 조회");
			System.out.println("3. 생상품 식별코드로 조회");
			System.out.println("4. 상품명 업데이트");
			System.out.println("5. 상품 삭제");
			System.out.println("9. 종료");
			System.out.print("메뉴를 선택해주세요 > ");
			int menuNo = sc.nextInt();
			sc.nextLine();

			switch (menuNo) {
			case 1:
				insertProduct();
				break;
			case 2:
				printAll();
				break;
			case 3:
				findBySku();
				break;
			case 4:
				update();
				break;
			case 5:
				delete();
				break;
			case 9:
				System.out.println("서비스를 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력했따이");
			}

		}

	}

	private void insertProduct() {
		System.out.println("\n--- 상품 추가 ---");

		System.out.print("상품 번호 입력 > ");
		int productNo = sc.nextInt();
		sc.nextLine();

		System.out.print("상품명 입력 > ");
		String productName = sc.nextLine();

		System.out.print("SKU 입력(UNIQUE) > ");
		String sku = sc.nextLine();

		System.out.print("카테고리 입력 > ");
		String category = sc.nextLine();

		System.out.print("가격 입력 > ");
		int price = sc.nextInt();

		System.out.print("수량 입력 > ");
		int quantity = sc.nextInt();
		sc.nextLine();

		Products p = new Products(productNo, productName, sku, category, price, quantity);

		int result = pc.insertProducts(p);

		if (result > 0) {
			System.out.println("상품 등록이 성공적으로 완료되었습니다.");
		} else {
			System.out.println("상품 등록에 실패하셨습니다.");
		}
	}

	private void printAll() {
		System.out.println("\n--- 상품 전체 조회 ---");
		List<Products> products = pc.printAll();
		if (products.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		} else {
			for (Products p : products) {
				System.out.println("===============================");
				System.out.println(p.getProduct_No() + "번 상품 정보");
				System.out.print("상품명 : " + p.getProduct_Name() + ", ");
				System.out.print("SKU : " + p.getSku() + ", ");
				System.out.print("카테고리 : " + p.getCategory() + ", ");
				System.out.print("가격 : " + p.getPrice() + ", ");
				System.out.print("수량 : " + p.getQuantity() + ", ");
				System.out.print("등록일 : " + p.getProduct_Date());
				System.out.println();
			}
		}

	}

	private void findBySku() {
		System.out.println("\n--- 식별코드(SKU) 검색 ---");
		System.out.print("검색하실 상품의 식별코드를 입력해주세요. > ");
		String sku = sc.nextLine();

		List<Products> products = pc.findBySku(sku);
		if (products.isEmpty()) {
			System.out.println("조회 결과가 없습니다.");
		} else {
			for (Products p : products) {
				System.out.println("===============================");
				System.out.println(p.getProduct_No() + "번 상품 정보");
				System.out.print("상품명 : " + p.getProduct_Name() + ", ");
				System.out.print("SKU : " + p.getSku() + ", ");
				System.out.print("카테고리 : " + p.getCategory() + ", ");
				System.out.print("가격 : " + p.getPrice() + ", ");
				System.out.print("수량 : " + p.getQuantity() + ", ");
				System.out.print("등록일 : " + p.getProduct_Date());
				System.out.println();
			}
		}
	}
	
	private void update() {
			
			System.out.println("\n상품명 수정 서비스 입니다.");
			
			// 아이디랑 비밀번호랑 새 비밀번호 받아서
			// 아이디랑 비밀번호가 있는거 있으면 새 비밀번호로 바꾸기
			System.out.print("카테고리를 입력해주세요 > ");
			String category = sc.nextLine();
			System.out.print("상품명을 입력해주세요 > ");
			String productName = sc.nextLine();
			System.out.print("새 상품명을 입력해주세요 > ");
			String newName = sc.nextLine();
			
			int result = pc.update(category, productName, newName);
			
			if(result > 0) {
				System.out.println("비밀번호 변경에 성공했습니다.");
			} else {
				System.out.println("비밀번호가 다릅니다.");
			}
		}
		
		private void delete() {
			System.out.println("삭제 서비스 ");
			System.out.print("삭제할 상품의 카테고리를 입력해주세요 > ");
			String category = sc.nextLine();
			System.out.print("삭제할 상품명 입력해주세요 > ");
			String productName = sc.nextLine();
			
			int result = pc.delete(category, productName);
			
			if(result > 0) {
				System.out.println("삭제에 성공했습니다.");
			} else {
				System.out.println("삭제에 실패했습니다.");
			}
		}
	
}
