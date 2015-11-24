package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TurnFor extends Command {
  private double seconds;
  private Timer timer;
  private Direction direction;

  public TurnFor(double seconds, Direction direction) {
    requires(Robot.driveTrain);
    this.seconds = seconds;
    this.direction = direction;
  }

  @Override
  protected void initialize() {
    timer = new Timer();
    timer.start();
  }

  @Override
  protected void execute() {
    if (direction == Direction.LEFT) {
      Robot.driveTrain.arcadeDrive(0, -0.5);
    } else if (direction == Direction.RIGHT) {
      Robot.driveTrain.arcadeDrive(0, 0.5);
    } else {
      Robot.driveTrain.arcadeDrive(0, 0);
    }
  }

  @Override
  protected boolean isFinished() {
    System.out.println(timer.get());
    System.out.println(seconds);
    if (timer.get() > seconds) {
      Robot.driveTrain.arcadeDrive(0, 0);
    }
    return timer.get() > seconds;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
    end();
  }
}
