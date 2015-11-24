package org.usfirst.frc3501.RiceCatRobot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The Constants stores constant values for all subsystems. This includes the
 * port values for motors and sensors, as well as important operational
 * constants for subsystems such as max and min values.
 */
public class Constants {

  public static class OI {
    public final static int LEFT_STICK_PORT = 0;
    public final static int RIGHT_STICK_PORT = 1;
    public final static int TRIGGER_BUTTON = 1;
    public final static int TOGGLE_BUTTON = 2;
    public final static int TOGGLE_COMPRESSOR_BUTTON = 11;
  }

  public static class DriveTrain {
    // ports
    public final static int DRIVE_FRONT_LEFT = 4;
    public final static int DRIVE_FRONT_RIGHT = 5;
    public final static int DRIVE_REAR_LEFT = 3;
    public final static int DRIVE_REAR_RIGHT = 6;
    public final static int ENCODER_LEFT_A = 3;
    public final static int ENCODER_LEFT_B = 4;
    public final static int ENCODER_RIGHT_A = 2;
    public final static int ENCODER_RIGHT_B = 1;
  }

  public static class Arm {
    public final static int ARM_LEFT = 2;
    public final static int ARM_RIGHT = 7;
    public final static int UPPER_LIMIT_SWITCH_PORT = 6;
    public final static int LOWER_LIMIT_SWITCH_PORT = 5;
  }

  public static class Claw {
    public final static int SOLENOID_FORWARD = 0;
    public final static int SOLENOID_REVERSE = 1;
    public final static int MODULE_NUMBER = 0;
    public static final int COMPRESSOR_PORT = 0;
  }

  public static enum Direction {
    LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD;
  }
}