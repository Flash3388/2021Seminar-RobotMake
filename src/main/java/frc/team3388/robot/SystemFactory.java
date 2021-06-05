package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.SpeedController;
import frc.team3388.robot.subsystems.ExampleSystem;
import frc.team3388.robot.subsystems.ShooterSystem;

public class SystemFactory {

    private final FrcRobotControl robotControl;

    public SystemFactory(FrcRobotControl robotControl) {
        this.robotControl = robotControl;
    }

    public ExampleSystem createExampleSystem() {
        SpeedController motor = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.EXAMPLE_SYSTEM_MOTOR))
                .build();

        return new ExampleSystem(motor);
    }


    public ShooterSystem shooterS() {
        SpeedController controller = new SpeedControllers()
                .add(new WPI_TalonFX(RobotMap.SHOOTER_SYSTEM_MOTOR))
                .build();

        return new ShooterSystem(controller);
    }
}
