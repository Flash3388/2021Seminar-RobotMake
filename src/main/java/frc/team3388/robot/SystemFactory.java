package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.SpeedController;
import frc.team3388.robot.subsystems.ExampleSystem;
import frc.team3388.robot.subsystems.FeederSystem;

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

    public FeederSystem createfeedersystem(){
        SpeedController motor = new SpeedControllers()
                .add(new WPI_VictorSPX(RobotMap.FEEDERSYSTEM))
                .build();

        return new FeederSystem(motor);
    }


}