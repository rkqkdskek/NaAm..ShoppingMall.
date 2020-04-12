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
	   public void pTotalList() {	// 총 매출 리스트

		  omap = product.omap();
		  int cnt = 1;
		   
	      System.out.println("\n=============== 총 매출 리스트 ===============");
	      System.out.println("번호\t제품명\t\t제품가격\t아이디");
	      System.out.println("=========================================");

	      Iterator<Integer> it = omap.keySet().iterator();

	      while (it.hasNext()) {
	         
	    	 Integer key = it.next();
	    	 ovo = omap.get(key);
	        
	         // Ordern에서 가져와야함
	    	 System.out.print(cnt+"\t");
	         System.out.print(ovo.getPname() + "\t");
	         System.out.print(ovo.getPrice() + "\t");
	         System.out.print(ovo.getUserId() + "\n");
	         
	         tot += ovo.getPrice();
	         
	         cnt++;
	         
	      }
	      
	      System.out.println("=========================================");
	      System.out.println("총매출 : " + tot);

	      System.out.println();
	   }


	   @Override
	   public void pList() {

		  pSell(); 
		   
		  System.out.println("\n============== 전체 물건 리스트  ====================");
	      System.out.println("제품명\t\t사이즈\t팔린수량\t팔린가격집계");
	      System.out.println("==============================================");
	      
	      // 리스트 출력
	      Iterator<Integer> it2 = paymap.keySet().iterator();
	      while (it2.hasNext()) {
	         Integer key = it2.next();
	         PayVO vo = paymap.get(key);

	         System.out.print(vo.getpName() + "\t");
	         System.out.print(vo.getSize() + "\t");
	         System.out.print(vo.getCnt() + "\t"); // 팔린수량가져와야함
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
		   
		   
		   // 제품 목록을 가져오는 Iterator
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
		   
		   
		   // 제품의 orderlist를 가져오는 Iterator
		   Iterator<Integer> it1 = omap.keySet().iterator();
		   while (it1.hasNext()) {
			   Integer key = it1.next();
			   ovo = omap.get(key);
			 
			   // orderlist 제품이름으로 팔린 수량을 확인하는것
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
