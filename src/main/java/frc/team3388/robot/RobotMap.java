package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.RoboRio;
import com.flash3388.flashlib.hid.HidChannel;

public class RobotMap {

    // HID
    public static final HidChannel XBOX = RoboRio.newHidChannel(0);

    public static final int SHOOTER_SYSTEM_MOTOR = 10;

    public static final int HOPPER_MOTOR = 8;

    public static final int INTAKE_SYSTEM_MOTOR = 0;
    public static final int PISTON_REVERSE_CHANNEL = 5;
    public static final int PISTON_FORWARD_CHANNEL = 6;

    public static final int FEEDERSYSTEM =  9;

    // drive motors
    public static final int DRIVE_RIGHT1 = 1;
    public static final int DRIVE_RIGHT2 = 2;
    public static final int DRIVE_LEFT1 = 5;
    public static final int DRIVE_LEFT2 = 7;

    // TURRET
    public static final int MOTOR_TURRET = 3;
}
