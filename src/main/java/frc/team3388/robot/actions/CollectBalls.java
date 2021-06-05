package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.IntakeSystem;

public class CollectBalls extends ActionBase {

    private final IntakeSystem intakeSystem;

    public CollectBalls(IntakeSystem intakeSystem) {
        this.intakeSystem = intakeSystem;

        requires(intakeSystem);
    }

    @Override
    public void execute() {
        intakeSystem.collect();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        intakeSystem.stop();
    }
}
