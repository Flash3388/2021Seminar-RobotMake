package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import frc.team3388.robot.subsystems.ExampleSystem;
import frc.team3388.robot.subsystems.HopperSystem;

public class Robot extends DelegatingRobotControl implements IterativeFrcRobot {

    private final ExampleSystem exampleSystem;
    private final HopperSystem hopperSystem;

    private final XboxController xbox;

    public Robot(FrcRobotControl robotControl) {
        super(robotControl);

        // CREATE SUBSYSTEMS
        SystemFactory systemFactory = new SystemFactory(robotControl);
        exampleSystem = systemFactory.createExampleSystem();
        hopperSystem = systemFactory.createHopperSystem();

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
