package frc.team3388.robot.actions;

import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.IntakeSystem;

public class UnfoldIntake extends ActionBase {

    private final IntakeSystem intakeSystem;

    public UnfoldIntake(IntakeSystem intakeSystem) {
        this.intakeSystem = intakeSystem;

        requires(intakeSystem);
    }

    @Override
    public void execute() {
        Debug.getLogger().debug("unfold = open");
        intakeSystem.openPistons();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
