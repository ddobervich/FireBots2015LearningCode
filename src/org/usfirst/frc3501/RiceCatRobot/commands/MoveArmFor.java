package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command takes a time in seconds which is how long it should run to move
 * arm up or down
 *
 */
public class MoveArmFor extends Command {
  private double seconds;
  private Direction direction;

  /*
   * @param Direction must be up or down
   */
  public MoveArmFor(double seconds, Direction direction) {
    requires(Robot.arm);
    this.seconds = seconds;
    this.direction = direction;
  }

  @Override
  protected void initialize() {
    this.setTimeout(seconds);
  }

  @Override
  protected void execute() {
    if (direction == Direction.UP) {
      Robot.arm.setArmSpeeds(-Robot.arm.ARM_LOW_SPEED);
    } else if (direction == Direction.DOWN) {
      Robot.arm.setArmSpeeds(Robot.arm.ARM_LOW_SPEED);
    }
  }

  @Override
  protected boolean isFinished() {
    return this.isTimedOut();
  }

  @Override
  protected void end() {
    Robot.arm.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
