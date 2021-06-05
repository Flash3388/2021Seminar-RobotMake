# 2021 Seminar - 2020 Robot Attempt

## Conventions

### RobotMap

All constants related to connections of physical/electronic compoenents should be defined in `RobotMap` class:

```java
public class RobotMap {

    public static final int DRIVE_LEFT_MOTOR1 = 5;
    
    public static final I2C.Port SOME_SENSOR_CONNECTION = I2C.Port.kOnboard;

}
```

### Subsystem Creation

Creating subsystem instances should be done in methods in `SystemsFactory`. Each system should have a method (called `create${SYSTEM NAME}`) which creates an instance of that system, passing all dependencies to it.

```java
public class SystemsFactory {
    
    ..........
    
    
    public SomeSystem createSomeSystem() {
        SpeedController controller = new SpeedControllers()
                .add(new WPI_VictorSPX(RobotMap.MOTOR_CONNECTION))
                .build();
        return new SomeSystem(controller);
    }
}
```


## Robot Systems

### Drive System

- Tank Drive
- Right
  - 2x Talon SRX
- Left
  - 2x Talon SRX

#### Advanced

- Sensors
  - Drive distance measurement
    - 2x Encoder:
      - SRX Encoder
      - Right side = connected to right (1)
      - Left Side = connected to left (5)
      - Wheel diameter = 15.24 CM
  - Drive orientation measurement
    - Pigeon IMU gyro (`PigeonIMU`)
      - Connected to speed controller (1) 
      - Reset = `gyro.setFusedHeading(0);` `gyro.setYaw(0);`
      - Get angle = `gyro.getFusedHeading();`


### Feeder System

- 1x Victor SPX (`WPI_VictorSPX`) 
  - Constant Speed: 0.35

### Climb System

- 2x Victor SPX (`PWMVictorSPX`)
  - Constant Speed: 0.7
- Sensors
  - Robot Has Risen
    - Switch (`DigitalInput`)
    - `false` = robot is at top. `true` = robot not at top

### Intake System

- 1x Victor SPX (`WPI_VictorSPX`)
  - Constant Speed: 0.6
- 1x Piston (`DoubleSolenoid`)
  - open = unfolded, close = folded

### Turret System

- 1x Talon SRX
  - Speed limit = 0.4

#### Advanced

- Sensors
  - Turret orientation
    - SRX Encoder
    - Connected to speed controller (3)
    - To angle conversion = `little gear tooth count / large gear tooth count * 360`
    - little gear tooth count = 27
    - large gear tooth count =  110
- Max angle 110 degrees (either side)
- PID for angle motion precision
  - Kp = 0.08
  - Ki = 0
  - Kd = 0.19
  - Sensor = Turret orientation
  - Measurement units = angle

### Hopper System

- 1x Talon SRX
  - Constant Speed: 0.95
- Sensors:
  - Ball entered system
    - Color Sensor (`ColorSensorV3`)
      - Ball entered = `getProximity() >= 160` 

### Shooter System

- 1x Talon FX (`WPI_TalonFX`)
  - Minimum Speed: 0.2  
  - Speed must be positive

#### Advanced

- Sensors
  - Motor rotation speed
    - SRX Encoder
    - Connected to speed controller (10)
    - To RPM conversion = `getSelectedSensorVelocity() / 2048.0 * 600`
- PID for motor speed percision
  - Kp = 0.0007
  - Ki = 0
  - Kd = 0.00026   
  - Output limit = [0, 1]
  - Output Ramp Rate = 0.1
  - Sensor = Motor rotation speed
  - Measurement units = RPM
- Interpolation
  - Convert shooting distance -> rotation speed (RPM)
  - Apache commons `PolynomialFunctionLagrangeForm`
  - Data Points [here](https://github.com/Flash3388/Flash2020/blob/master/src/main/java/frc/team3388/subsystems/ShooterSystem.java)
