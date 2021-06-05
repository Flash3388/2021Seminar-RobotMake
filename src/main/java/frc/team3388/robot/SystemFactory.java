package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.SpeedController;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.ExampleSystem;

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

    public DriveSystem createDriveSystem() {
        SpeedController right = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.RIGHT1))
                .add(new WPI_TalonSRX(RobotMap.RIGHT2))
                .build();
        SpeedController left = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.LEFT1))
                .add(new WPI_TalonSRX(RobotMap.LEFT2))
                .build();

        return new DriveSystem(right, left);
    }
}
