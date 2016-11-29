package org.usfirst.frc3501.RiceCatRobot.commandGroups;

import org.usfirst.frc3501.RiceCatRobot.commands.CloseClaw;
import org.usfirst.frc3501.RiceCatRobot.commands.MoveArmToLevel;
import org.usfirst.frc3501.RiceCatRobot.commands.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class StackLevel extends CommandGroup {
	public StackLevel(int level) {
		addSequential(new MoveArmToLevel(level));
		addSequential(new OpenClaw());
		addSequential(new MoveArmToLevel(1));
		addSequential(new CloseClaw());
	}
}
