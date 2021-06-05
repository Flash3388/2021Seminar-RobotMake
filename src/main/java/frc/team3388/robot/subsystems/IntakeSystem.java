package frc.team3388.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.io.devices.DoubleSolenoid;
import com.flash3388.flashlib.scheduling.Subsystem;
import edu.wpi.first.wpilibj.Relay;

public class IntakeSystem extends Subsystem {

    private WPI_VictorSPX motor;

    private DoubleSolenoid pistons;

    private final double speed = 0.6;


    public IntakeSystem(WPI_VictorSPX motor, DoubleSolenoid pistons) {
        this.motor = motor;
        this.pistons = pistons;
    }

    public void collect() {
        motor.set(speed);
    }

    public void open() {
        pistons.set(DoubleSolenoid.Value.FORWARD);
    }

    public void close() {
        pistons.set(DoubleSolenoid.Value.REVERSE);
    }

    public void stop() {
        motor.stopMotor();
    }
}
