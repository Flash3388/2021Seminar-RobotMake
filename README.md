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

- Actions to write:
  - operate the drive system using an XBOX controller

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

This system is responsible for feeding the shooter with balls from the Hopper system.

- 1x Victor SPX (`WPI_VictorSPX`) 
  - Constant Speed: 0.35

- Actions to write
  - rotate the motor (feeds the shooter)

### Climb System

- 2x Victor SPX (`PWMVictorSPX`)
  - Constant Speed: 0.7
- Sensors
  - Robot Has Risen
    - Switch (`DigitalInput`)
    - `false` = robot is at top. `true` = robot not at top

- Actions to write
  - rotate the motor until the robot has risen (indicated by the switch)

### Intake System

Responsible for collecting balls from the field into the hopper for storage.

- 1x Victor SPX (`WPI_VictorSPX`)
  - Constant Speed: 0.6
- 1x Piston (`DoubleSolenoid`)
  - open = unfolded, close = folded

- Actions to write
  - rotate the motor (to collect balls)
  - unfold system
  - fold system

### Turret System

Responsible for rotating the shooter, so it can shoot towards different directions.

- 1x Talon SRX
  - Speed limit = 0.4

- Actions to write
  - rotate the motor (to direct the shooter)

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

Responsible for storing balls. 
The motor transfers balls from the intake to the storage.
The sensor detects when a ball entered from the intake.

- 1x Talon SRX
  - Constant Speed: 0.95
- Sensors:
  - Ball entered system
    - Color Sensor (`ColorSensorV3`)
      - Ball entered = `getProximity() >= 160` 

- Actions to write
  - rotate the motor
    - when the sensor indicates that a ball has entered stop the action 

### Shooter System

Responsible for shooting balls.

- 1x Talon FX (`WPI_TalonFX`)
  - Minimum Speed: 0.2  
  - Speed must be positive

- Actions to write
  - rotate the motor (shoot) at a specific speed.

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

## Using Components

### SRX/FX Encoder

The Talon SRX (and Talon FX) has a special connection for sensors and can be queried for information about it. One such device is a specialized encoder made specifically for the Talon SRX.

There are two uses for those encoder in this robot, all of which are normal encoder usages:
- to measure velocity of motor rotation
- to measure distance traveled by the robot

There are a couple of interesting constant needed:
- PPR (Pulses Per Revolution) - indicates the precision of the sensor.
  - For Talon SRX -> PPR = 4096.0
  - For Talon FX -> PPR = 2048.0

#### For Measuring Velocity

```java
WPI_TalonSRX talon = ...

// * 600 -> to per minute
double velocityRpm = talon.getSelectedSensorVelocity() * 600.0 / PPR;
```

#### For Measuring Distance Passed

```java

WPI_TalonSRX talon = ...

// get distance
double distanceMeters = talon.getSelectedSensorPosition() / PPR * WHEEL_DIAMETER_METERS * Math.PI;

// the position is accumulative. so we can reset it
talon.setSelectedSensorPosition(0);
```

### Pigeon IMU

A sensor board integrating multiple devices. It has a class for usage, so it's quite simple. In this robot there is a usage of a single axis of gyroscope to track the robot orientation.

The device is connected via a Talon SRX device.

```java
WPI_TalonSRX talon = ...;
PigeonIMU pigeon = new PigeonIMU(talon);

double angle = pigeon.getFusedHeading();

// angle is accumulative, so we can reset it
pigeon.setFusedHeading(0);
```

### Color Sensor

The color sensor is a simple device capable of detecting colors. However, it is also capable of detecting distance to objects. Which is what the robot needs it for.

It is connected via a special connection on the RoboRIO called I2C.

```java
ColorSensorV3 sensor = new ColorSensorV3(I2C.Port.kOnboard);

// higher value = closer
double proximity = sensor.getProximity();
```

