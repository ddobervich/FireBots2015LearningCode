package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCompressor extends Command {

  public ToggleCompressor() {
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    if (Robot.claw.isCompressorOn()) {
      Robot.claw.stopCompressor();
    } else {
      Robot.claw.startCompressor();
    }

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
