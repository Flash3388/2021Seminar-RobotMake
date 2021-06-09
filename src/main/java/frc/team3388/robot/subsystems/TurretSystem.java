package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.math.Mathf;
import com.flash3388.flashlib.robot.motion.Rotatable;
import com.flash3388.flashlib.scheduling.Subsystem;
import com.jmath.ExtendedMath;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.team3388.robot.io.MagEncoder;

public class TurretSystem extends Subsystem implements Rotatable {

    private static final double MAX_SPEED = 0.4;

    private final SpeedController controller;
    private final MagEncoder encoder;

    public TurretSystem(SpeedController controller, MagEncoder encoder) {
        this.controller = controller;
        this.encoder = encoder;
    }

    public void resetAngle() {
        encoder.resetDistance();
    }

    public double getAngleDegrees() {
        return Mathf.translateAngle(encoder.getDistance());
    }

    @Override
    public void rotate(double speed) {
        speed = ExtendedMath.constrain(speed, -MAX_SPEED, MAX_SPEED);
        controller.set(speed);
    }

    @Override
    public void stop() {
        controller.stop();
    }
}
