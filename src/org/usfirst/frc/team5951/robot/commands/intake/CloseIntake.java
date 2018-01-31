package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * @author sahar balass this command closes the intake system
 */
public class CloseIntake extends InstantCommand {

	public Intake intake;

	public CloseIntake() {
		intake = Robot.INTAKE;
	}

	protected void initialize() {
		intake.closeIntake();
	}

}
