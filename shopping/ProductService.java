package shopping;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ProductService {
	private Scanner sc=new Scanner(System.in);
	private Product product;
	
	public ProductService(Product product) {
		this.product = product;
		
	}
	
	//상품리스트, 상품등록, 상품정보수정, 상품삭제, 상품검색, 종료
	// 제품코드, 제품명, 가격, 사이즈, 색상	VO
	

	public void joinProduct() {	//상품등록
		String pcode, pname, color, size;
		int price, count;
		System.out.println("상품을 추가합니다");
		System.out.print("등록할 상품 코드를 설정하세요 \n");
		pcode = sc.next();
		
		if(product.readProduct(pcode) != null) {
			System.out.println("이미 등록된 상품입니다.");
			return;
		}
		
		System.out.print("상품명을 입력하세요.\n");
		pname = sc.next();

		System.out.print("판매가격을 입력하세요.\n");
		price = sc.nextInt();

		System.out.print("색상을 입력하세요.\n");
		color = sc.next();

		System.out.print("사이즈를 입력하세요.\n");
		size = sc.next();

		System.out.print("입고 수량을 입력하세요.\n");
		count = sc.nextInt();
		
		ProductVO po = new ProductVO();
		
		po.setpCode(pcode);
		po.setpName(pname);
		po.setPrice(price);
		po.setColor(color);
		po.setColor(color);
		po.setSize(size);
		po.setCount(count);
		
		product.insertProduct(po);
		System.out.println("상품이 등록되었습니다.");
		
	}
	
	public void updateProduct() {	//상품정보수정
		String pcode;
		System.out.println("수정 할 상품의 코드를 입력하세요.");
		pcode = sc.next();
		ProductVO po = product.readProduct(pcode);
		
		if(po==null) {
			System.out.println("등록 되어 있는 상푸이 아닙니다.");
			return;
		}
		
		System.out.print("변경 할 상품명을 입력하세요.");
		po.setpName(sc.next());
		System.out.print("변경 할 상품 가격을 입력하세요.");
		po.setPrice(sc.nextInt());
		System.out.print("변경 할 상품 색상을 입력하세요.");
		po.setColor(sc.next());
		System.out.print("변경 할 상품 사이즈를 입력하세요.");
		po.setSize(sc.next());
		System.out.print("변경 할 상품 수량을 입력하세요.");
		po.setCount(sc.nextInt());
		
	}
	
	public void deleteProduct() {	//상품삭제
		String pcode;
		System.out.print("삭제 할 상품의 코드를 입력하세요");
		pcode = sc.next();
		ProductVO po = product.readProduct(pcode);
		if (po == null) {
			System.out.println("등록 되어 있는 상품이 아닙니다.");
			return;
		}

		product.deleteProduct(po);
		System.out.println("상품이 삭제 되었습니다.");
	}
	
	
	public void findProduct() {	//상품검색
		String pname;
		System.out.println("검색할 제품을 입력하세요\n");
		pname = sc.next();
		
		Map<String, ProductVO> slist = product.mapProduct(pname);
		
		
		if(slist.size() == 0) {
			System.out.println("찾으시는 상품이 없습니다.");
			return;
		}
		
		Iterator<String> it = slist.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			ProductVO po = product.readProduct(key);
			System.out.println(po);
		}
		
		
	}
	
}
