package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.actions.DriveAction;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.ExampleSystem;
import frc.team3388.robot.subsystems.HopperSystem;
import frc.team3388.robot.subsystems.IntakeSystem;
import com.flash3388.flashlib.scheduling.actions.Action;


public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final ExampleSystem exampleSystem;
    private final IntakeSystem intakeSystem;
    private final HopperSystem hopperSystem;
    private final DriveSystem driveSystem;

    private final XboxController xbox;

    public Robot(FrcRobotControl robotControl) {
        super(robotControl);

        // CREATE SUBSYSTEMS
        SystemFactory systemFactory = new SystemFactory(robotControl);
        exampleSystem = systemFactory.createExampleSystem();
        hopperSystem = systemFactory.createHopperSystem();
        driveSystem = systemFactory.createDriveSystem();

        intakeSystem = systemFactory.createIntakeSystem();
        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);

        // CONFIGURE ACTIONS
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void teleopInit() {
        Action drive = new DriveAction(driveSystem, xbox);
        drive.start();
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
