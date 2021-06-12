package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.ClimbSystem;

public class ClimbDown extends ActionBase {

    private ClimbSystem climbsystem;
    private double speed;

    public ClimbDown(ClimbSystem climbsystem, double speed){
        this.climbsystem = climbsystem;
        this.speed = speed;

        requires(climbsystem);
    }

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        climbsystem.climbdown(speed);

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        climbsystem.stop();
    }
}
