package org.usfirst.frc.team5951.robot.commands.combined;

import org.usfirst.frc.team5951.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;

public class Rumble extends Command {
	
	
	

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		OI.OPERATOR_STICK.setRumble(RumbleType.kLeftRumble, 0.5);
		OI.OPERATOR_STICK.setRumble(RumbleType.kRightRumble, 0.5);
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
