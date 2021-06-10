package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.actions.CollectBalls;
import frc.team3388.robot.actions.FoldIntake;
import frc.team3388.robot.actions.MovePistons;
import frc.team3388.robot.actions.UnfoldIntake;
import frc.team3388.robot.subsystems.*;

public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final IntakeSystem intakeSystem;
    private final HopperSystem hopperSystem;
    private final ShooterSystem shooterSystem;
    private final DriveSystem driveSystem;

    private final XboxController xbox;

    private final FeederSystem feederSystem;

    public Robot(FrcRobotControl robotControl) {
        super(robotControl);

        // CREATE SUBSYSTEMS
        SystemFactory systemFactory = new SystemFactory(robotControl);
        intakeSystem = systemFactory.createIntakeSystem();
        hopperSystem = systemFactory.createHopperSystem();
        shooterSystem=systemFactory.createShooterSystem();
        driveSystem = systemFactory.createDriveSystem();
        feederSystem = systemFactory.createfeedersystem();
        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);

        // CONFIGURE ACTIONS
        xbox.getDpad().down().whenActive(new MovePistons(intakeSystem));
        xbox.getButton(XboxButton.LB).whileActive(new CollectBalls(intakeSystem));
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
