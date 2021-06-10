package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.dashboard.SendableActionWrapper;
import com.flash3388.flashlib.scheduling.actions.Action;
import com.flash3388.flashlib.scheduling.actions.Actions;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.HopperSystem;
import frc.team3388.robot.subsystems.ShooterSystem;
import frc.team3388.robot.subsystems.TurretSystem;

public class Dashboard {

    public static void showDrive(DriveSystem driveSystem) {
        // Place the drive sensors on the shuffleboard.
        Shuffleboard.getTab("Sensors")
                .addNumber("Drive Encoder Right", driveSystem::getDistancePassedRightMeters)
                .withWidget(BuiltInWidgets.kTextView);
        Shuffleboard.getTab("Sensors")
                .addNumber("Drive Encoder Left", driveSystem::getDistancePassedLeftMeters)
                .withWidget(BuiltInWidgets.kTextView);
        Shuffleboard.getTab("Sensors")
                .addNumber("Drive Angle", driveSystem::getAngleDegrees)
                .withWidget(BuiltInWidgets.kGyro);

        // An actions which resets the sensors.
        // configured to be able run when in disabled mode.
        // This action will be activated from the shuffleboard using a button.
        Action resetAction = Actions.instant(driveSystem::resetSensors)
                .requires(driveSystem)
                .configure()
                    .setName("Reset Drive Sensors")
                    .setRunWhenDisabled(true)
                .save();
        Shuffleboard.getTab("Sensors")
                .add("Reset Sensors", new SendableActionWrapper(resetAction))
                .withWidget(BuiltInWidgets.kCommand);
    }

    public static void showTurret(TurretSystem turretSystem) {
        Shuffleboard.getTab("Sensors")
                .addNumber("Turret Angle", turretSystem::getAngleDegrees)
                .withWidget(BuiltInWidgets.kDial);

        Action resetSensors = Actions.instant(turretSystem::resetAngle)
                .configure()
                    .setRunWhenDisabled(true)
                    .setName("Reset Gyro")
                .save();
        Shuffleboard.getTab("Sensors")
                .add("Reset Turret Gyro", new SendableActionWrapper(resetSensors))
                .withWidget(BuiltInWidgets.kCommand);
    }

    public static void showShooter(ShooterSystem shooterSystem) {
        Shuffleboard.getTab("Sensors")
                .addNumber("Shooter Speed", shooterSystem::getSpeedRpm)
                .withWidget(BuiltInWidgets.kTextView);
    }

    public static void showHopper(HopperSystem hopperSystem) {
        Shuffleboard.getTab("Sensors")
            .addBoolean("Hopper Detected Ball", hopperSystem::isBallDetected)
            .withWidget(BuiltInWidgets.kBooleanBox);
    }
}
