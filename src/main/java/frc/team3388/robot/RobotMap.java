package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.frc.robot.RoboRio;
import com.flash3388.flashlib.hid.HidChannel;

public class RobotMap {

    // EXAMPLE SYSTEM
    public static final int EXAMPLE_SYSTEM_MOTOR = 5;
    public static final int SHOOTER_SYSTEM_MOTOR=4;
    // HID
    public static final HidChannel XBOX = RoboRio.newHidChannel(0);
    public static final int HOPPER_MOTOR = 6;
    public static final int INTAKE_SYSTEM_MOTOR = 1;
    public static final int PISTON_REVERSE_CHANNEL = 2;
    public static final int PISTON_FORWARD_CHANNEL = 3;
    public static final int FEEDERSYSTEM =  1;


    // drive motors
    public static final int DRIVE_RIGHT1 = 1;
    public static final int DRIVE_RIGHT2 = 2;
    public static final int DRIVE_LEFT1 = 3;
    public static final int DRIVE_LEFT2 = 4;
}
