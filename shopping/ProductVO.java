package shopping;

public class ProductVO {
	private String pCode;   // 力前内靛 
	private String pName;   // 力前疙
	private int price;      // 力前啊拜
	private String color;   // 力前祸惑
	private String size;    // 力前荤捞令 
	private int count;      // 力前荐樊 
	
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
