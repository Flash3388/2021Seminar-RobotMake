package frc.team3388.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.io.devices.DoubleSolenoid;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;
import edu.wpi.first.wpilibj.Relay;

public class IntakeSystem extends Subsystem {

    private SpeedController motor;

    private DoubleSolenoid pistons;



    public IntakeSystem(SpeedController motor, DoubleSolenoid pistons) {
        this.motor = motor;
        this.pistons = pistons;
    }

    public void collect(double speed) {
        motor.set(speed);
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
