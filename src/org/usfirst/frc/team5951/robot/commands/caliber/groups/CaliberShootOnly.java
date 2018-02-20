package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CaliberShootOnly extends CommandGroup {

	public CaliberShootOnly() {
		addSequential(new ReleaseCube());
		addSequential(new TimedCommand(0.25));
		addSequential(new PushCube());
	}
}
