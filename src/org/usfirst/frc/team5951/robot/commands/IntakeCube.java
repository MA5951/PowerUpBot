/**
 * @author sahar balass
 */
package org.usfirst.frc.team5951.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

public class IntakeCube extends Command {

	public static IntakeSubSystem intake;

	// this command intakes a cube into the robot

	public IntakeCube() {
		intake = Robot.intake;
		requires(Robot.intake);
	}

	@Override
	protected void initialize() {

	}

	// called from subsytem to take the cube in the intake
	@Override
	protected void execute() {
		intake.takeCubeInside();
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	// stops the motors
	@Override
	protected void end() {
		intake.stopCube();
	}

	// stops the motors
	@Override
	protected void interrupted() {
		intake.stopCube();
	}
}
