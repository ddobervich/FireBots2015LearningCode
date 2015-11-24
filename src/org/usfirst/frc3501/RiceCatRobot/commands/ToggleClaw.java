package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
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
