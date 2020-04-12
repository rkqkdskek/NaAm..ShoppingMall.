package shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BoardImpl implements Board{
	private Scanner sc = new Scanner(System.in);
	
	private Map<String,BoardVO> mapboard = new HashMap<>();
	private Map<Integer,QandAVO> mapqa = new HashMap<>();
	
	private Product product;
	
	public BoardImpl(Product product) {
		this.product = product;
		
		mapboard.put("1",new BoardVO("����","2019��������","��������7%����"));
		mapboard.put("2",new BoardVO("����","2019��������","����Ʈ��ġ10%����"));
		mapboard.put("3",new BoardVO("����","2019�ܿ����","�ܿ�ƿ���5%����"));
	
		mapqa.put(005,new QandAVO("001","28������Դµ� M���������?","-     ","hyebun","��ó��"));
		mapqa.put(015,new QandAVO("001","����� ��� �ִ��� �˰�;��?","-     ","song-a","��ó��"));
	
	}
	
	@Override
	public void notice() {
		
		System.out.print("\n�������� ���");
		BoardVO bv = new BoardVO();
		
		System.out.print("��ȣ > ");
		String num=sc.next();
		
		System.out.print("�з�[����, ��] > ");
		bv.setCategory(sc.next());
		
		System.out.print("���� > ");
		bv.setTitle(sc.next());
		
		System.out.print("���� > ");
		bv.setContent(sc.next());
			
		mapboard.put(num,bv);
		
	}

	
	@Override
	public void boardList() {
		System.out.println("\n================== �� �� ��  ===================");
		System.out.println("��ȣ\t�з�\t����\t\t����");
		
		Iterator<String> it = mapboard.keySet().iterator();
		while(it.hasNext()) {
			String num = it.next();
			BoardVO bv = mapboard.get(num);
			
			System.out.print(num +"\t");
			System.out.print(bv.getCategory()+"\t");
			System.out.print(bv.getTitle()+"\t");
			System.out.print(bv.getContent()+"\n");
			
		}
		
		System.out.println("============================================");	
	}
	
	
	@Override
	public Map<String,BoardVO> MapBoard() {
		
		return mapboard;
	}
	
	public void listBoard(){
		
		List<BoardVO> list = new ArrayList<>();
		int max = 0;
		BoardVO bv = null;
		
		Iterator<String> it = mapboard.keySet().iterator();
		while(it.hasNext()) {
			String num = it.next();
			
			if(max < Integer.parseInt(num)) {
				max =  Integer.parseInt(num);
				bv = mapboard.get(num);
			}		
			
		}
			
		list.add(bv);
		
		System.out.println("�� ��������  ��");
		System.out.println("=======================================");
		System.out.println("�з�\t����\t\t����");
		System.out.println("=======================================");
		System.out.print(bv.getCategory()+"\t");
		System.out.print(bv.getTitle()+"\t");
		System.out.print(bv.getContent()+"\n");
		System.out.println("=======================================");

		
	}

	@Override
	public void qAndainsert(UserVO vo) {
		// ����ڰ� Q&A �ۼ��ϴ� �޼ҵ�
				QandAVO qv = new QandAVO();
				
				product.printProduct();
				
				System.out.print("������ȣ? ");
				int num = sc.nextInt();
				
				System.out.print("��ǰ�ڵ�? ");
				qv.setCode(sc.next());
						
				System.out.print("����? ");
				qv.setQuestion(sc.next());
				qv.setUserid(vo.getId());
				qv.setAnswer("-");
				qv.setState("��ó��");
				
				mapqa.put(num,qv);
				
				System.out.println("������ ��ϵǾ����ϴ�.\n");
		
	}

	@Override
	public void qAnda() {
		
		System.out.println("\n============================= Q & A ============================");
		System.out.println("��ȣ\t��ǰ�ڵ�\t����\t\t\t�亯\t\t������\tó����Ȳ");
		
		Iterator<Integer> it = mapqa.keySet().iterator();
		while(it.hasNext()) {
			Integer num = it.next();
			QandAVO qv = mapqa.get(num);
			
			System.out.print(num+"\t");
			System.out.print(qv.getCode()+"\t");
			System.out.print(qv.getQuestion()+"\t");
			if(qv.getAnswer()==null) {
				System.out.print("-     "+"\t\t");
			}else {	
				System.out.print(qv.getAnswer()+"\t\t");
			}
			System.out.print(qv.getUserid()+"\t");
			System.out.println(qv.getState());
		}
		
		System.out.println("================================================================\n");
	
		System.out.print("�亯�� ��ȣ[������ : 999]? ");
		int num = sc.nextInt();
		
		if(num==999) return;
		
		QandAVO qv = mapqa.get(num);
		if(qv == null) {
			System.out.println("������ȣ�� �������� �ʽ��ϴ�.\n");
			return;
		}
		
		System.out.print("�亯? ");
		qv.setAnswer(sc.next());
		System.out.println("�亯�� �޾ҽ��ϴ�.");
		qv.setState("ó���Ϸ�");
	}


}



