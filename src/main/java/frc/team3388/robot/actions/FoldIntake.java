package frc.team3388.robot.actions;

import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.IntakeSystem;

public class FoldIntake extends ActionBase {

    private final IntakeSystem intakeSystem;

    public FoldIntake(IntakeSystem intakeSystem) {
        this.intakeSystem = intakeSystem;

        requires(intakeSystem);
    }

    @Override
    public void execute() {
        Debug.getLogger().debug("fold = close");
        intakeSystem.closePistons();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
