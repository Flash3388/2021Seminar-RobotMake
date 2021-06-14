package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.TurretSystem;

public class MoveTurretAction extends ActionBase {

    private TurretSystem turretSystem;
    private XboxController xbox;

    public MoveTurretAction(TurretSystem turretSystem, XboxController xbox) {
        this.turretSystem = turretSystem;
        this.xbox = xbox;

        requires(turretSystem);
    }

    @Override
    public void execute() {
        if (xbox.getDpad().left().getAsBoolean())
            turretSystem.rotateLeft();
        else if(xbox.getDpad().right().getAsBoolean())
            turretSystem.rotateRight();
    }

    @Override
    public void end(boolean wasInterrupted) {
        turretSystem.stopFood();
    }
}
