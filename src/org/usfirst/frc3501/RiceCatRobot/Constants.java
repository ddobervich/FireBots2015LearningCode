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
    public final static int DRIVE_LEFT_A = 3;
    public final static int DRIVE_LEFT_B = 4;
    public final static int DRIVE_RIGHT_A = 2;
    public final static int DRIVE_RIGHT_B = 1;

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
  }

  public static class Arm {
    public final static int ARM_LEFT = 2;
    public final static int ARM_RIGHT = 7;
    public final static double ARM_HIGH_SPEED = 0.5;
    public final static double ARM_LOW_SPEED = 0.5;
    public final static int UPPER_LIMIT_SWITCH_PORT = 6;
    public final static int LOWER_LIMIT_SWITCH_PORT = 5;
    public static final double DEAD_ZONE = 0.05;
  }

  public static class Claw {
    public final static int SOLENOID_FORWARD = 0;
    public final static int SOLENOID_REVERSE = 1;
    public final static int MODULE_NUMBER = 0;

    public final static Value open = DoubleSolenoid.Value.kForward;
    public final static Value close = DoubleSolenoid.Value.kReverse;

    public static final int COMPRESSOR_PORT = 0;
  }

  public static enum Direction {
    LEFT, RIGHT, DOWN, UP, FORWARD, BACKWARD;
  }
}