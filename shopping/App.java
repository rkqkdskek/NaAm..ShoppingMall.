package shopping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		UserVO loginMember = null;
		UserService userService = new UserService(); 
		
		Menu menu = new Menu(userService);

		int ch;
		try {
			System.out.println("���� �� �� �� �� �� �� ����");
			while (true) {
				loginMember = userService.loginMember();
				
				if (loginMember == null) {
					do {
						System.out.println("\n���θ޴� ");
						
						System.out.print("1.ȸ���α���  2.ȸ������  3.���� => ");
						ch = sc.nextInt();
					} while (ch < 1 || ch > 3);
					
					if(ch==3) System.exit(0);
					
					switch(ch) {
					case 1 : userService.login(); break;
					case 2 : userService.join(); break;
					}
					
				} else if(loginMember.getId().equals("admin") && loginMember.getPwd().equals("1234")) {
					menu.adminMenu();
				} else {
					menu.userMenu();
				}
			}
			
		} catch (InputMismatchException E) {
			System.out.println("���ڸ� �Է°���");
			sc.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sc.close();
		}
	}
}
