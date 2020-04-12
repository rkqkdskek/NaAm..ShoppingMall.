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
		
		mapboard.put("1",new BoardVO("공지","2019여름시즌","여름샌들7%할인"));
		mapboard.put("2",new BoardVO("공지","2019가을시즌","가을트렌치10%할인"));
		mapboard.put("3",new BoardVO("공지","2019겨울시즌","겨울아우터5%할인"));
	
		mapqa.put(005,new QandAVO("001","28사이즈를입는데 M가맞을까요?","-     ","hyebun","미처리"));
		mapqa.put(015,new QandAVO("001","보라색 재고가 있는지 알고싶어요?","-     ","song-a","미처리"));
	
	}
	
	@Override
	public void notice() {
		
		System.out.print("\n공지사항 등록");
		BoardVO bv = new BoardVO();
		
		System.out.print("번호 > ");
		String num=sc.next();
		
		System.out.print("분류[공지, 글] > ");
		bv.setCategory(sc.next());
		
		System.out.print("제목 > ");
		bv.setTitle(sc.next());
		
		System.out.print("내용 > ");
		bv.setContent(sc.next());
			
		mapboard.put(num,bv);
		
	}

	
	@Override
	public void boardList() {
		System.out.println("\n================== 게 시 판  ===================");
		System.out.println("번호\t분류\t제목\t\t내용");
		
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
		
		System.out.println("♣ 공지사항  ♣");
		System.out.println("=======================================");
		System.out.println("분류\t제목\t\t내용");
		System.out.println("=======================================");
		System.out.print(bv.getCategory()+"\t");
		System.out.print(bv.getTitle()+"\t");
		System.out.print(bv.getContent()+"\n");
		System.out.println("=======================================");

		
	}

	@Override
	public void qAndainsert(UserVO vo) {
		// 사용자가 Q&A 작성하는 메소드
				QandAVO qv = new QandAVO();
				
				product.printProduct();
				
				System.out.print("질문번호? ");
				int num = sc.nextInt();
				
				System.out.print("상품코드? ");
				qv.setCode(sc.next());
						
				System.out.print("질문? ");
				qv.setQuestion(sc.next());
				qv.setUserid(vo.getId());
				qv.setAnswer("-");
				qv.setState("미처리");
				
				mapqa.put(num,qv);
				
				System.out.println("질문이 등록되었습니다.\n");
		
	}

	@Override
	public void qAnda() {
		
		System.out.println("\n============================= Q & A ============================");
		System.out.println("번호\t상품코드\t질문\t\t\t답변\t\t질문자\t처리상황");
		
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
	
		System.out.print("답변할 번호[나가기 : 999]? ");
		int num = sc.nextInt();
		
		if(num==999) return;
		
		QandAVO qv = mapqa.get(num);
		if(qv == null) {
			System.out.println("질문번호가 존재하지 않습니다.\n");
			return;
		}
		
		System.out.print("답변? ");
		qv.setAnswer(sc.next());
		System.out.println("답변을 달았습니다.");
		qv.setState("처리완료");
	}


}



