package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/***
 * Rotates (runs left and right side of drive train in opposite directions)
 * at a set speed for a set amount of time.
 *
 * @author David
 */
public class RotateForTime extends Command {
  private double seconds;
  private double speed;
  private Direction direction;

  public RotateForTime(double seconds, Direction direction, double speed) {
    requires(Robot.driveTrain);
    this.seconds = seconds;
    this.direction = direction;
    this.speed = speed;
  }

  @Override
  protected void initialize() {
    this.setTimeout(seconds);
  }

  @Override
  protected void execute() {
    if (direction == Direction.LEFT) {
      Robot.driveTrain.arcadeDrive(speed, -speed);
    } else if (direction == Direction.RIGHT) {
      Robot.driveTrain.arcadeDrive(-speed, speed);
    } else {
      Robot.driveTrain.arcadeDrive(0, 0);
    }
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
