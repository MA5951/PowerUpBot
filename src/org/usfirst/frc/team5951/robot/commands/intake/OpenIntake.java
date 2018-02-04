package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenIntake extends InstantCommand {

	public Intake intake;

	public OpenIntake() {
		this.intake = Robot.INTAKE;
	}

	// Called once when the command executes
	protected void initialize() {
		this.intake.openIntakeLeft();
		this.intake.openIntakeRight();
	}

}
