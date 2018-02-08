/**
 * @author sahar balass
 */
package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeCube extends Command {

	public Intake intake;

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
		return !OI.OPERATOR_STICK.getBumper(Hand.kLeft);
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
