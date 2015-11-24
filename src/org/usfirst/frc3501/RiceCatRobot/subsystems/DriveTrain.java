package org.usfirst.frc3501.RiceCatRobot.subsystems;

import org.usfirst.frc3501.RiceCatRobot.Constants;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
  // operational constants

  // inches/pulse
  private final static double WHEEL_DIAMETER = 6.0; // in inches
  private final static double PULSES_PER_ROTATION = 256;
  private final static double OUTPUT_SPROCKET_DIAMETER = 2.0;
  private final static double WHEEL_SPROCKET_DIAMETER = 3.5;

  public final static double INCHES_PER_PULSE = (((Math.PI)
      * OUTPUT_SPROCKET_DIAMETER / PULSES_PER_ROTATION) / WHEEL_SPROCKET_DIAMETER)
      * WHEEL_DIAMETER;

  public final static double DRIVE_DEAD_ZONE = 0.25;
  public final static double MAX_ACCELERATION = 0.3;
  public static final double MOTOR_MAX_VAL = 1;
  public static final double MOTOR_MIN_VAL = -1;

  private CANJaguar frontLeft, frontRight, rearLeft, rearRight;
  private Encoder leftEncoder, rightEncoder;

  public DriveTrain() {
    frontLeft = new CANJaguar(Constants.DriveTrain.DRIVE_FRONT_LEFT);
    frontRight = new CANJaguar(Constants.DriveTrain.DRIVE_FRONT_RIGHT);
    rearLeft = new CANJaguar(Constants.DriveTrain.DRIVE_REAR_LEFT);
    rearRight = new CANJaguar(Constants.DriveTrain.DRIVE_REAR_RIGHT);
    leftEncoder = new Encoder(Constants.DriveTrain.ENCODER_LEFT_A,
        Constants.DriveTrain.ENCODER_LEFT_B, false, EncodingType.k4X);
    rightEncoder = new Encoder(Constants.DriveTrain.ENCODER_RIGHT_A,
        Constants.DriveTrain.ENCODER_RIGHT_B, false, EncodingType.k4X);
    leftEncoder.setDistancePerPulse(INCHES_PER_PULSE);
    rightEncoder.setDistancePerPulse(INCHES_PER_PULSE);
  }

  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  // Returns inches per second
  public double getRightSpeed() {
    return rightEncoder.getRate();
  }

  public double getLeftSpeed() {
    return leftEncoder.getRate();
  }

  public double getSpeed() {
    return (getLeftSpeed() + getRightSpeed()) / 2.0;
  }

  // Returns distance in in
  public double getRightDistance() {
    return rightEncoder.getDistance();
  }

  // Returns distance in in
  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public double getDistance() {
    return (getRightDistance() + getLeftDistance()) / 2.0;
  }

  public void stop() {
    setMotorSpeeds(0, 0);
  }

  public double deadZoneFilter(double joystickValue) {
    if (Math.abs(joystickValue) < DRIVE_DEAD_ZONE)
      return 0;

    return joystickValue;
  }

  public void setMotorSpeeds(double leftSpeed, double rightSpeed) {
    this.frontLeft.set(leftSpeed);
    this.frontRight.set(-rightSpeed);
    this.rearLeft.set(leftSpeed);
    this.rearRight.set(-rightSpeed);
  }

  public void arcadeDrive(double yVal, double twist) {
    if (yVal < 0 && Math.abs(yVal) < 0.1125) {
      yVal = 0;
    } else if (yVal > 0 && Math.abs(yVal) < 0.25) {
      yVal = 0;
    } else if (yVal > 0) {
      yVal -= 0.25;
    } else if (yVal < 0) {
      yVal += 0.15;
    }
    if (Math.abs(twist) < DRIVE_DEAD_ZONE) {
      twist = 0;
    }

    double leftMotorSpeed;
    double rightMotorSpeed;
    // adjust the sensitivity (yVal+rootof (yval)) / 2
    yVal = (yVal + Math.signum(yVal) * Math.sqrt(Math.abs(yVal))) / 2.0;
    // adjust the sensitivity (twist+rootof (twist)) / 2
    twist = (twist + Math.signum(twist) * Math.sqrt(Math.abs(twist))) / 2.0;
    if (yVal > 0) {
      if (twist > 0) {
        leftMotorSpeed = yVal - twist;
        rightMotorSpeed = Math.max(yVal, twist);
      } else {
        leftMotorSpeed = Math.max(yVal, -twist);
        rightMotorSpeed = yVal + twist;
      }
    } else {
      if (twist > 0.0) {
        leftMotorSpeed = -Math.max(-yVal, twist);
        rightMotorSpeed = yVal + twist;
      } else {
        leftMotorSpeed = yVal - twist;
        rightMotorSpeed = -Math.max(-yVal, -twist);
      }
    }
    setMotorSpeeds(leftMotorSpeed, rightMotorSpeed);
  }

  @Override
  protected void initDefaultCommand() {
  }
}
