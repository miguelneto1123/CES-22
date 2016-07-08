
public class TestAll {

	public static void main(String[] args) {
		RemoteBuilder TRM = new TVRemoteMuteBuilder(new TVDevice(1, 200));
		RemoteBuilder TRP = new TVRemotePauseBuilder(new TVDevice(1, 200));
		
		RemoteEngineer re1 = new RemoteEngineer(TRM);
		RemoteEngineer re2 = new RemoteEngineer(TRP);
		
		re1.makeRemote();
		re2.makeRemote();
		
		DeviceRemote tv1 = re1.getRemote();
		DeviceRemote tv2 = re2.getRemote();
		
//		System.out.println(tv1.getButtonCenterAction());
//		System.out.println(tv2.getButtonCenterAction());
		
//		System.out.println("Test TV with mute");
//		tv1.buttonLeftPressed();
//		tv1.buttonRightPressed();
//		tv1.buttonCenterPressed();
//		tv1.buttonUpPressed();
//		tv1.buttonUpPressed();
//		tv1.buttonUpPressed();
//		tv1.buttonDownPressed();
//		tv1.deviceFeedback();
		
//		System.out.println("\nTest TV with pause");
//		tv2.buttonLeftPressed();
//		tv2.buttonRightPressed();
//		tv2.buttonRightPressed();
//		tv2.buttonRightPressed();
//		tv2.buttonRightPressed();
//		tv2.buttonRightPressed();
//		tv2.buttonCenterPressed();
//		tv2.buttonUpPressed();
//		tv2.buttonUpPressed();
//		tv2.buttonDownPressed();
//		tv2.buttonDownPressed();
//		tv2.deviceFeedback();
		
		MarketMediator mkt = new MarketMediator();
		Salesman s = new Salesman(mkt);
		Consumer c = new Consumer(mkt);
		
		s.saleOffer("Samsung TV", 1200);
		s.saleOffer("LG TV", 1000);
		
		c.buyOffer("LG TV", 1000);
		c.saleOffer("Sony TV", 1500);
		
		s.buyOffer("Sony TV", 1200);
		
		mkt.getMarketOfferings();
	}

}
