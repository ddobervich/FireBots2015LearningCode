package org.usfirst.frc3501.RiceCatRobot.subsystems;

import org.usfirst.frc3501.RiceCatRobot.Constants;
import org.usfirst.frc3501.RiceCatRobot.MathLib;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
  public final static double ARM_HIGH_SPEED = 0.5;
  public final static double ARM_LOW_SPEED = 0.5;
  public static final double DEAD_ZONE = 0.05;

  private CANJaguar left, right;
  private DigitalInput lowerLimitSwitch, upperLimitSwitch;

  public Arm() {
    left = new CANJaguar(Constants.Arm.ARM_LEFT);
    right = new CANJaguar(Constants.Arm.ARM_RIGHT);
    lowerLimitSwitch = new DigitalInput(Constants.Arm.LOWER_LIMIT_SWITCH_PORT);
    upperLimitSwitch = new DigitalInput(Constants.Arm.UPPER_LIMIT_SWITCH_PORT);
  }

  public boolean getLowerLimitSwitchValue() {
    return lowerLimitSwitch.get();
  }

  public boolean getUpperLimitSwitchValue() {
    return upperLimitSwitch.get();
  }

  @Override
  public void initDefaultCommand() {
  }

  public double deadZoneFilter(double speed) {
    if (MathLib.inRange(speed, -DEAD_ZONE, DEAD_ZONE))
      return 0;
    return speed;
  }

  public double quadraticInputFilter(double speed) {
    if (speed > 0) {
      return speed * speed;
    } else {
      return (-speed) * speed;
    }
  }

  public void fineTuneControl(double speed) {
    speed = deadZoneFilter(speed);
    speed = quadraticInputFilter(speed);
    setArmSpeeds(speed);
  }

  public void setLeft(double speed) {
    left.set(-speed);
  }

  public void setRight(double speed) {
    right.set(-speed);
  }

  public void setArmSpeeds(double speed) {
    setLeft(speed);
    setRight(speed);
  }

  public void stop() {
    left.set(0);
    right.set(0);
  }
}
