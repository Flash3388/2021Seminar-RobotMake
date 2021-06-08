package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.Subsystem;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.FeederSystem;

public class FeederAction extends ActionBase {

    private FeederSystem feederSystem;

    public FeederAction (FeederSystem feederSystem) {
        this.feederSystem = feederSystem;
        requires(feederSystem);
    }

    @Override
    public void execute() {
      feederSystem.feed();
    }

    @Override
    public void end(boolean wasInterrupted) {
       feederSystem.stop();
    }

}


