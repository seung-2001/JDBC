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
			case 9:
				return;
			default:
				System.out.println("서비스를 종료합니다.");
				return;
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

}
