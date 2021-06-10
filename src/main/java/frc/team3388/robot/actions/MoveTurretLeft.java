package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.TurretSystem;

public class MoveTurretLeft extends ActionBase {
    private TurretSystem turretSystem;

    public MoveTurretLeft(TurretSystem turretSystem) {
        this.turretSystem = turretSystem;

        requires(turretSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        turretSystem.moveLeft();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        turretSystem.stopTurret();
    }
}
