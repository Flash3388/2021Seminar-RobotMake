package frc.team3388.robot.actions;

import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import frc.team3388.robot.subsystems.ShooterSystem;

public class ShootBall extends ActionBase {

    private final ShooterSystem shootSystem;
    private final XboxController shooterXboxController;
    private final double speed;


    public ShootBall(ShooterSystem shootSystem, XboxController shooterXboxController, double speed) {
        this.shootSystem = shootSystem;
        this.shooterXboxController = shooterXboxController;
        this.speed = speed;

        requires(shootSystem);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
       // double absSpeed=Math.abs(speed);
        if(speed>0&&speed<0.2){
            shootSystem.stop();
        }
        shootSystem.shoot(speed);

        /*  boolean buttonShooter= shooterXboxController.getButton(XboxButton.RB).getAsBoolean();
        if(buttonShooter==true) {
            shootSystem.shoot(0.5);
        }
        else{
        shootSystem.stop();
        }*/
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
