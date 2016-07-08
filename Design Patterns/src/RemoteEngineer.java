
public class RemoteEngineer {
	
	private RemoteBuilder remoteBuilder;
	
	public RemoteEngineer(RemoteBuilder remoteBuilder){
		this.remoteBuilder = remoteBuilder;
	}
	
	public DeviceRemote getRemote() {
		return this.remoteBuilder.getRemote();
	}
	public void makeRemote() {
		this.remoteBuilder.buildRightButton();
		this.remoteBuilder.buildLeftButton();
		this.remoteBuilder.buildCenterButton();
	}

}
