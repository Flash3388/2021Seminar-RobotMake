package frc.team3388.robot;

import com.flash3388.flashlib.frc.robot.FrcRobotControl;
import com.flash3388.flashlib.frc.robot.base.iterative.IterativeFrcRobot;
import com.flash3388.flashlib.hid.XboxButton;
import com.flash3388.flashlib.hid.XboxController;
import com.flash3388.flashlib.robot.base.DelegatingRobotControl;
import edu.wpi.first.wpilibj.Compressor;
import frc.team3388.robot.actions.ShootBall;
import frc.team3388.robot.subsystems.DriveSystem;
import frc.team3388.robot.subsystems.HopperSystem;
import frc.team3388.robot.subsystems.IntakeSystem;
import frc.team3388.robot.subsystems.ShooterSystem;
import frc.team3388.robot.subsystems.FeederSystem;

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
        hopperSystem = systemFactory.createHopperSystem();
        shooterSystem=systemFactory.createShooterSystem();
        driveSystem = systemFactory.createDriveSystem();

        intakeSystem = systemFactory.createIntakeSystem();
        // CREATE CONTROLLERS
        xbox = getHidInterface().newXboxController(RobotMap.XBOX);

        // CONFIGURE ACTIONS


        feederSystem = systemFactory.createfeedersystem();

        xbox.getButton(XboxButton.RB).whileActive(new ShootBall(shooterSystem,xbox, 0.5));

        Compressor compressor = new Compressor();
        compressor.stop();
    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {

    }

    @Override
    public void teleopInit() {
       // new ShootBall(shooterSystem, xbox).start();
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
