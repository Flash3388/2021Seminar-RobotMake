package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.control.Direction;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.math.Mathf;
import com.flash3388.flashlib.robot.control.PidController;
import com.flash3388.flashlib.robot.motion.Rotatable;
import com.flash3388.flashlib.scheduling.Subsystem;
import com.jmath.ExtendedMath;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.team3388.robot.io.MagEncoder;

public class TurretSystem extends Subsystem implements Rotatable {

    private static final double MAX_SPEED = 0.25;
    private static final double MAX_ANGLE = 110;

    private final SpeedController controller;
    private final MagEncoder encoder;
    private final PidController pid;

    public TurretSystem(SpeedController controller, MagEncoder encoder) {
        this.controller = controller;
        this.encoder = encoder;
        encoder.resetDistance();

        final double KP = 0.5;
        final double KI = 0.1;
        final double KD = 0.2;
        pid = new PidController(KP, KI, KD, 0.0);
        pid.setOutputLimit(-MAX_SPEED, MAX_SPEED);
    }

    public void resetAngle() {
        encoder.resetDistance();
    }

    public double getAngleDegrees() {
        return encoder.getDistance();
    }

    public boolean canRotateTo(Direction direction) {
        switch (direction) {
            case FORWARD: return getAngleDegrees() <= MAX_ANGLE;
            case BACKWARD: return getAngleDegrees() >= -MAX_ANGLE;
        }
        throw new AssertionError();
    }

    @Override
    public void rotate(double speed) {
        speed = ExtendedMath.constrain(speed, -MAX_SPEED, MAX_SPEED);
        if (!canRotateTo(direction(speed))) {
            speed = 0.0;
        }
        Debug.getLogger().debug("speed: {}, angle: {}", speed, getAngleDegrees());
        controller.set(speed);
    }

    public void pidRotate(double targetAngle) {
        double speed = pid.applyAsDouble(getAngleDegrees(), targetAngle);
        rotate(speed);
    }

    @Override
    public void stop() {
        controller.stop();
    }

    public Direction direction(double speed) {
        if (speed >= 0) {
            return Direction.FORWARD;
        }
        return Direction.BACKWARD;
    }
}
