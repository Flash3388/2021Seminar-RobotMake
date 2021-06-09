package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.ClimbSystem;

public class Climb extends ActionBase {

    private ClimbSystem climbsystem;
    private double speed;

    public Climb(ClimbSystem climbsystem, double speed){
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
        climbsystem.climb(0.7);
    }

    @Override
    public boolean isFinished() {
        return climbsystem.maxHeight();
    }

    @Override
    public void end(boolean wasInterrupted) {
        climbsystem.stop();
    }
}
