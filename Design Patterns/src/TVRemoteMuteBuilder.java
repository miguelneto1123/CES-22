
public class TVRemoteMuteBuilder implements RemoteBuilder {

	private DeviceRemote remote;
	
	public TVRemoteMuteBuilder(EntertainmentDevice dev) {
		this.remote = new DeviceRemote(dev);
	}
	
	@Override
	public void buildRightButton() {
		remote.setButtonRightAction("Channel Up");
	}

	@Override
	public void buildLeftButton() {
		remote.setButtonLeftAction("Channel Down");
	}

	@Override
	public void buildCenterButton() {
		remote.setButtonCenterAction("TV was muted");
	}

	@Override
	public DeviceRemote getRemote() {
		return this.remote;
	}

}
