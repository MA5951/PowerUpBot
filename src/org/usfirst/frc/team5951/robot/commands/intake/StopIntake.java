package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Command;

public class StopIntake extends Command {

	Intake intake;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		intake = Robot.INTAKE;
		requires(intake);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		intake.stopCube();
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
