package shopping;

import java.util.Map;

public interface Product {
	public void insertProduct(ProductVO po);	//제품등록
	public void deleteProduct(ProductVO po);	//제품삭제
	public void printProduct();
	public ProductVO readProduct(String pcode); //제품코드로 검색
	public Map<String,ProductVO> mapProduct(String pname);	// 제명품으로 제품검색
	public Map<String,ProductVO> pmap();

	
	// ===============================================
		public void insertOrder(UserVO bo);	// 주문하기
		public void cart(UserVO bo);			//장바구니
		public void cartlist(UserVO bo);		//장바구니 리스트
		public void pCnt();			//수량체크
		public Map<Integer, OrderVO> omap();
}
