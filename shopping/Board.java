package shopping;

import java.util.Map;

public interface Board {
	public void notice(); 		// �Խ���
	public void boardList();	// �Խ��� ����Ʈ
	public Map<String ,BoardVO> MapBoard();	// ��ü����Ʈ ��ȯ
	public void listBoard();	// ����Ʈ
	
	public void qAndainsert(UserVO vo);	// ����
	public void qAnda();	// �����亯

}
