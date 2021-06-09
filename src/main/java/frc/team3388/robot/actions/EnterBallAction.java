package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.HopperSystem;

public class EnterBallAction extends ActionBase {

    private HopperSystem hopperSystem;

    public EnterBallAction(HopperSystem hopperSystem){
        this.hopperSystem = hopperSystem;

        requires(hopperSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        hopperSystem.move();
    }

    @Override
    public boolean isFinished() {
        return (hopperSystem.getProximity() > 160);
    }

    @Override
    public void end(boolean wasInterrupted) {
        hopperSystem.stop();
    }
}
