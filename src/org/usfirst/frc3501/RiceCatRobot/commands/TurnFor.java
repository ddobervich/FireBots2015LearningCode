package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/***
 * Turn (left side stationary, right side runs forward or reverse) at a
 * set speed for a set amount of time).
 *
 * @author David
 */
public class TurnFor extends Command {
  private double seconds;
  private double speed;
  private Direction direction;

  public TurnFor(double seconds, Direction direction, double speed) {
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
      Robot.driveTrain.arcadeDrive(0, -speed);
    } else if (direction == Direction.RIGHT) {
      Robot.driveTrain.arcadeDrive(0, speed);
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
