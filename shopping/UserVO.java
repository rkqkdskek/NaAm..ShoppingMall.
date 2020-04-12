package shopping;

public class UserVO {
	private String id;
	private String pwd;
	private String name;
	private String tel;
	private String birth;
	private String address;
	
	public UserVO() {
		
	}
	
	public UserVO(String id,String pwd,String name,String tel,String birth,String address) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.tel = tel;
		this.birth = birth;
		this.address = address;
	}
	
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
