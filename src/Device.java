import java.util.ArrayList;
import java.util.List;

public abstract class Device {

	private String deviceName, deviceType;

	public Device(String deviceName, String deviceType) {
		this.deviceName = deviceName;
		this.deviceType = deviceType;
	}

	public abstract void scan();

	public abstract void validate();

	public interface EventInSignalListener {
		void eventInSignal();
	}

	public interface EventOutSignalListener {
		void eventOutSignal(int signal);
	}
}
