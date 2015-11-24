package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;
import org.usfirst.frc3501.RiceCatRobot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will drive the specified distance at specified speed.
 *
 */
public class DriveDistance extends Command {
  private double distance; // in units of cm
  private double speed;

  public DriveDistance(double distance, double speed) {
    requires(Robot.driveTrain);

    // Since negative values in setMotorSpeeds(...) are forwards, we reverse
    // speed here so positive input values will move the robot forwards.
    this.speed = -speed;

    // ensure distance is positive
    this.distance = Math.max(distance, -distance);

    this.setTimeout(2.5);
  }

  @Override
  protected void initialize() {
    Robot.driveTrain.resetEncoders();
    Robot.driveTrain.setMotorSpeeds(speed, speed);
  }

  @Override
  protected void execute() {
    // nothing to do since motor speeds already set
  }

  @Override
  protected boolean isFinished() {
    return (Math.abs(Robot.driveTrain.getLeftDistance()) >= distance && Math
        .abs(Robot.driveTrain.getRightDistance()) >= distance)
        || this.isTimedOut();
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