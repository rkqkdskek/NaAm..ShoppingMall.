package shopping;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UserService {
	private Scanner sc = new Scanner(System.in);
	private UserVO loginMember = null;
	private Map<String, UserVO> mapuser;

	private User user = new UserImpl();

	public UserVO loginMember() {
		return loginMember;
	}

	public void login() { // �α���

		System.out.println("\nȸ��  �α���");
		
		try {
		System.out.print("���̵� �Է� > ");
		String id = sc.next();
		System.out.print("��й�ȣ�Է� > ");
		String pwd = sc.next();
		
		if (id.equals("admin") && pwd.equals("1234")) {
			UserVO vo = new UserVO();
			vo.setId("admin");
			vo.setName("������");
			vo.setPwd("1234");
			loginMember = vo;
			user.insertUser(vo);
			return;
		}
		
		if(user.readUser(id, pwd) == null) {
			System.out.println("���̵� �������� �ʽ��ϴ�.\n");
			return;
		}
		
		System.out.println("\n");

		UserVO vo = user.readUser(id, pwd);
		
		if (vo.getId() != null && vo.getPwd().equals(pwd)) {
			loginMember = vo;
			return;
		}

		System.out.println("���̵� �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void join() {
		
		System.out.println("\nȸ������");
		
		UserVO bo = new UserVO();
		System.out.print("���̵� > ");
		String id = sc.next();
		if(user.readUser(id, id) != null) {
			System.out.println("�����Ѿ��̵�����");
			return;
		}
		
		bo.setId(id);

		try {
			
			System.out.print("�н����� > ");
			bo.setPwd(sc.next());

			System.out.print("�̸� > ");
			bo.setName(sc.next());

			System.out.print("��ȣ > ");
			bo.setTel(sc.next());

			System.out.print("������� >");
			bo.setBirth(sc.next());

			System.out.print("�ּ� > ");
			bo.setAddress(sc.next());
			
			System.out.println();
			
			user.insertUser(bo);  
			
			System.out.println("������ �ٸ��ټ��θ��� ȫ������ ���� ȹ�� �����\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void logout() { // �α׾ƿ�
		loginMember = null;
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.\n");
	}

	public void delete() {
		System.out.println("ȸ��Ż��");
		String id, pwd;
		System.out.println("Ż���� ȸ�� ���̵� �Է�");
		id = sc.next();
		System.out.println("Ż���� ȸ�� ��й�ȣ");
		pwd = sc.next();
		UserVO bo = user.readUser(id, pwd);
		if(bo == null) {
			System.out.println("ȸ�������Է¿���");
			return;
		}
		
		System.out.println("ȸ��Ż�� �Ϸ�Ǿ����ϴ�.");
		user.deleteUser(bo);
	}

	public void userList() {
		mapuser = user.listuser();

		System.out.println("============== ȸ������Ʈ ===============");
		System.out.println("���̵�\t�̸�\t��ȭ��ȣ\t����\t�ּ�");

		Iterator<String> it = mapuser.keySet().iterator();
		while (it.hasNext()) {
			String id = it.next();
			UserVO vo = mapuser.get(id);

			System.out.print(id + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getTel() + "\t");
			System.out.print(vo.getBirth() + "\t");
			System.out.print(vo.getAddress() + "\n");
		}
		System.out.println("\n==========================================");
	}

	public void search() {

		System.out.print("�˻��� ȸ�����̵�? ");
		String id = sc.next();

		UserVO vo = user.readUserId(id);

		if(vo == null) {
			System.out.println("���̵� ã�� �� �����ϴ�.");
			return;
		}
		
		System.out.println("============== ȸ����ȸ ===============");
		System.out.println("���̵�\t�̸�\t��ȭ��ȣ\t����\t�ּ�");
		System.out.print(id + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getTel() + "\t");
		System.out.print(vo.getBirth() + "\t");
		System.out.print(vo.getAddress() + "\t");
		System.out.println("\n==========================================");
	}
	
		public void MypageUser() {
		
		System.out.println("�ٸ��ټ��θ� ��ǰ���");
		System.out.println("====================================");
		System.out.println("���̵�\t�̸�\t��ȭ��ȣ\t�������\t�ּ�\t");
		System.out.println("====================================");
		
		UserVO vo = user.readUserId(loginMember.getId());

			System.out.print(loginMember.getId() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getTel() + "\t");
			System.out.print(vo.getBirth() + "\t");
			System.out.print(vo.getAddress() + "\t");
	System.out.println("\n====================================");
	}

}
