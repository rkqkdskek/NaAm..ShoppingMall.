package shopping;

import java.util.Map;

public interface Board {
	public void notice(); 		// 게시판
	public void boardList();	// 게시판 리스트
	public Map<String ,BoardVO> MapBoard();	// 전체리스트 반환
	public void listBoard();	// 리스트
	
	public void qAndainsert(UserVO vo);	// 질문
	public void qAnda();	// 질문답변

}
