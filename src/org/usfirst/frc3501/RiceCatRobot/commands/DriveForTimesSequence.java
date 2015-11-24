package org.usfirst.frc3501.RiceCatRobot.commands;

import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants.Direction;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Command to drive an arbitrary sequences of speeds and times. You can use this
 * to approximate acceleration by driving 0.5 sec at speed 0.1, 0.5 sec at speed
 * 0.2, and so on.
 */
public class DriveForTimesSequence extends CommandGroup {

  /***
   *
   * @param timings
   *          an array of speeds and times. Each row represents a time and speed
   *          to drive at. Column 0 represents the time in seconds to drive for
   *          and column 1 represents the speed to drive at. E.g. { {1, 0.5},
   *          {2, 0.75} } will drive at 0.5 for 1 second and 0.75 for 2 seconds
   */
  public DriveForTimesSequence(double[][] timings) {
    for (int i = 0; i < timings.length; i++) {
      double time = timings[i][0];
      double speed = timings[i][1];

      addSequential(new DriveForTime(time, speed));
    }
  }
}