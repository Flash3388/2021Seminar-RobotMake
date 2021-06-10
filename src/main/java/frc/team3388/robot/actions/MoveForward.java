package frc.team3388.robot.actions;

import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.DriveSystem;

public class MoveForward extends ActionBase {

    private DriveSystem driveSystem;
    private double distance;
    private static double SPEED = 0.2;

    public MoveForward(DriveSystem driveSystem, double distance) {
        this.driveSystem = driveSystem;
        this.distance = distance;

        requires(driveSystem);
    }

    @Override
    public void initialize() {
        driveSystem.resetEncoders();
    }

    @Override
    public void execute() {
        driveSystem.move(SPEED, SPEED);
    }

    @Override
    public boolean isFinished() {
        Debug.getLogger().debug("yay {}", driveSystem.getDistancePassedMeters());
        return driveSystem.getDistancePassedMeters() >= distance;
    }

    @Override
    public void end(boolean wasInterrupted) {
        driveSystem.stop();
    }
}
