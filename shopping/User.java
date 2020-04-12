package shopping;

import java.util.Map;

public interface User {
	public void insertUser(UserVO bo);	//ȸ������
	public void deleteUser(UserVO bo);	//ȸ��Ż��
	public UserVO readUser(String id, String pwd); //ȸ��������ȸ �˻�
	public UserVO readUserId(String id);
	public UserVO findUser(String id);
	public Map<String,UserVO> listuser();
}
