package shopping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class UserImpl implements User {
	
	private Map<String, UserVO> mapuser = new HashMap<String, UserVO>();
	// map 키 = 아이디 // 값 UserVO

	public UserImpl() { // id, pwd, name, tel, birth, address
		mapuser.put("1", new UserVO("1", "1", "1", "1", "1", "1"));
		mapuser.put("2", new UserVO("2", "2", "2", "2", "2", "2"));
		mapuser.put("3", new UserVO("3", "3", "3", "3", "3", "3"));
		mapuser.put("4", new UserVO("4", "4", "4", "4", "4", "4"));
		mapuser.put("5", new UserVO("5", "5", "5", "5", "5", "5"));
		mapuser.put("6", new UserVO("6", "6", "6", "6", "6", "6"));
		
	}
	
	
	@Override
	public void insertUser(UserVO bo) { // 회원가입
		mapuser.put(bo.getId(), bo);
	}
	
	@Override
	public void deleteUser(UserVO bo) { // 회원탈퇴
		mapuser.remove(bo.getId(), bo);
	}

	@Override
	public UserVO readUser(String id, String pwd) { // 
		
		Iterator<String> it = mapuser.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(key.equals(id)) {
				UserVO bo = findUser(id);
				if(bo.getPwd().equals(pwd)) {
					
					return bo;
				}
			}
		}
		
		return null;
		
	}




	@Override
	public UserVO findUser(String id) {
		Iterator<String> it = mapuser.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(id.equals(key)) {
				return mapuser.get(id);
			}
		}
		return null;
	}
	

	@Override
	public Map<String, UserVO> listuser() {
		
		return mapuser;
	}

	@Override
	public UserVO readUserId(String id) {
		Iterator<String> it = mapuser.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			if(key.equals(id)) {
				UserVO bo = findUser(id);                          
					return bo;
				
			}
		}
		
		return null;
	}
	
	

}
