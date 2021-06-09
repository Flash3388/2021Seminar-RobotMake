package frc.team3388.robot.actions;

import com.flash3388.flashlib.scheduling.Requirement;
import com.flash3388.flashlib.scheduling.actions.Action;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import com.flash3388.flashlib.scheduling.actions.ActionGroup;
import com.flash3388.flashlib.time.Time;
import frc.team3388.robot.subsystems.ShooterSystem;

public class ShootBall extends ActionBase {

    private final ShooterSystem shootSystem;
    private final double speed;

    public ShootBall(ShooterSystem shootSystem, double speed) {
        this.shootSystem = shootSystem;
        this.speed = speed;

        requires(shootSystem);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        shootSystem.shoot(speed);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        shootSystem.stop();
    }


}
