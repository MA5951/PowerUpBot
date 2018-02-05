package org.usfirst.frc.team5951.robot.commands.combined;


import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.commands.caliber.SquishCube;
import org.usfirst.frc.team5951.robot.commands.intake.StopIntake;
import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDs;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CubeIn extends CommandGroup{
	
	public CubeIn() {
		addParallel(new SquishCube());
		addParallel(new StopIntake());
		addParallel(new FlashLEDs());
		addParallel(new Rumble());
	}

}
