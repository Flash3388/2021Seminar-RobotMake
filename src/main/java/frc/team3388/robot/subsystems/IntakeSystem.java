package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.DoubleSolenoid;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;

public class IntakeSystem extends Subsystem {

    private SpeedController motor;

    private DoubleSolenoid pistons;

    private static final double SPEED = 0.6;

    public IntakeSystem(SpeedController motor, DoubleSolenoid pistons) {
        this.motor = motor;
        this.pistons = pistons;
    }

    public void collect() {
        motor.set(SPEED);
    }

    public void openPistons() {
        pistons.set(DoubleSolenoid.Value.FORWARD);
    }

    public void closePistons() {
        pistons.set(DoubleSolenoid.Value.REVERSE);
    }

    public void stop() {
        motor.stop();
    }
}
