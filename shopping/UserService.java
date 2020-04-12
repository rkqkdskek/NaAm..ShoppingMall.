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

	public void login() { // 로그인

		System.out.println("\n회원  로그인");
		
		try {
		System.out.print("아이디 입력 > ");
		String id = sc.next();
		System.out.print("비밀번호입력 > ");
		String pwd = sc.next();
		
		if (id.equals("admin") && pwd.equals("1234")) {
			UserVO vo = new UserVO();
			vo.setId("admin");
			vo.setName("관리자");
			vo.setPwd("1234");
			loginMember = vo;
			user.insertUser(vo);
			return;
		}
		
		if(user.readUser(id, pwd) == null) {
			System.out.println("아이디가 존재하지 않습니다.\n");
			return;
		}
		
		System.out.println("\n");

		UserVO vo = user.readUser(id, pwd);
		
		if (vo.getId() != null && vo.getPwd().equals(pwd)) {
			loginMember = vo;
			return;
		}

		System.out.println("아이디 또는 패스워드가 일치하지 않습니다.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

	public void join() {
		
		System.out.println("\n회원가입");
		
		UserVO bo = new UserVO();
		System.out.print("아이디 > ");
		String id = sc.next();
		if(user.readUser(id, id) != null) {
			System.out.println("동일한아이디존재");
			return;
		}
		
		bo.setId(id);

		try {
			
			System.out.print("패스워드 > ");
			bo.setPwd(sc.next());

			System.out.print("이름 > ");
			bo.setName(sc.next());

			System.out.print("번호 > ");
			bo.setTel(sc.next());

			System.out.print("생년월일 >");
			bo.setBirth(sc.next());

			System.out.print("주소 > ");
			bo.setAddress(sc.next());
			
			System.out.println();
			
			user.insertUser(bo);  
			
			System.out.println("◑축축 바른다쇼핑몰로 홍대패피 권한 획득 축축◑\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	public void logout() { // 로그아웃
		loginMember = null;
		System.out.println("로그아웃 되었습니다.\n");
	}

	public void delete() {
		System.out.println("회원탈퇴");
		String id, pwd;
		System.out.println("탈퇴할 회원 아이디 입력");
		id = sc.next();
		System.out.println("탈퇴할 회원 비밀번호");
		pwd = sc.next();
		UserVO bo = user.readUser(id, pwd);
		if(bo == null) {
			System.out.println("회원정보입력오류");
			return;
		}
		
		System.out.println("회원탈퇴가 완료되었습니다.");
		user.deleteUser(bo);
	}

	public void userList() {
		mapuser = user.listuser();

		System.out.println("============== 회원리스트 ===============");
		System.out.println("아이디\t이름\t전화번호\t생일\t주소");

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

		System.out.print("검색할 회원아이디? ");
		String id = sc.next();

		UserVO vo = user.readUserId(id);

		if(vo == null) {
			System.out.println("아이디를 찾을 수 없습니다.");
			return;
		}
		
		System.out.println("============== 회원조회 ===============");
		System.out.println("아이디\t이름\t전화번호\t생일\t주소");
		System.out.print(id + "\t");
		System.out.print(vo.getName() + "\t");
		System.out.print(vo.getTel() + "\t");
		System.out.print(vo.getBirth() + "\t");
		System.out.print(vo.getAddress() + "\t");
		System.out.println("\n==========================================");
	}
	
		public void MypageUser() {
		
		System.out.println("바른다쇼핑몰 상품목록");
		System.out.println("====================================");
		System.out.println("아이디\t이름\t전화번호\t생년월일\t주소\t");
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
