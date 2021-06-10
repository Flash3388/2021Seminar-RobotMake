package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import com.flash3388.flashlib.time.Clock;
import com.flash3388.flashlib.time.Time;
import com.jmath.ExtendedMath;
import frc.team3388.robot.subsystems.TurretSystem;

public class PidMoveTurretToAngle extends ActionBase {

    private final TurretSystem turretSystem;
    private final Clock clock;
    private final double targetAngle;
    private final double angleAccuracy;

    private Time reachedTargetStartTime;

    public PidMoveTurretToAngle(TurretSystem turretSystem, Clock clock, double targetAngle, double angleAccuracy) {
        this.turretSystem = turretSystem;
        this.clock = clock;
        this.targetAngle = targetAngle;
        this.angleAccuracy = angleAccuracy;

        requires(turretSystem);
    }

    @Override
    public void initialize() {
        reachedTargetStartTime = Time.INVALID;
    }

    @Override
    public void execute() {
        turretSystem.pidRotate(targetAngle);
    }

    @Override
    public boolean isFinished() {
        if(ExtendedMath.constrained(turretSystem.getAngleDegrees(),
                targetAngle - angleAccuracy,
                targetAngle + angleAccuracy)) {
            if (reachedTargetStartTime.isValid()) {
                Time passed = clock.currentTime().sub(reachedTargetStartTime);
                if (passed.after(Time.milliseconds(500))) {
                    return true;
                }
            } else {
                reachedTargetStartTime = clock.currentTime();
            }
        } else {
            reachedTargetStartTime = Time.INVALID;
        }

        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        turretSystem.stop();
    }
}
