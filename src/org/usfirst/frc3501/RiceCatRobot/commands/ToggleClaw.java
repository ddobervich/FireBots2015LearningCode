package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command toggles the state of the claw. If it's open, the claw
 * will close. If it's closed, the claw will open.
 *
 * Note: This command should only be triggered from the joystick!
 * For autonomous code, use OpenClaw or CloseClaw instead
 */
public class ToggleClaw extends Command {

  public ToggleClaw() {
    requires(Robot.claw);
  }

  @Override
  protected void initialize() {
    if (Robot.claw.isOpen()) {
      Robot.claw.closeClaw();
    } else {
      Robot.claw.openClaw();
    }
  }

  @Override
  protected void execute() {

  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {
  }
}
