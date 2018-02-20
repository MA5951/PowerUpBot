/**
 * @author sahar balass
 */
package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCube extends Command {

	public Intake intake;
	
	public double insideCounter;

	public IntakeCube() {
		intake = Robot.INTAKE;
		requires(Robot.INTAKE);
		insideCounter = 0;
	}

	@Override
	protected void initialize() {
		Robot.CALIBER.caliberRelease();
		insideCounter = 0;
	}

	// called from subsytem to take the cube in the intake
	@Override
	protected void execute() {
		intake.closeIntakeLeft();
		intake.closeIntakeRight();
		intake.insertCube();
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	// stops the motors
	@Override
	protected void end() {
//		Robot.CALIBER.caliberRetract();
		intake.stopCube();
	}

	// stops the motors
	@Override
	protected void interrupted() {
		intake.stopCube();
		intake.openIntakeLeft();
		intake.openIntakeRight();
	}
}
