package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;
import edu.wpi.first.wpilibj.DigitalInput;

public class ClimbSystem extends Subsystem {
    private SpeedController up;
    private SpeedController down;
    private DigitalInput sensor;

    public ClimbSystem(SpeedController up, SpeedController down, DigitalInput sensor){
        this.up = up;
        this.down = down;
        this.sensor = sensor;
    }

    public boolean maxHeight(){
        return sensor.get();
    }

    public void climbdown(double speed){
        up.set(speed);
        down.set(speed);
    }

    public void climbup(double speed){
        up.set(-speed);
        down.set(-speed);
    }

    public void stop(){
        up.stop();
        down.stop();

    }
}
