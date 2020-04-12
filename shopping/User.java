package shopping;

import java.util.Map;

public interface User {
	public void insertUser(UserVO bo);	//회원가입
	public void deleteUser(UserVO bo);	//회원탈퇴
	public UserVO readUser(String id, String pwd); //회원정보조회 검색
	public UserVO readUserId(String id);
	public UserVO findUser(String id);
	public Map<String,UserVO> listuser();
}
