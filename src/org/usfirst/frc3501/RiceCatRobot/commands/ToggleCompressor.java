package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This command toggles the state of the compressor. If it's off, it this
 * will turn it on. If it's on, it will turn it off.
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
