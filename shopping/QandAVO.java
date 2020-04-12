package shopping;

public class QandAVO {
	private String code;
	private String question;
	private String answer;
	private String userid;
	private String state;
	
	public QandAVO() {
		
	}
	
	public QandAVO(String code, String question, String answer, String userid, String state) {
		this.code = code;
		this.question = question;
		this.answer = answer;
		this.userid = userid;
		this.setState(state);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

	
	
}
