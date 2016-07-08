
public abstract class Colleague {

	private Mediator mediator;
	private int colleagueCode;
	
	public Colleague(Mediator newMed) {
		mediator = newMed;
		mediator.addColleague(this);
	}
	
	public void saleOffer(String prod, int value) {
		mediator.saleOffer(prod, value, this.colleagueCode);
	}
	
	public void buyOffer(String prod, int value){
		mediator.buyOffer(prod, value, this.colleagueCode);
	}
	
	public void setCollCode(int code) { colleagueCode = code; }
	
}
