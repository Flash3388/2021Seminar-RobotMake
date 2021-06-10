package frc.team3388.robot.io;

import com.ctre.phoenix.motorcontrol.can.BaseTalon;

public class MagEncoder {

    private final BaseTalon mTalon;
    private final double mPulsesPerRevolution;
    private final double mWheelDiameter;

    public MagEncoder(BaseTalon talon, double pulsesPerRevolution, double wheelDiameter) {
        mTalon = talon;
        mPulsesPerRevolution = pulsesPerRevolution;
        mWheelDiameter = wheelDiameter;
    }

    public double getRate() {
        return mTalon.getSelectedSensorVelocity() * 10 / mPulsesPerRevolution;
    }

    public double getDistance() {
        return mTalon.getSelectedSensorPosition() / mPulsesPerRevolution * mWheelDiameter * Math.PI;
    }

    public void resetDistance() {
        mTalon.setSelectedSensorPosition(0);
    }
}
