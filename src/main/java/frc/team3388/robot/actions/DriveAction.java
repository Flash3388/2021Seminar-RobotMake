package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.JoystickAxis;
import com.flash3388.flashlib.hid.XboxAxis;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.DriveSystem;

public class DriveAction extends ActionBase {

    private DriveSystem driveSystem;
    private XboxController xbox;

    public DriveAction(DriveSystem driveSystem, XboxController xbox) {
        this.driveSystem = driveSystem;
        this.xbox = xbox;

        requires(driveSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        double right = xbox.getAxis(XboxAxis.RightStickY).getAsDouble();
        double left = xbox.getAxis(XboxAxis.LeftStickY).getAsDouble();
        driveSystem.move(right, left);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        driveSystem.stop();
    }

}
