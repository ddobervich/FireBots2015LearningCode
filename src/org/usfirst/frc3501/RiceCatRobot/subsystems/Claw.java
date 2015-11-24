package org.usfirst.frc3501.RiceCatRobot.subsystems;

import org.usfirst.frc3501.RiceCatRobot.OI;
import org.usfirst.frc3501.RiceCatRobot.Robot;
import org.usfirst.frc3501.RiceCatRobot.Constants;
import org.usfirst.frc3501.RiceCatRobot.commands.CloseClaw;
import org.usfirst.frc3501.RiceCatRobot.commands.OpenClaw;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem {
  private Compressor compressor;
  private DoubleSolenoid solenoid;

  public Claw() {
    solenoid = new DoubleSolenoid(Constants.Claw.MODULE_NUMBER,
        Constants.Claw.SOLENOID_FORWARD, Constants.Claw.SOLENOID_REVERSE);
    compressor = new Compressor(Constants.Claw.COMPRESSOR_PORT);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void closeClaw() {
    solenoid.set(Constants.Claw.close);
  }

  public void openClaw() {
    solenoid.set(Constants.Claw.open);
  }

  public boolean isOpen() {
    return solenoid.get() == Constants.Claw.open;
  }

  public void stopCompressor() {
    compressor.stop();
  }

  public void startCompressor() {
    compressor.start();
  }

  public boolean isCompressorOn() {
    return compressor.enabled();
  }
}
