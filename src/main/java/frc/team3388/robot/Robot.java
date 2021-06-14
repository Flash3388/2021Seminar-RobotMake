package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.HidChannel;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.actions.*;
import frc.team3388.robot.subsystems.*;

public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final IntakeSystem intakeSystem;
    private final HopperSystem hopperSystem;
    private final ShooterSystem shooterSystem;
    private final DriveSystem driveSystem;
    private final TurretSystem turretSystem;
    private final XboxController xbox;
    private final VisionSystem visionSystem;

    private final FeederSystem feederSystem;

    public Robot(FrcRobotControl robotControl) {
        super(robotControl);

        // CREATE SUBSYSTEMS
        SystemFactory systemFactory = new SystemFactory(robotControl);
        hopperSystem = systemFactory.createHopperSystem();
        shooterSystem=systemFactory.createShooterSystem();
        driveSystem = systemFactory.createDriveSystem();
        turretSystem = systemFactory.createTurretSystem();
        intakeSystem = systemFactory.createIntakeSystem();
        feederSystem = systemFactory.createFeederSystem();
        visionSystem = systemFactory.createVisionSystem();
        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);
        // CONFIGURE ACTIONS
        driveSystem.setDefaultAction(new DriveAction(driveSystem, xbox));
        xbox.getDpad().down().whenActive(new MovePistons(intakeSystem));
        xbox.getButton(XboxButton.LB).whileActive(new CollectBalls(intakeSystem));
        xbox.getDpad().left().whileActive(new TurretToLeft(turretSystem));
        xbox.getDpad().right().whileActive(new TurretToRight(turretSystem));
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void teleopInit() {
        new MoveTurretAction(turretSystem, xbox).start();
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
