package org.usfirst.frc3501.RiceCatRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class MoveThingToValue extends Command {
  private static final double THRESHOLD = 0.1;
  private double speed;
  private double targetPosition;
  private boolean isDecreasing = false;
  private double currentPosition;

  public MoveThingToValue(double speed, double value) {
    requires(Robot.SOMESUBSYTEM);

    this.speed = speed;
    this.targetPosition = value;
  }

  @Override
  public void initialize() {
    currentPosition = Robot.SOMESUBSYSTEM.getSensorValue();

    if (currentPosition > targetPosition) {
      Robot.SOMESUBSYSTEM.setMotorSpeed(-speed);
      isDecreasing = true;
    } else {
      Robot.SOMESUBSYSTEM.setMotorSpeed(speed);
      isDecreasing = false;
    }
  }

  @Override
  public void execute() {
    // do nothing because motors are already running
  }

  @Override
  public boolean isFinished() {
    if (isDecreasing == true) {
      return (currentPosition <= targetPosition + THRESHOLD);
    } else if (isDecreasing == false) {
      return (currentPosition >= targetPosition + THRESHOLD);
    }
  }

  @Override
  public void end() {
    Robot.SOMESUBSYSTEM.setMotorSpeed(0);
  }
}
