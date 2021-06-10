package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;

public class TurretSystem extends Subsystem {
    private SpeedController turretController;
    private static final double speed = 0.4;

    public TurretSystem(SpeedController turretController) {
        this.turretController = turretController;
    }

    public void moveRight() {
        turretController.set( -speed);
    }

    public void moveLeft() {
        turretController.set(speed);
    }

    public void stopTurret() {
        turretController.stop();
    }
}
