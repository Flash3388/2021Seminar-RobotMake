package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.XboxAxis;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.TurretSystem;

public class TurretAction extends ActionBase {

    private XboxController xboxController;
    private TurretSystem turretSystem;

    public TurretAction(XboxController xboxController, TurretSystem turretSystem) {
        this.xboxController = xboxController;
        this.turretSystem = turretSystem;

        requires(turretSystem);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(xboxController.getButton(XboxButton.LB).getAsBoolean())
        {
            turretSystem.moveLeft();
        }
        else if(xboxController.getButton(XboxButton.RB).getAsBoolean())
        {
            turretSystem.moveRight();
        }
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
