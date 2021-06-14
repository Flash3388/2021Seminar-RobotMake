package frc.team3388.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import com.flash3388.flashlib.frc.robot.io.devices.FrcSpeedController;
import com.flash3388.flashlib.frc.robot.io.devices.SpeedControllers;
import com.flash3388.flashlib.io.devices.SpeedController;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import frc.team3388.robot.objects.NetworkDoubleProperty;
import frc.team3388.robot.objects.NetworkDoubleSupplier;
import frc.team3388.robot.subsystems.*;


public class SystemFactory {

    private final FrcRobotControl robotControl;

    public SystemFactory(FrcRobotControl robotControl) {
        this.robotControl = robotControl;
    }

    public ShooterSystem createShooterSystem() {
        SpeedController controller = new SpeedControllers()
                .add(new WPI_TalonFX(RobotMap.SHOOTER_SYSTEM_MOTOR))
                .build();

        return new ShooterSystem(controller);
    }

    public TurretSystem createTurretSystem(){
        SpeedController controller = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.TURRET_MOTOR))
                .build();

        return new TurretSystem(controller);

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
        DoubleSolenoid pistons = new DoubleSolenoid(RobotMap.PISTON_FORWARD_CHANNEL, RobotMap.PISTON_REVERSE_CHANNEL);

        return new IntakeSystem(motor, pistons);

    }

    public DriveSystem createDriveSystem() {
        SpeedController right = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.DRIVE_RIGHT1))
                .add(new WPI_TalonSRX(RobotMap.DRIVE_RIGHT2))
                .build();
        SpeedController left = new SpeedControllers()
                .add(new WPI_TalonSRX(RobotMap.DRIVE_LEFT1))
                .add(new WPI_TalonSRX(RobotMap.DRIVE_LEFT2))
                .build();
        left.inverted(true);

        return new DriveSystem(right, left);
    }

    public FeederSystem createFeederSystem(){
        SpeedController motor = new SpeedControllers()
                .add(new WPI_VictorSPX(RobotMap.FEEDER_SYSTEM))
                .build();

        return new FeederSystem(motor);
    }

    public VisionSystem createVisionSystem() {
        NetworkTableEntry exposureEntry = NetworkTableInstance.getDefault().getTable(RobotMap.CAMERA_CONTROL_TABLE_NAME).getEntry(RobotMap.EXPOSURE_ENTRY_NAME);
        NetworkDoubleSupplier alignmentErrorSupplier = new NetworkDoubleSupplier(RobotMap.VISION_TABLE_NAME, RobotMap.ALIGNMENT_ERROR_ENTRY_NAME, 0);
        NetworkDoubleSupplier distanceSupplier = new NetworkDoubleSupplier(RobotMap.VISION_TABLE_NAME, RobotMap.DISTANCE_ENTRY_NAME, -1);
        NetworkDoubleProperty cameraIndexSupplier = new NetworkDoubleProperty(RobotMap.CAMERA_CONTROL_TABLE_NAME, RobotMap.CAMERA_INDEX_ENTRY_NAME, 0);

        return new VisionSystem(exposureEntry, alignmentErrorSupplier, distanceSupplier, cameraIndexSupplier);
    }


}