
public class Offer {
	
	private int price = 0;
	private String product = "";
	private int colleagueCode = 0;
	
	public Offer(int value, String prod, int collCode) {
		price = value;
		product = prod;
		colleagueCode = collCode;
	}
	
	public int getPrice() { return price; }
	public String getProduct() { return product; }
	public int getCollCode() { return colleagueCode; }

}
