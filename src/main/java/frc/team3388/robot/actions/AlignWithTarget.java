package frc.team3388.robot.actions;

import com.flash3388.flashlib.Debug;
import com.flash3388.flashlib.scheduling.actions.ActionBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.team3388.robot.subsystems.TurretSystem;

public class AlignWithTarget extends ActionBase {

    private TurretSystem turretSystem;
    private NetworkTableEntry distance;

    public AlignWithTarget(TurretSystem turretSystem){
        NetworkTable table = NetworkTableInstance.getDefault().getTable("vision-color");
        this.distance = table.getEntry("distance");
        this.turretSystem = turretSystem;
        requires(turretSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        if(distance.getDouble(0.0) > 0) {
            turretSystem.rotate(0.23);
        }
        else {
            turretSystem.rotate(-0.23);
        }
    }

    @Override
    public boolean isFinished() {
        if(distance.getDouble(0.0) == 0.0){
            return true;
        }
        return false;
    }

    @Override
    public void end(boolean wasInterrupted) {
        turretSystem.stop();
    }
}
