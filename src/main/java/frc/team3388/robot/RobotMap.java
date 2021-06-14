package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.frc.robot.RoboRio;
import com.flash3388.flashlib.hid.HidChannel;

public class RobotMap {

    // EXAMPLE SYSTEM
    public static final int SHOOTER_SYSTEM_MOTOR = 4;
    // HID
    public static final HidChannel XBOX = RoboRio.newHidChannel(0);
    public static final int HOPPER_MOTOR = 6;
    public static final int INTAKE_SYSTEM_MOTOR = 0;
    public static final int PISTON_REVERSE_CHANNEL = 5;
    public static final int PISTON_FORWARD_CHANNEL = 4;
    public static final int FEEDER_SYSTEM =  1;
    public static final int TURRET_MOTOR = 3;
    //Vision
    public static final String CAMERA_CONTROL_TABLE_NAME = "cameraCtrl";
    public static final String EXPOSURE_ENTRY_NAME = "exposure";
    public static final String VISION_TABLE_NAME = "vision";
    public static final String ALIGNMENT_ERROR_ENTRY_NAME = "angle_degrees";
    public static final String DISTANCE_ENTRY_NAME = "distance_cm";
    public static final String CAMERA_INDEX_ENTRY_NAME = "camera";
    public static final int PROCESSING_EXPOSURE_VALUE = 2;
    public static final int DEFAULT_EXPOSURE_VALUE = 20;
    // drive motors
    public static final int DRIVE_RIGHT1 = 1;
    public static final int DRIVE_RIGHT2 = 2;
    public static final int DRIVE_LEFT1 = 5;
    public static final int DRIVE_LEFT2 = 7;
}
