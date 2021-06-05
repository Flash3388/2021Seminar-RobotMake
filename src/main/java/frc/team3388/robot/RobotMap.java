package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.RoboRio;
import com.flash3388.flashlib.hid.HidChannel;

public class RobotMap {

    // EXAMPLE SYSTEM
    public static final int EXAMPLE_SYSTEM_MOTOR = 5;

    // HID
    public static final HidChannel XBOX = RoboRio.newHidChannel(0);
    public static final int HOPPER_MOTOR = 6;
    public static final int HOPPER_PROXIMITY_TALON = 7;
}
