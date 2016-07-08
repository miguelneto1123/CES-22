
public interface Mediator {
	
	public void saleOffer(String prod, int value, int colleagueCode);
	public void buyOffer(String prod, int value, int colleagueCode);
	public void addColleague(Colleague colleague);
}
