package application;

/**
 * Simple data-only class that represents one log entry in the lunar lander motion history log.
 * The fields of this class are public to make them easier to access without needing getters/setters.
 * This is ok because this class has no significant functionality (no methods except constructor).
 */
public class LogEntry {
	public double _time;     // Time in seconds
	public double _height;   // Height in meters
	public double _vel;      // Velocity in meters per second

	public LogEntry(double time, double height, double vel) {
		_time = time;
		_height = height;
		_vel = vel;
	}
}



































































