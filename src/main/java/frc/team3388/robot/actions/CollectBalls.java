package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.IntakeSystem;

public class CollectBalls extends ActionBase {

    private final IntakeSystem intakeSystem;

    private final int speed;

    public CollectBalls(IntakeSystem intakeSystem, int speed) {
        this.intakeSystem = intakeSystem;
        this.speed = speed;

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
