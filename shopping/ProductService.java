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
	
	//��ǰ����Ʈ, ��ǰ���, ��ǰ��������, ��ǰ����, ��ǰ�˻�, ����
	// ��ǰ�ڵ�, ��ǰ��, ����, ������, ����	VO
	

	public void joinProduct() {	//��ǰ���
		String pcode, pname, color, size;
		int price, count;
		System.out.println("��ǰ�� �߰��մϴ�");
		System.out.print("����� ��ǰ �ڵ带 �����ϼ��� \n");
		pcode = sc.next();
		
		if(product.readProduct(pcode) != null) {
			System.out.println("�̹� ��ϵ� ��ǰ�Դϴ�.");
			return;
		}
		
		System.out.print("��ǰ���� �Է��ϼ���.\n");
		pname = sc.next();

		System.out.print("�ǸŰ����� �Է��ϼ���.\n");
		price = sc.nextInt();

		System.out.print("������ �Է��ϼ���.\n");
		color = sc.next();

		System.out.print("����� �Է��ϼ���.\n");
		size = sc.next();

		System.out.print("�԰� ������ �Է��ϼ���.\n");
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
		System.out.println("��ǰ�� ��ϵǾ����ϴ�.");
		
	}
	
	public void updateProduct() {	//��ǰ��������
		String pcode;
		System.out.println("���� �� ��ǰ�� �ڵ带 �Է��ϼ���.");
		pcode = sc.next();
		ProductVO po = product.readProduct(pcode);
		
		if(po==null) {
			System.out.println("��� �Ǿ� �ִ� ��Ǫ�� �ƴմϴ�.");
			return;
		}
		
		System.out.print("���� �� ��ǰ���� �Է��ϼ���.");
		po.setpName(sc.next());
		System.out.print("���� �� ��ǰ ������ �Է��ϼ���.");
		po.setPrice(sc.nextInt());
		System.out.print("���� �� ��ǰ ������ �Է��ϼ���.");
		po.setColor(sc.next());
		System.out.print("���� �� ��ǰ ����� �Է��ϼ���.");
		po.setSize(sc.next());
		System.out.print("���� �� ��ǰ ������ �Է��ϼ���.");
		po.setCount(sc.nextInt());
		
	}
	
	public void deleteProduct() {	//��ǰ����
		String pcode;
		System.out.print("���� �� ��ǰ�� �ڵ带 �Է��ϼ���");
		pcode = sc.next();
		ProductVO po = product.readProduct(pcode);
		if (po == null) {
			System.out.println("��� �Ǿ� �ִ� ��ǰ�� �ƴմϴ�.");
			return;
		}

		product.deleteProduct(po);
		System.out.println("��ǰ�� ���� �Ǿ����ϴ�.");
	}
	
	
	public void findProduct() {	//��ǰ�˻�
		String pname;
		System.out.println("�˻��� ��ǰ�� �Է��ϼ���\n");
		pname = sc.next();
		
		Map<String, ProductVO> slist = product.mapProduct(pname);
		
		
		if(slist.size() == 0) {
			System.out.println("ã���ô� ��ǰ�� �����ϴ�.");
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
