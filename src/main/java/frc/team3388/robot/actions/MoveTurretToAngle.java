package frc.team3388.robot.actions;

import com.flash3388.flashlib.control.Direction;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.TurretSystem;

public class MoveTurretToAngle extends ActionBase {

    private TurretSystem turretSystem;
    private double angle;
    private Direction direction = Direction.FORWARD;
    private double speed;

    public MoveTurretToAngle(TurretSystem turretSystem, double angle, double speed) {
        this.turretSystem = turretSystem;
        this.angle = angle;
        this.speed = speed;

        requires(turretSystem);
    }


    @Override
    public void initialize() {
        if(angle > turretSystem.getAngleDegrees()) {
            direction = Direction.FORWARD;
        }
        else if(angle < turretSystem.getAngleDegrees()) {
            direction = Direction.BACKWARD;
        }
    }

    @Override
    public void execute() {
        turretSystem.rotate(speed, direction);
    }

    @Override
    public boolean isFinished() {
        if(direction == Direction.FORWARD)
        {
            return turretSystem.getAngleDegrees() <= angle;
        }
        else if(direction == Direction.BACKWARD)
        {
            return turretSystem.getAngleDegrees() >= angle;
        }
        return true;
    }

    @Override
    public void end(boolean wasInterrupted) {
        turretSystem.stop();
    }
}
