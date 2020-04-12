package shopping;

import java.util.Map;

public interface Product {
	public void insertProduct(ProductVO po);	//��ǰ���
	public void deleteProduct(ProductVO po);	//��ǰ����
	public void printProduct();
	public ProductVO readProduct(String pcode); //��ǰ�ڵ�� �˻�
	public Map<String,ProductVO> mapProduct(String pname);	// ����ǰ���� ��ǰ�˻�
	public Map<String,ProductVO> pmap();

	
	// ===============================================
		public void insertOrder(UserVO bo);	// �ֹ��ϱ�
		public void cart(UserVO bo);			//��ٱ���
		public void cartlist(UserVO bo);		//��ٱ��� ����Ʈ
		public void pCnt();			//����üũ
		public Map<Integer, OrderVO> omap();
}
