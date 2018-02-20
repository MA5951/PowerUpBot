package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerToGround extends Command {

	private Caliber caliber;

	public LowerToGround() {
		caliber = Robot.CALIBER;
		requires(caliber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		caliber.groundPosition();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(this.caliber.getPosition() - Caliber.GROUND_POSITION) < 20;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.caliber.stopCaliber();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.caliber.stopCaliber();
	}
}
