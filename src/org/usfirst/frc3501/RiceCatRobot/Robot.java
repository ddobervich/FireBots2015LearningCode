package org.usfirst.frc3501.RiceCatRobot;

import org.usfirst.frc3501.RiceCatRobot.commands.DriveDistance;
import org.usfirst.frc3501.RiceCatRobot.commands.DriveForTime;
import org.usfirst.frc3501.RiceCatRobot.commands.SmoothAccelerateForDistance;
import org.usfirst.frc3501.RiceCatRobot.subsystems.Arm;
import org.usfirst.frc3501.RiceCatRobot.subsystems.Claw;
import org.usfirst.frc3501.RiceCatRobot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {
  public static OI oi;
  public static DriveTrain driveTrain;
  public static Arm arm;
  public static Claw claw;

  private Command autonCommand;

  @Override
  public void robotInit() {
    driveTrain = new DriveTrain();
    arm = new Arm();
    claw = new Claw();
    oi = new OI();

    autonCommand = new DriveDistance(36, 0.2);
  }

  @Override
  public void autonomousInit() {
    autonCommand.start();
  }

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }
}
