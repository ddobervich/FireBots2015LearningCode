package org.usfirst.frc3501.RiceCatRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3501.RiceCatRobot.Robot;

/**
 * Opens claw by reversing solenoids.
 *
 */
public class OpenClaw extends Command {

  /***
   * Constructor
   */
  public OpenClaw() {
    requires(Robot.claw);
  }

  @Override
  protected void initialize() {
    System.out.println("IN INIT OPENCLAW");
  }

  @Override
  protected void execute() {
    Robot.claw.openClaw();
    System.out.println("Opening Claw");
  }

  @Override
  protected boolean isFinished() {
    System.out.println("Claw Opened");
    return Robot.claw.isOpen();
  }

  @Override
  protected void end() {

  }

  @Override
  protected void interrupted() {
  }
}
