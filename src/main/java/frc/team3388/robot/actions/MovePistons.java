package frc.team3388.robot.actions;


import com.flash3388.flashlib.scheduling.actions.ActionBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.team3388.robot.subsystems.IntakeSystem;

public class MovePistons extends ActionBase {

    private IntakeSystem intakeSystem;

    public MovePistons(IntakeSystem intakeSystem) {
        this.intakeSystem = intakeSystem;

        requires(intakeSystem);
    }

    @Override
    public void execute() {
        if (intakeSystem.pistonStatus() == DoubleSolenoid.Value.kForward) {
            intakeSystem.closePistons();
        } else {
            intakeSystem.openPistons();
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
