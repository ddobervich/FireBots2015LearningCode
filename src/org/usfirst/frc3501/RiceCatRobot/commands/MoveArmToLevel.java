package org.usfirst.frc3501.RiceCatRobot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.RobotMap;

/**
 * Move arm down to a certain level. Valid levels are [1, 7] with 1 being
 * the lowest height of the arm.
 *
 */
public class MoveArmToLevel extends Command {
  private double currentLidarValue;
  private double targetLidarValue;
  private double totalLidarDist;
  private double armSpeed;
  private int currentLevel;
  private int lvlRange;
  private boolean moveUp;
  private double[] lidarVals;

  /***
   * Constructor
   *
   * @param level
   *          level to move arm to, in range [1, 7] where 1 is lowest height
   */
  public MoveArmToLevel(int level) {
    requires(Robot.arm);
    lidarVals = RobotMap.armLevelLidarValues;
  }

  // Called just before this Command runs the first time
  protected void initialize() {
    RobotMap.debug(1, "IN INIT MOVE ARM TO LEVEL ");
    if (currentLidarValue < targetLidarValue) {
      moveUp = true;
    } else {
      moveUp = false;
    }

    // if arm is in lowest level range and wants to move down
    if (!moveUp && lvlRange == RobotMap.ARM_LOWEST_LEVEL) {
      targetLidarValue = lidarVals[RobotMap.ARM_LOWEST_LEVEL];

      // else if arm is in the highest level range and wants to move up
    } else if (moveUp && lvlRange == RobotMap.ARM_HIGHEST_LEVEL - 1) {
      targetLidarValue = lidarVals[RobotMap.ARM_LOWEST_LEVEL];

      // -1 indicates arm is inbetween levels
    } else if (currentLevel == -1) {
      if (moveUp) { // move to next lvl up
        targetLidarValue = lidarVals[lvlRange + 1];
      } else {
        // move to next lvl down
        targetLidarValue = lidarVals[lvlRange];
      }

      // else -> arm is at a level
    } else {
      if (moveUp) {
        targetLidarValue = currentLevel + 1;
      } else {
        targetLidarValue = currentLevel - 1;
      }
    }

    RobotMap.debug(1, "targetLidarValue: " + targetLidarValue);
    totalLidarDist = Math.abs(currentLidarValue - targetLidarValue);
  }

  // Called repeatedly when this Command is scheduled to run
  protected void execute() {
    armSpeed = RobotMap.speedAtDist(currentLidarValue, totalLidarDist);

    if (moveUp) {
      Robot.arm.setArmSpeeds(armSpeed);
    } else {
      Robot.arm.setArmSpeeds(-armSpeed);
    }
    RobotMap.debug(2, "Moving arm " + (moveUp ? "up" : "down"));
  }

  // Make this return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
  }
}
