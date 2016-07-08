import static org.junit.Assert.*;

import org.junit.Test;

public class designTests {

	@Test
	public void remoteMuteTest() {
		RemoteBuilder TRM = new TVRemoteMuteBuilder(new TVDevice(1, 200));
		RemoteEngineer re1 = new RemoteEngineer(TRM);
		
		re1.makeRemote();
		DeviceRemote tv1 = re1.getRemote();
		
		assertEquals("TV was muted", tv1.getButtonCenterAction());
	}
	
	@Test
	public void remotePauseTest() {
		RemoteBuilder TRP = new TVRemotePauseBuilder(new TVDevice(1, 200));
		RemoteEngineer re1 = new RemoteEngineer(TRP);
		
		re1.makeRemote();
		DeviceRemote tv1 = re1.getRemote();
		
		assertEquals("TV was paused", tv1.getButtonCenterAction());
	}

}
