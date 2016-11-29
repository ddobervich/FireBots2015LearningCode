package org.usfirst.frc3501.RiceCatRobot.commandGroups;

import org.usfirst.frc3501.RiceCatRobot.commands.CloseClaw;
import org.usfirst.frc3501.RiceCatRobot.commands.DriveDistance;
import org.usfirst.frc3501.RiceCatRobot.commands.MoveArmToLevel;
import org.usfirst.frc3501.RiceCatRobot.commands.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/***
 * CommandGroup to stack a game object at a particular height. Moves the arm to
 * input level, opens the claw, moves it back to level 1 height and closes it
 * (to prepare for next stacking)
 *
 * @author David
 *
 */
public class AutonOne extends CommandGroup {
  private static final double DIST_TO_BARRIER = 120; // in inches
  private static final double FAST_SPEED = 0.8;
  private static final double DIST_OVER_BARRIER = 48; // in inches
  private static final double SLOW_SPEED = 0.35;
  private static final double DIST_TO_MIDDLE = 36; // in inches

  /***
   * Constructor
   *
   * @param level
   *          the level to stack game piece. In the range [1, 7] with as the
   *          lowest level
   */
  public AutonOne(int level) {
    addSequential(new DriveDistance(DIST_TO_BARRIER, FAST_SPEED));
    addSequential(new DriveDistance(DIST_OVER_BARRIER, SLOW_SPEED));
    addSequential(new DriveDistance(DIST_TO_MIDDLE, FAST_SPEED));
  }

}
