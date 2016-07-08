import java.util.ArrayList;

public class MarketMediator implements Mediator {
	
	private ArrayList<Colleague> colleagues;
	private ArrayList<Offer> buyOffers;
	private ArrayList<Offer> sellOffers;
	
	private int colleagueCodes = 0;
	
	public MarketMediator() {
		colleagues = new ArrayList<Colleague>();
		buyOffers = new ArrayList<Offer>();
		sellOffers = new ArrayList<Offer>();
	}

	@Override
	public void saleOffer(String prod, int value, int colleagueCode) {
		 boolean prodSold = false;
		 
		 for (Offer offer : buyOffers) {
			 if((offer.getProduct() == prod) && (offer.getPrice() == value)) {
				 System.out.println(prod + " sold for " + value + " to " + offer.getCollCode());
				 buyOffers.remove(offer);
				 prodSold = true;
			 }
			 
			 if (prodSold) { break; }
		 }
		 
		 if (!prodSold) {
			 System.out.println(prod + " with price " + value + " added to inventory");
			 Offer newOffer = new Offer(value, prod, colleagueCode);
			 sellOffers.add(newOffer);
		 }

	}

	@Override
	public void buyOffer(String prod, int value, int colleagueCode) {
		boolean prodBought = false;
		 
		 for (Offer offer : sellOffers) {
			 if((offer.getProduct() == prod) && (offer.getPrice() == value)) {
				 System.out.println(prod + " bought for " + value + " by " + offer.getCollCode());
				 sellOffers.remove(offer);
				 prodBought = true;
			 }
			 
			 if (prodBought) { break; }
		 }
		 
		 if (!prodBought) {
			 System.out.println(prod + " with price " + value + " added to inventory");
			 Offer newOffer = new Offer(value, prod, colleagueCode);
			 buyOffers.add(newOffer);
		 }

	}

	@Override
	public void addColleague(Colleague colleague) {
		 colleagues.add(colleague);
		 colleagueCodes++;
		 colleague.setCollCode(colleagueCodes);
	}
	
	public void getMarketOfferings() {
		System.out.println("\nProducts for sale");
		for (Offer offer : sellOffers) {
			System.out.println(offer.getProduct() + " at " + offer.getPrice());
		}
		
		System.out.println("\nProducts to buy");
		for (Offer offer : buyOffers) {
			System.out.println(offer.getProduct() + " at " + offer.getPrice());
		}
	}

}
