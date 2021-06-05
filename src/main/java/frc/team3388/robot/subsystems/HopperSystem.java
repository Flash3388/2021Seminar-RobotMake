package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;
import com.revrobotics.ColorSensorV3;

public class HopperSystem extends Subsystem {
    private final SpeedController motor;
    private final ColorSensorV3 proximitySensor;
    private final double SPEED = 0.95;

    public HopperSystem(SpeedController motor, ColorSensorV3 proximitySensor) {
        this.motor = motor;
        this.proximitySensor = proximitySensor;
    }

    public void move() {
        motor.set(SPEED);
    }

    public double getProximity() {
        return proximitySensor.getProximity();
    }

    public void stop() {
        motor.stop();
    }
}
