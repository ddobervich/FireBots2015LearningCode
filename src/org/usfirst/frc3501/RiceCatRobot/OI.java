package org.usfirst.frc3501.RiceCatRobot;

import org.usfirst.frc3501.RiceCatRobot.commands.ToggleClaw;
import org.usfirst.frc3501.RiceCatRobot.commands.ToggleCompressor;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
  public static Joystick leftJoystick;
  public static Joystick rightJoystick;
  public static JoystickButton triggerButton;
  public static JoystickButton toggleCompressorButton;
  public static JoystickButton toggleClawButton;

  public OI() {
    System.out.println("OI is open");
    leftJoystick = new Joystick(Constants.OI.LEFT_STICK_PORT);
    rightJoystick = new Joystick(Constants.OI.RIGHT_STICK_PORT);
    triggerButton = new JoystickButton(rightJoystick, Constants.OI.TRIGGER_PORT);
    toggleClawButton = new JoystickButton(rightJoystick,
        Constants.OI.TOGGLE_PORT);
    toggleCompressorButton = new JoystickButton(rightJoystick,
        Constants.OI.TOGGLE_COMPRESSOR_PORT);

    toggleClawButton.whenPressed(new ToggleClaw());
    toggleCompressorButton.whenPressed(new ToggleCompressor());

  }
}
