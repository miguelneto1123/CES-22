
public class TVDevice extends EntertainmentDevice {
	
	public TVDevice (int newDeviceState, int newMaxSetting) {
		this.deviceState = newDeviceState;
		this.maxSetting = newMaxSetting;
	}

	@Override
	public void buttonRightPressed() {
		System.out.println("Channel up");
		deviceState++;
	}

	@Override
	public void buttonLeftPressed() {
		System.out.println("Channel down");
		deviceState--;
	}

}
