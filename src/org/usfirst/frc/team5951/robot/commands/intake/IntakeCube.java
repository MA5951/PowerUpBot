/**
 * @author sahar balass
 */
package org.usfirst.frc.team5951.robot.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

public class IntakeCube extends Command {

	public IntakeSubSystem intake;

	// this command intakes a cube into the robot

	public IntakeCube() {
		intake = Robot.INTAKE;
		requires(Robot.INTAKE);
	}

	@Override
	protected void initialize() {

	}

	// called from subsytem to take the cube in the intake
	@Override
	protected void execute() {
		intake.insertCube();
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
