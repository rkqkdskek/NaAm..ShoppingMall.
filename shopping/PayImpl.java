package shopping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PayImpl implements Pay{
	  private Map<String, ProductVO> pmap;
	   private Map<Integer, OrderVO> omap;
	   private Map<Integer, PayVO> paymap = new HashMap<>();

	   private Product product;

	   private int tot = 0;
	   private ProductVO pvo;
	   private OrderVO ovo;

	   public PayImpl(Product product) {
	      this.product = product;
	   }

	   @Override
	   public void pTotalList() {	// �� ���� ����Ʈ

		  omap = product.omap();
		  int cnt = 1;
		   
	      System.out.println("\n=============== �� ���� ����Ʈ ===============");
	      System.out.println("��ȣ\t��ǰ��\t\t��ǰ����\t���̵�");
	      System.out.println("=========================================");

	      Iterator<Integer> it = omap.keySet().iterator();

	      while (it.hasNext()) {
	         
	    	 Integer key = it.next();
	    	 ovo = omap.get(key);
	        
	         // Ordern���� �����;���
	    	 System.out.print(cnt+"\t");
	         System.out.print(ovo.getPname() + "\t");
	         System.out.print(ovo.getPrice() + "\t");
	         System.out.print(ovo.getUserId() + "\n");
	         
	         tot += ovo.getPrice();
	         
	         cnt++;
	         
	      }
	      
	      System.out.println("=========================================");
	      System.out.println("�Ѹ��� : " + tot);

	      System.out.println();
	   }


	   @Override
	   public void pList() {

		  pSell(); 
		   
		  System.out.println("\n============== ��ü ���� ����Ʈ  ====================");
	      System.out.println("��ǰ��\t\t������\t�ȸ�����\t�ȸ���������");
	      System.out.println("==============================================");
	      
	      // ����Ʈ ���
	      Iterator<Integer> it2 = paymap.keySet().iterator();
	      while (it2.hasNext()) {
	         Integer key = it2.next();
	         PayVO vo = paymap.get(key);

	         System.out.print(vo.getpName() + "\t");
	         System.out.print(vo.getSize() + "\t");
	         System.out.print(vo.getCnt() + "\t"); // �ȸ����������;���
	         System.out.print(vo.getTot()+"\n");
	   

	      }
	      System.out.println("===============================================");
	      System.out.println();
	   }

	   
	   @Override
	   public void pSell() {
		   
		   omap = product.omap();
		   
			  
		   int cnt = 0;
		   pmap = product.pmap();
		   
		   
		   // ��ǰ ����� �������� Iterator
		   Iterator<String> it2 = pmap.keySet().iterator();
		   while (it2.hasNext()) {
			   String key = it2.next();
			   pvo = pmap.get(key);
			   PayVO vo = new PayVO();
			   
			   vo.setpName(pvo.getpName());
			   vo.setPrice(pvo.getPrice());
			   vo.setSize(pvo.getSize());
			   vo.setTot(0);
			   vo.setCnt(0);

			   paymap.put(cnt,vo);
			   cnt++;
		   }
		   
		   
		   // ��ǰ�� orderlist�� �������� Iterator
		   Iterator<Integer> it1 = omap.keySet().iterator();
		   while (it1.hasNext()) {
			   Integer key = it1.next();
			   ovo = omap.get(key);
			 
			   // orderlist ��ǰ�̸����� �ȸ� ������ Ȯ���ϴ°�
			   Iterator<Integer> it3 = paymap.keySet().iterator();
			   while (it3.hasNext()) {
				   int key1 = it3.next();
				   PayVO vo = paymap.get(key1);
				   
				   if(vo.getpName() ==  ovo.getPname() || vo.getSize() == ovo.getSize()) {
					   vo.setCnt(vo.getCnt()+1);
					   vo.setTot(vo.getTot()+vo.getPrice());
				   }
				   				   
			   }
			   
		   }
		   
		  
		   
	   }


	
}
