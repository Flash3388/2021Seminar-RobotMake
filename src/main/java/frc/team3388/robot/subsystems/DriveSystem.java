package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;

public class DriveSystem extends Subsystem {

    private final SpeedController tankRight;
    private final SpeedController tankLeft;

    public DriveSystem(SpeedController right, SpeedController left) {
        this.tankRight = right;
        this.tankLeft = left;
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
