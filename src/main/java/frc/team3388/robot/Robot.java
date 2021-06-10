package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxAxis;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.actions.DriveAction;
import frc.team3388.robot.actions.MoveTurretToAngle;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.FeederSystem;
import frc.team3388.robot.subsystems.HopperSystem;
import frc.team3388.robot.subsystems.IntakeSystem;
import frc.team3388.robot.subsystems.ShooterSystem;
import frc.team3388.robot.subsystems.TurretSystem;

public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final IntakeSystem intakeSystem;
    private final HopperSystem hopperSystem;
    private final ShooterSystem shooterSystem;
    private final DriveSystem driveSystem;
    private final TurretSystem turretSystem;
    private final FeederSystem feederSystem;

    private final XboxController xbox;

    public Robot(FrcRobotControl robotControl) {
        super(robotControl);

        // CREATE SUBSYSTEMS
        SystemFactory systemFactory = new SystemFactory(robotControl);
        hopperSystem = systemFactory.createHopperSystem();
        shooterSystem = systemFactory.createShooterSystem();
        driveSystem = systemFactory.createDriveSystem();
        turretSystem = systemFactory.createTurretSystem();
        feederSystem = systemFactory.createfeedersystem();
        intakeSystem = systemFactory.createIntakeSystem();

        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);

        // DASHBOARD
        Dashboard.showDrive(driveSystem);
        Dashboard.showTurret(turretSystem);
        Dashboard.showShooter(shooterSystem);
        Dashboard.showHopper(hopperSystem);

        // CONFIGURE ACTIONS
        driveSystem.setDefaultAction(new DriveAction(driveSystem, xbox));
        xbox.getButton(XboxButton.A).whileActive(new MoveTurretToAngle(turretSystem, 90, 0.25));
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {

    }

    @Override
    public void autonomousInit() {

    }

    @Override
    public void autonomousPeriodic() {

    }

    @Override
    public void testInit() {

    }

    @Override
    public void testPeriodic() {

    }

    @Override
    public void robotPeriodic() {

    }

    @Override
    public void robotStop() {

    }
}
