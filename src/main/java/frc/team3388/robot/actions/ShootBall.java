package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.ShooterSystem;

public class ShootBall extends ActionBase {

    private final ShooterSystem shootSystem;
    private final XboxController shooterXboxController;


    public ShootBall(ShooterSystem shootSystem, XboxController shooterXboxController) {
        this.shootSystem = shootSystem;
        this.shooterXboxController = shooterXboxController;

        requires(shootSystem);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        boolean buttonShooter= shooterXboxController.getButton(XboxButton.RB).getAsBoolean();
        while(buttonShooter==true) {
            shootSystem.shoot(0.5);
        }
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
