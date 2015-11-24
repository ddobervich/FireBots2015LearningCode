package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;
import org.usfirst.frc3501.RiceCatRobot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command takes a time in seconds which is how long it should run
 *
 */
public class DriveForTime extends Command {
  private double seconds;
  private double speed;

  public DriveForTime(double seconds, double speed) {
    requires(Robot.driveTrain);

    // Since negative values in setMotorSpeeds(...) are forwards, we reverse
    // speed here so positive input values will move the robot forwards.
    this.speed = -speed;
    this.seconds = seconds;
  }

  @Override
  protected void initialize() {
    this.setTimeout(seconds);
    Robot.driveTrain.setMotorSpeeds(speed, speed);
  }

  @Override
  protected void execute() {
    // nothing to do since motor speeds already set
  }

  @Override
  protected boolean isFinished() {
    return this.isTimedOut();
  }

  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}