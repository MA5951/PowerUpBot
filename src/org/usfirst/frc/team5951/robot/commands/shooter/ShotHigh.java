package org.usfirst.frc.team5951.robot.commands.shooter;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShotHigh extends Command {
	private Shooter shooter;

	public ShotHigh() {
//		shooter = Robot.SHOOTER;
		requires(shooter);
	}

	protected void initialize() {
	}

	protected void execute() {
		shooter.shotHigh();
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
