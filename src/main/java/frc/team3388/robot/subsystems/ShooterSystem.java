package frc.team3388.robot.subsystems;


import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.math.Mathf;
import com.flash3388.flashlib.scheduling.Subsystem;
import frc.team3388.robot.io.MagEncoder;


public class ShooterSystem extends Subsystem {

    private final SpeedController motor;
    private final MagEncoder encoder;

    private static final double MINIMUM_SPEED = 0.2;
    private static final double NOT_MOVING = 0.0;

    public ShooterSystem(SpeedController motor, MagEncoder encoder) {
        this.motor = motor;
        this.encoder = encoder;
    }

    public double getSpeedRpm() {
        return encoder.getRate();
    }

    public void shoot(double speed) {
       double speedNow= Math.abs(speed);
       if(speedNow<MINIMUM_SPEED&&NOT_MOVING<speedNow){
           speedNow=MINIMUM_SPEED;
       }
        motor.set(speedNow);
    }

    public void stop() {
        motor.stop();
    }
}


