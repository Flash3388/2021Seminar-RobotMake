package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.TurretSystem;

public class MoveTurretAction extends ActionBase {

    private TurretSystem turret;
    private XboxController controller;

    public MoveTurretAction (TurretSystem turret,XboxController controller){
        this.turret=turret;
        this.controller=controller;

    }

    @Override
    public void execute() {
        if(controller.getDpad().right().getAsBoolean())
           turret.rotateRight();

        else if(controller.getDpad().left().getAsBoolean())
            turret.rotateLeft();

        else
            turret.stopFood();

    }


    @Override
    public void end(boolean wasInterrupted) {
        turret.stopFood();
    }
}
