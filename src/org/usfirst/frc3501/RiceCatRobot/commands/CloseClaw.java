package org.usfirst.frc3501.RiceCatRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3501.RiceCatRobot.Robot;

/**
 * Closes the claw
 */
public class CloseClaw extends Command {

  /**
   * Constructor
   */
  public CloseClaw() {
    requires(Robot.claw);
  }

  protected void initialize() {
    System.out.println("IN INIT CLOSECLAW");
  }

  protected void execute() {
    Robot.claw.closeClaw();
    System.out.println("Closing claw");
  }

  protected boolean isFinished() {
    System.out.println("Claw Closed");
    return !Robot.claw.isOpen();
  }

  protected void end() {

  }

  protected void interrupted() {
  }
}
