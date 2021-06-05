package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.io.devices.FrcDoubleSolenoid;
import com.flash3388.flashlib.frc.robot.io.devices.FrcSpeedController;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.DoubleSolenoid;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import frc.team3388.robot.subsystems.ExampleSystem;
import frc.team3388.robot.subsystems.IntakeSystem;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.HopperSystem;

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

    public HopperSystem createHopperSystem() {
        SpeedController motor = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.HOPPER_MOTOR))
                .build();

        ColorSensorV3 proximitySensor = new ColorSensorV3(I2C.Port.kOnboard);

        return new HopperSystem(motor, proximitySensor);
    }

    public IntakeSystem createIntakeSystem() {
        FrcSpeedController motor = new FrcSpeedController(
                new WPI_VictorSPX(
                        RobotMap.INTAKE_SYSTEM_MOTOR));
        DoubleSolenoid pistons = new FrcDoubleSolenoid(
                new edu.wpi.first.wpilibj.DoubleSolenoid(
                        RobotMap.PISTON_FORWARD_CHANNEL, RobotMap.PISTON_REVERSE_CHANNEL
                ));

        return new IntakeSystem(motor, pistons);

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
