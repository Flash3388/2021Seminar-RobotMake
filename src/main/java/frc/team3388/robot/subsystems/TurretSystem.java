package frc.team3388.robot.subsystems;

import com.flash3388.flashlib.io.devices.SpeedController;
import com.flash3388.flashlib.scheduling.Subsystem;

public class TurretSystem extends Subsystem {
    private SpeedController food;

    private static double MAX_SPEED = 0.4;

    public TurretSystem(SpeedController food) {
        this.food = food;
    }

    public void setFood(double speed) {
       if (MAX_SPEED > speed)
        food.set(speed);

    }
    public void rotateRight (){
        food.set(-0.4);

    }
    public void rotateLeft () {
        food.set(0.4);

    }
    public void stopFood() {
        food.stop();
    }



}
