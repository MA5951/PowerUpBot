package org.usfirst.frc.team5951.robot.commands;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.command.Command;

public class ShotLow extends Command {
	private Shooter shooter;

	public ShotLow() {
		shooter = Robot.SHOOTER;
		requires(shooter);
	}

	protected void initialize() {
	}

	protected void execute() {
		shooter.shot();
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
