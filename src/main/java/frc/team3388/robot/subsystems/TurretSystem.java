package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.control.Direction;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.math.Mathf;
import com.flash3388.flashlib.robot.motion.Rotatable;
import com.flash3388.flashlib.scheduling.Subsystem;
import com.jmath.ExtendedMath;
import frc.team3388.robot.io.MagEncoder;

public class TurretSystem extends Subsystem implements Rotatable {

    private static final double MAX_SPEED = 0.4;
    private static final double MAX_ANGLE = 110;

    private final SpeedController controller;
    private final MagEncoder encoder;

    public TurretSystem(SpeedController controller, MagEncoder encoder) {
        this.controller = controller;
        this.encoder = encoder;
        encoder.resetDistance();
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

        controller.set(speed);
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
