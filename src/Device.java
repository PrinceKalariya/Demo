
public abstract class Device {

	private String deviceName, deviceType;
	
	
	public Device(String deviceName, String deviceType)
	{
		this.deviceName = deviceName;
		this.deviceType = deviceType;
	}
	
	public abstract void scan();
	public abstract void validate();
	
	
	
}
