package shopping;

public class ProductVO {
	private String pCode;   // ��ǰ�ڵ� 
	private String pName;   // ��ǰ��
	private int price;      // ��ǰ����
	private String color;   // ��ǰ����
	private String size;    // ��ǰ������ 
	private int count;      // ��ǰ���� 
	
	public ProductVO() {
		
	}
	
	public ProductVO(String pCode, String pName, int price, String color, String size, int count) {
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.color = color;
		this.size = size;
		this.count = count;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/*
	@Override
	public String toString() {		
		return pCode+"\t"+pName+"\t"+price+"\t"+color+"\t"+size+"\t"+count+"\t";
	}
	*/
}
