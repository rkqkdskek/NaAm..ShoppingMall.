package shopping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class ProductImpl implements Product {
	private Map<String, ProductVO> productlist = new HashMap<String, ProductVO>();
	private Map<String, OrderVO> orderlist = new HashMap<String, OrderVO>();	// 장바구니 리스트
	private Map<Integer, OrderVO> order = new HashMap<Integer, OrderVO>();
	private Scanner sc = new Scanner(System.in);

	public ProductImpl() { // 기본 제품 정보 // 제품코드, 제품명, 가격, 사이즈, 색상
		productlist.put("001", new ProductVO("001", "아디도스 오리지날 후드티", 500000, "Black", "XL", 10));
		productlist.put("002", new ProductVO("002", "아디도스 오리지날 후드티", 500000, "Black", "L", 10));
		productlist.put("003", new ProductVO("003", "아디도스 오리지날 후드티", 500000, "Black", "M", 10));
		productlist.put("004", new ProductVO("004", "아디도스 오리지날 후드티", 500000, "Black", "S", 10));
		productlist.put("005", new ProductVO("005", "데상트 트레포일 후드티", 30000, "White", "XL", 10));
		productlist.put("006", new ProductVO("006", "데상트 트레포일 후드티", 30000, "White", "L", 10));
		productlist.put("007", new ProductVO("007", "데상트 트레포일 후드티", 30000, "White", "M", 10));
		productlist.put("008", new ProductVO("008", "데상트 트레포일 후드티", 30000, "White", "S", 10));
		productlist.put("009", new ProductVO("009", "쌍용 요다 반팔티", 9999, "Blue", "XL", 10));
		productlist.put("010", new ProductVO("010", "쌍용 요다 반팔티", 9999, "Blue", "L", 10));
		productlist.put("011", new ProductVO("011", "쌍용 요다 반팔티", 9999, "Blue", "M", 10));
		productlist.put("012", new ProductVO("012", "쌍용 요다 반팔티", 9999, "Blue", "S", 10));
		productlist.put("013", new ProductVO("013", "라이키 이클립스 민트향", 500, "Black", "XL", 10));
		productlist.put("014", new ProductVO("014", "라이키 이클립스 민트향", 500, "Black", "L", 10));
		productlist.put("015", new ProductVO("015", "라이키 이클립스 민트향", 500, "Black", "M", 10));
		productlist.put("016", new ProductVO("016", "라이키 이클립스 민트향", 500, "Black", "S", 10));
		productlist.put("017", new ProductVO("017", "라이키 이클립스 민트향", 500, "White", "XL", 10));
		productlist.put("018", new ProductVO("018", "쌍용교육센터 ", 99999, "Blue", "M", 10));
	
	}

	@Override
	public void insertProduct(ProductVO po) { //
		productlist.put(po.getpCode(), po);

	}

	@Override
	public void deleteProduct(ProductVO po) {
		productlist.remove(po.getpCode(), po);

	}

	@Override // 상품코드로 검색
	public ProductVO readProduct(String pcode) {
		Iterator<String> it = productlist.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			ProductVO po = productlist.get(key);

			if (key.equals(pcode)) {
				return po;
			}

		}
		return null;
	}

	@Override
	public Map<String, ProductVO> mapProduct(String pname) {
		Map<String, ProductVO> slist = new HashMap<String, ProductVO>();
		Iterator<String> it = productlist.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			ProductVO value = productlist.get(key);
			if (value.getpName().indexOf(pname) >= 0) {
				slist.put(key, value);
			}
		}
		return slist;
	}
	
	@Override
	public void printProduct() {	//상품목록(리스트)출력
		System.out.println("\n♣ 바른다쇼핑몰 상품목록  ♣");
		System.out.println("=====================================================");
		System.out.println("제품코드\t제품명\t\t\t가격\t사이즈\t색상\t");
		System.out.println("=====================================================");
		//
		Iterator<String> it = productlist.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			ProductVO po = productlist.get(key);
			System.out.print(po.getpCode()+"\t");
			System.out.print(po.getpName()+"\t\t");
			System.out.print(po.getPrice()+"\t");
			System.out.print(po.getSize()+"\t");
			System.out.println(po.getColor()+"\t");
		}
		
		System.out.println("=====================================================");
	}

	@Override
	public  Map<String,ProductVO> pmap() {
		return productlist;
	}
	
	@Override
	public void insertOrder(UserVO bo) { // 결제	
		
		int tot=0;
		int cnt=1;
		Iterator<String> it = orderlist.keySet().iterator();

		System.out.println("\n====================== 결 제 =========================");
		while (it.hasNext()) {
			String key = it.next();
			OrderVO ov = orderlist.get(key);
			if (ov.getUserId().equals(bo.getId())) {
				System.out.print(key + "\t");
				System.out.print(ov.getPname() + "\t\t");
				System.out.print(ov.getPrice() + "\t");
				System.out.print(ov.getSize() + "\t");
				System.out.print(ov.getColor() + "\n");
				tot += ov.getPrice();
				order.put(cnt,ov);
			} 
			
		}
		System.out.println("=====================================================");
		
		System.out.println("장바구니에 있는 모든 상품을 결제 합니다.");
		
		System.out.println("총 결제 금액은 : " + tot + " 입니다.");
	
		// 결제하면 장바구니 목록 삭제
		orderlist.clear();
	

	}
	
	
	
	@Override
	public void cart(UserVO bo) {	//장바구니 담기

		OrderVO ov = new OrderVO();
		ProductVO po;
		String pcode;

		String check = "";

		do {

			System.out.print("장바구니에 담을 상품을 골라주세요.[상품코드] ");
			pcode = sc.next();

			po = readProduct(pcode);

			if (po == null) {
				System.out.println("없는 상품입니다.");
				break;
			}

			ov.setPname(po.getpName());
			ov.setPrice(po.getPrice());
			ov.setSize(po.getSize());
			ov.setColor(po.getColor());
			ov.setUserId(bo.getId());

			orderlist.put(pcode, ov);

			System.out.println("선택하신 상품이 장바구니에 추가되었습니다.\n");

			System.out.print("상품을 계속 담으시겠습니까? [Y/N]");

			check = sc.next();

		} while (check.equals("Y") || check.equals("y"));
		
	}
	
	
	@Override
	public void cartlist(UserVO bo) {
		System.out.println("\n♣ 나의 장바구니 리스트 ♣");
		System.out.println("=====================================================");
		System.out.println("제품코드\t제품명\t\t\t가격\t사이즈\t색상");
		System.out.println("=====================================================");
		Iterator<String> it = orderlist.keySet().iterator();

		// 해당하는 아이디에 맞는 장바구니 목록만 가져옴
		
		while (it.hasNext()) {
			String key = it.next();
			OrderVO ov = orderlist.get(key);
			if (ov.getUserId().equals(bo.getId())) {
				System.out.print(key + "\t");
				System.out.print(ov.getPname() + "\t\t");
				System.out.print(ov.getPrice() + "\t");
				System.out.print(ov.getSize() + "\t");
				System.out.print(ov.getColor() + "\n");

			}
		}

		System.out.println("=====================================================");

	}

	@Override
	public void pCnt() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Integer, OrderVO> omap() {

		return order;
	}

}
