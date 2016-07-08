
public class TestAll {

	public static void main(String[] args) {
		RemoteBuilder TRM = new TVRemoteMuteBuilder();
		RemoteBuilder TRP = new TVRemotePauseBuilder();
		
		RemoteEngineer re1 = new RemoteEngineer(TRM);
		RemoteEngineer re2 = new RemoteEngineer(TRP);
		
		re1.makeRemote();
		re2.makeRemote();
		
		DeviceRemote tv1 = re1.getRemote();
		DeviceRemote tv2 = re2.getRemote();
		
		System.out.println(tv1.getButtonCenterAction());
		System.out.println(tv2.getButtonCenterAction());
	}

}
