package shopping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class ProductImpl implements Product {
	private Map<String, ProductVO> productlist = new HashMap<String, ProductVO>();
	private Map<String, OrderVO> orderlist = new HashMap<String, OrderVO>();	// ��ٱ��� ����Ʈ
	private Map<Integer, OrderVO> order = new HashMap<Integer, OrderVO>();
	private Scanner sc = new Scanner(System.in);

	public ProductImpl() { // �⺻ ��ǰ ���� // ��ǰ�ڵ�, ��ǰ��, ����, ������, ����
		productlist.put("001", new ProductVO("001", "�Ƶ𵵽� �������� �ĵ�Ƽ", 500000, "Black", "XL", 10));
		productlist.put("002", new ProductVO("002", "�Ƶ𵵽� �������� �ĵ�Ƽ", 500000, "Black", "L", 10));
		productlist.put("003", new ProductVO("003", "�Ƶ𵵽� �������� �ĵ�Ƽ", 500000, "Black", "M", 10));
		productlist.put("004", new ProductVO("004", "�Ƶ𵵽� �������� �ĵ�Ƽ", 500000, "Black", "S", 10));
		productlist.put("005", new ProductVO("005", "����Ʈ Ʈ������ �ĵ�Ƽ", 30000, "White", "XL", 10));
		productlist.put("006", new ProductVO("006", "����Ʈ Ʈ������ �ĵ�Ƽ", 30000, "White", "L", 10));
		productlist.put("007", new ProductVO("007", "����Ʈ Ʈ������ �ĵ�Ƽ", 30000, "White", "M", 10));
		productlist.put("008", new ProductVO("008", "����Ʈ Ʈ������ �ĵ�Ƽ", 30000, "White", "S", 10));
		productlist.put("009", new ProductVO("009", "�ֿ� ��� ����Ƽ", 9999, "Blue", "XL", 10));
		productlist.put("010", new ProductVO("010", "�ֿ� ��� ����Ƽ", 9999, "Blue", "L", 10));
		productlist.put("011", new ProductVO("011", "�ֿ� ��� ����Ƽ", 9999, "Blue", "M", 10));
		productlist.put("012", new ProductVO("012", "�ֿ� ��� ����Ƽ", 9999, "Blue", "S", 10));
		productlist.put("013", new ProductVO("013", "����Ű ��Ŭ���� ��Ʈ��", 500, "Black", "XL", 10));
		productlist.put("014", new ProductVO("014", "����Ű ��Ŭ���� ��Ʈ��", 500, "Black", "L", 10));
		productlist.put("015", new ProductVO("015", "����Ű ��Ŭ���� ��Ʈ��", 500, "Black", "M", 10));
		productlist.put("016", new ProductVO("016", "����Ű ��Ŭ���� ��Ʈ��", 500, "Black", "S", 10));
		productlist.put("017", new ProductVO("017", "����Ű ��Ŭ���� ��Ʈ��", 500, "White", "XL", 10));
		productlist.put("018", new ProductVO("018", "�ֿ뱳������ ", 99999, "Blue", "M", 10));
	
	}

	@Override
	public void insertProduct(ProductVO po) { //
		productlist.put(po.getpCode(), po);

	}

	@Override
	public void deleteProduct(ProductVO po) {
		productlist.remove(po.getpCode(), po);

	}

	@Override // ��ǰ�ڵ�� �˻�
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
	public void printProduct() {	//��ǰ���(����Ʈ)���
		System.out.println("\n�� �ٸ��ټ��θ� ��ǰ���  ��");
		System.out.println("=====================================================");
		System.out.println("��ǰ�ڵ�\t��ǰ��\t\t\t����\t������\t����\t");
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
	public void insertOrder(UserVO bo) { // ����	
		
		int tot=0;
		int cnt=1;
		Iterator<String> it = orderlist.keySet().iterator();

		System.out.println("\n====================== �� �� =========================");
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
		
		System.out.println("��ٱ��Ͽ� �ִ� ��� ��ǰ�� ���� �մϴ�.");
		
		System.out.println("�� ���� �ݾ��� : " + tot + " �Դϴ�.");
	
		// �����ϸ� ��ٱ��� ��� ����
		orderlist.clear();
	

	}
	
	
	
	@Override
	public void cart(UserVO bo) {	//��ٱ��� ���

		OrderVO ov = new OrderVO();
		ProductVO po;
		String pcode;

		String check = "";

		do {

			System.out.print("��ٱ��Ͽ� ���� ��ǰ�� ����ּ���.[��ǰ�ڵ�] ");
			pcode = sc.next();

			po = readProduct(pcode);

			if (po == null) {
				System.out.println("���� ��ǰ�Դϴ�.");
				break;
			}

			ov.setPname(po.getpName());
			ov.setPrice(po.getPrice());
			ov.setSize(po.getSize());
			ov.setColor(po.getColor());
			ov.setUserId(bo.getId());

			orderlist.put(pcode, ov);

			System.out.println("�����Ͻ� ��ǰ�� ��ٱ��Ͽ� �߰��Ǿ����ϴ�.\n");

			System.out.print("��ǰ�� ��� �����ðڽ��ϱ�? [Y/N]");

			check = sc.next();

		} while (check.equals("Y") || check.equals("y"));
		
	}
	
	
	@Override
	public void cartlist(UserVO bo) {
		System.out.println("\n�� ���� ��ٱ��� ����Ʈ ��");
		System.out.println("=====================================================");
		System.out.println("��ǰ�ڵ�\t��ǰ��\t\t\t����\t������\t����");
		System.out.println("=====================================================");
		Iterator<String> it = orderlist.keySet().iterator();

		// �ش��ϴ� ���̵� �´� ��ٱ��� ��ϸ� ������
		
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
