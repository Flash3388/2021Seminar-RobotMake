package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.io.devices.FrcDoubleSolenoid;
import com.flash3388.flashlib.frc.robot.io.devices.FrcSpeedController;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.DoubleSolenoid;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import frc.team3388.robot.io.MagEncoder;
import frc.team3388.robot.subsystems.ShooterSystem;
import frc.team3388.robot.subsystems.IntakeSystem;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.HopperSystem;
import frc.team3388.robot.subsystems.FeederSystem;
import frc.team3388.robot.subsystems.TurretSystem;


public class SystemFactory {

    private static final double SRX_MAG_PPR = 4096.0;
    private static final double FX_MAG_PPR = 2048.0;
    private static final double DRIVE_WHEEL_DIAMETER_M = 0.1524;


    private final FrcRobotControl robotControl;

    public SystemFactory(FrcRobotControl robotControl) {
        this.robotControl = robotControl;
    }

    public ShooterSystem createShooterSystem() {
        WPI_TalonFX talon = new WPI_TalonFX(RobotMap.SHOOTER_SYSTEM_MOTOR);
        SpeedController controller = new SpeedControllers()
                .add(talon)
                .build();

        return new ShooterSystem(controller,
                new MagEncoder(talon, FX_MAG_PPR, 0.0));
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
        WPI_TalonSRX rightFront = new WPI_TalonSRX(RobotMap.DRIVE_RIGHT1);
        WPI_TalonSRX leftFront = new WPI_TalonSRX(RobotMap.DRIVE_LEFT1);
        leftFront.setInverted(true);
        WPI_TalonSRX leftBack = new WPI_TalonSRX(RobotMap.DRIVE_LEFT2);
        leftBack.setInverted(true);

        SpeedController right = new SpeedControllers()
                .add(rightFront)
                .add(new WPI_TalonSRX(RobotMap.DRIVE_RIGHT2))
                .build();
        SpeedController left = new SpeedControllers()
                .add(leftFront)
                .add(leftBack)
                .build();

        return new DriveSystem(right, left,
                new MagEncoder(rightFront, SRX_MAG_PPR, DRIVE_WHEEL_DIAMETER_M),
                new MagEncoder(leftFront, SRX_MAG_PPR, DRIVE_WHEEL_DIAMETER_M),
                new PigeonIMU(leftBack));
    }

    public FeederSystem createfeedersystem(){
        SpeedController motor = new SpeedControllers()
                .add(new WPI_VictorSPX(RobotMap.FEEDERSYSTEM))
                .build();

        return new FeederSystem(motor);
    }

    public TurretSystem createTurretSystem() {
        final double LARGE_GEAR_TOOTH_COUNT = 110.0;
        final double SMALL_GEAR_TOOTH_COUNT = 27.0;

        WPI_TalonSRX talon = new WPI_TalonSRX(RobotMap.MOTOR_TURRET);
        talon.setInverted(true);

        SpeedController motor = new SpeedControllers()
                .add(talon)
                .build();

        return new TurretSystem(motor,
                new MagEncoder(talon, SRX_MAG_PPR,
                        SMALL_GEAR_TOOTH_COUNT / LARGE_GEAR_TOOTH_COUNT * 360.0));
    }
}