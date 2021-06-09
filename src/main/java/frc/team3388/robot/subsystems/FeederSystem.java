package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.scheduling.Subsystem;
import com.flash3388.flashlib.io.devices.SpeedController;

public class FeederSystem extends Subsystem{

    private static final  double SPEED = 0.35;

    private final SpeedController motor;

    public FeederSystem(SpeedController motor) {
        this.motor = motor;
    }

    public void feed(){
        motor.set(SPEED);
    }

    public void stop(){
        motor.set(0);
    }


}
