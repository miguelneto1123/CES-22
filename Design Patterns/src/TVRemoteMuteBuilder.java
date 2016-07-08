
public class TVRemoteMuteBuilder implements RemoteBuilder {

	private DeviceRemote remote;
	
	public TVRemoteMuteBuilder() {
		this.remote = new DeviceRemote();
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
