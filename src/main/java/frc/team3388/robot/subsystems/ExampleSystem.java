package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;

public class ExampleSystem extends Subsystem {

    private final SpeedController motor;

    public ExampleSystem(SpeedController motor) {
        this.motor = motor;
    }

    public void move(double speed) {
        motor.set(speed);
    }

    public void stop() {
        motor.stop();
    }
}
