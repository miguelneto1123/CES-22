
public class DeviceRemote implements RemotePlan {
	
	private String actionRight;
	private String actionLeft;
	private String actionCenter;
	private String actionUp = "Volume up";
	private String actionDown = "Volume down";

	@Override
	public void setButtonRightAction(String actionRight) {
		this.actionRight = actionRight;
	}

	@Override
	public void setButtonLeftAction(String actionLeft) {
		this.actionLeft = actionLeft;
	}

	@Override
	public void setButtonCenterAction(String actionCenter) {
		this.actionCenter = actionCenter;
	}
	
	public String getButtonRightAction() { return actionRight; }
	public String getButtonLeftAction() { return actionLeft; }
	public String getButtonCenterAction() { return actionCenter; }
	public String getButtonUpAction() { return actionUp; }
	public String getButtonDownAction() { return actionDown; }

}
