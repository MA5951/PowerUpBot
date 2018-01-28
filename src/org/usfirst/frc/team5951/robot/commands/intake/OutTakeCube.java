package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 * @author sahar balass
 *this command shoots the cube out from the intake
 */ 

public class OutTakeCube extends Command {

	public static IntakeSubSystem intake;

	public OutTakeCube() {
		intake = Robot.INTAKE;
		requires(Robot.INTAKE);

	}

	/**
	 *  Called just before this Command runs the first time
	 */
	protected void initialize() {
	}

	/**
	 *  this void calls the shoot command from the subsystem.
	 */
	protected void execute() {
		intake.shootCube();
	}

	/**
	 *  Make this return true when this Command no longer needs to run execute()
	 */
	protected boolean isFinished() {
		return false;
	}

	/**
	 *  Called once after isFinished returns true
	 *  stops the motors
	 */
	protected void end() {
		intake.stopCube();
	}

	/**
	 *  stops the motors
	 */
	protected void interrupted() {
		intake.stopCube();
	}
}
