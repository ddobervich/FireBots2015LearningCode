package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.MathLib;
import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;
import org.usfirst.frc3501.RiceCatRobot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This command will drive the specified distance at specified speed.
 *
 */
public class SmoothAccelerateForDistance extends Command {
  private double distance; // in units of inches
  private double minSpeed, maxSpeed;

  public SmoothAccelerateForDistance(double distance, double minSpeed,
      double maxSpeed) {
    requires(Robot.driveTrain);

    // ensure distance is positive
    this.distance = Math.max(distance, -distance);
  }

  @Override
  protected void initialize() {
    Robot.driveTrain.resetEncoders();

  }

  @Override
  protected void execute() {
    double percentDone = Robot.driveTrain.getLeftDistance() / distance;
    double desiredSpeed = MathLib.getSpeedForConstantAccel(minSpeed, maxSpeed,
        percentDone);
    Robot.driveTrain.setMotorSpeeds(desiredSpeed, desiredSpeed);
  }

  @Override
  protected boolean isFinished() {
    return Math.abs(Robot.driveTrain.getLeftDistance()) >= distance
        && Math.abs(Robot.driveTrain.getRightDistance()) >= distance;
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