package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class IntakeSystem extends Subsystem {

    private SpeedController motor;

    private DoubleSolenoid pistons;

    private static final double SPEED = -0.6;

    public IntakeSystem(SpeedController motor, DoubleSolenoid pistons) {
        this.motor = motor;
        this.pistons = pistons;
    }

    public void collect() {
        motor.set(SPEED);
    }

    public void openPistons() {
        pistons.set(DoubleSolenoid.Value.kForward);
    }

    public void closePistons() {
        pistons.set(DoubleSolenoid.Value.kReverse);
    }

    public DoubleSolenoid.Value pistonStatus() {
        return pistons.get();
    }

    public void stop() {
        motor.stop();
    }
}
