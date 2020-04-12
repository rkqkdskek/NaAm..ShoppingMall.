package shopping;

import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private int ch;
	
	private UserService userService;
	private Product product = new ProductImpl();
	private Pay pay = new PayImpl(product);
	private ProductService productservice = new ProductService(product);	
	private Board board = new BoardImpl(product);
	
	
	public Menu(UserService userService){
		this.userService = userService;
	}
	
	public void userMenu() {
		
		System.out.println("'"+userService.loginMember().getName()+"'�� ȯ���մϴ�.");
		board.listBoard();
		product.printProduct();
		
		while(true) {
			System.out.println("\n���θ޴� �� ȸ���޴�");
			
			
			do {
				System.out.print("1.��ٱ���  2.����������  3.�Խ��Ǻ���  4.Q&A�ۼ� �� ����Ʈ  5.ȸ��Ż��  6.�α׾ƿ� => ");
				ch=sc.nextInt();
			}while(ch<1 || ch>6);
			
			if(ch==6) {
				userService.logout();
				break;
			}
			
			switch(ch) {
			case 1: cartMenu(); break;
			case 2: userService.MypageUser(); break;
			case 3: board.boardList(); break;
			case 4: board.qAndainsert(userService.loginMember()); break;
			case 5: userService.delete(); break;
			}
		}
	}


	public void adminMenu() {
		
		while (true) {
			System.out.println("\n���θ޴� �� �����ڸ޴�");
			
			do {
				System.out.print("1.��ǰ����  2.����� 3.ȸ������  4.�Խ��ǰ���  5.���θ޴��� => ");
				ch = sc.nextInt();
			}while(ch<1 || ch>5);
			
			if (ch==5) {
				userService.logout();
				break;
			}

			switch (ch) {
			case 1: productMenu(); break;
			case 2: salesMenu(); break;
			case 3: memberMenu(); break;
			case 4: boardMenu(); break;
			}

		}
	}
	
	public void productMenu() {
		int ch;
		
		while(true) {
			System.out.println("\n���θ޴� �� �����ڸ޴� �� ��ǰ ����");
			do { 
				System.out.print("1.��ǰ ����Ʈ 2.��ǰ ��� 3.��ǰ ���� ���� 4.��ǰ ���� 5.��ǰ �˻� 6.�ڷΰ��� => ");
				ch = sc.nextInt();
			} while (ch < 1 || ch > 6);
			
			if(ch==6) { 
				break;
			}
			
			switch(ch) {
			case 1: product.printProduct(); break;
			case 2: productservice.joinProduct(); break;
			case 3: productservice.updateProduct(); break;
			case 4: productservice.deleteProduct(); break;
			case 5: productservice.findProduct(); break;

			}
		}
}
	
	
	public void boardMenu() {
		while(true) {
			do {
				System.out.println("\n���θ޴� �� �����ڸ޴� �� �Խ��ǰ���");
				System.out.print("1.�������׵��  2.�Խñۺ���  3.Q&A�亯�ޱ�&��ȸ 4.�Խñۻ���  5.�ı⿡���  6.�����ڸ޴��� => ");			
				ch=sc.nextInt();
			}while(ch<1 || ch>6);
		
			if(ch==6) break;
		
			switch(ch) {
			case 1 : board.notice(); break;
			case 2 : board.boardList(); break;
			case 3 : board.qAnda(); break;
			case 4 :  break;
			case 5 :  break;
			}
		}
	}
	
	public void memberMenu() {
				
		do {
			System.out.println("\n���θ޴� �� �����ڸ޴� �� ȸ������");
			System.out.print("1.ȸ������Ʈ  2.ȸ���˻�  3.�����ڸ޴��� => ");
			ch=sc.nextInt();
		}while(ch<1 || ch>3);
		
		if(ch==3) return;
		
		switch(ch) {
		case 1 : userService.userList(); break;
		case 2 : userService.search(); break;
		}
	}
	
	public void cartMenu() {
		
		product.printProduct();
		
		do {
			System.out.println("\n���θ޴� �� ȸ���޴� �� ��ٱ��ϸ޴� ");
			System.out.print("1. ��ǰ��� 2. ��ٱ��� ����Ʈ���� 3.�����ϱ� 4.ȸ���޴� =>");
			ch = sc.nextInt();
		}while(ch<1 || ch>4);
		
		if(ch==4) return;
		
		switch(ch) {
		case 1 : product.cart(userService.loginMember()); break;
		case 2 : product.cartlist(userService.loginMember()); break;
		case 3 : product.insertOrder(userService.loginMember()); break;
		}
	}

	
	public void salesMenu() {
		
		do {
			System.out.println("\n���θ޴� �� �����ڸ޴� �� ����θ޴�");
			System.out.print("1.�Ѹ��⸮��Ʈ 2.����ǰ ������� 3.�����ڸ޴��� => ");
			ch = sc.nextInt();
		} while (ch<1 || ch>3);
		
		if(ch==3) return;
		
		switch(ch) {
		case 1 : pay.pTotalList(); break;
		case 2 : pay.pList(); break;
		}
		
	}
	
	
	
}
