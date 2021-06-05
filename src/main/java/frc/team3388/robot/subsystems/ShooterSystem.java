package frc.team3388.robot.subsystems;


import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;


public class ShooterSystem extends Subsystem {

    private final SpeedController motor;
    private final double MINIMUM_SPEED=0.2;
    public ShooterSystem(SpeedController motor) {
        this.motor = motor;
    }

    public void shoot(double speed) {
       double speedNow= +Math.abs(speed);
       if(speedNow<MINIMUM_SPEED){
           speedNow=MINIMUM_SPEED;
       }
        motor.set(speedNow);
    }

    public void stop() {
        motor.stop();
    }
}


