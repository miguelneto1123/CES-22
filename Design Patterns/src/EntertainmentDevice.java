
public abstract class EntertainmentDevice {
	protected int deviceState;
	protected int maxSetting;
	private int volumeLevel = 0;
	
	public abstract void buttonRightPressed();
	public abstract void buttonLeftPressed();
	
	public void deviceFeedback() {
		if (deviceState > maxSetting || deviceState < 0) { deviceState = 0; }
		System.out.println("On channel " + deviceState);
	}
	
	public void buttonUpPressed() {
		volumeLevel++;
		System.out.println("Volume at " + volumeLevel);
	}
	
	public void buttonDownPressed() {
		volumeLevel--;
		System.out.println("Volume at " + volumeLevel);
	}
}
