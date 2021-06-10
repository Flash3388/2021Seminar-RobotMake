package frc.team3388.robot.subsystems;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.math.Mathf;
import com.flash3388.flashlib.scheduling.Subsystem;
import frc.team3388.robot.io.MagEncoder;

public class DriveSystem extends Subsystem {

    private final SpeedController tankRight;
    private final SpeedController tankLeft;

    private final MagEncoder encoderRight;
    private final MagEncoder encoderLeft;
    private final PigeonIMU mPigeon;

    public DriveSystem(SpeedController right, SpeedController left,
                       MagEncoder encoderRight, MagEncoder encoderLeft,
                       PigeonIMU pigeon) {
        this.tankRight = right;
        this.tankLeft = left;
        this.encoderRight = encoderRight;
        this.encoderLeft = encoderLeft;
        mPigeon = pigeon;
    }

    public double getDistancePassedRightMeters() {
        return -encoderRight.getDistance();
    }

    public double getDistancePassedLeftMeters() {
        return -encoderLeft.getDistance();
    }

    public double getDistancePassedMeters() {
        return (getDistancePassedRightMeters() + getDistancePassedLeftMeters()) / 2.0;
    }

    public double getAngleDegrees() {
        // wrap angle between 0 -> 360
        return Mathf.translateAngle(mPigeon.getFusedHeading());
    }

    public void resetSensors() {
        encoderRight.resetDistance();
        encoderLeft.resetDistance();
        mPigeon.setFusedHeading(0);
    }

    public void resetEncoders() {
        encoderRight.resetDistance();
        encoderLeft.resetDistance();
    }

    public void move(double right, double left) {
        tankRight.set(right);
        tankLeft.set(left);
    }

    public void stop() {
        tankRight.stop();
        tankLeft.stop();
    }
}
