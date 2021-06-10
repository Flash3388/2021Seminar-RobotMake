package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.actions.MoveTurretLeft;
import frc.team3388.robot.actions.MoveTurretRight;
import frc.team3388.robot.subsystems.*;

public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final IntakeSystem intakeSystem;
    private final HopperSystem hopperSystem;
    private final ShooterSystem shooterSystem;
    private final DriveSystem driveSystem;
    private final TurretSystem turretSystem;

    private final XboxController xbox;

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
        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);

        // CONFIGURE ACTIONS

        feederSystem = systemFactory.createfeedersystem();
        xbox.getButton(XboxButton.RB).whileActive(new MoveTurretRight(turretSystem));
        xbox.getButton(XboxButton.LB).whileActive(new MoveTurretLeft(turretSystem));
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
