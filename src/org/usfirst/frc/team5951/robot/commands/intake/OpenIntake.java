package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class OpenIntake extends InstantCommand {

	public static IntakeSubSystem intake;

	public OpenIntake() {
		intake = Robot.INTAKE;
	}

	// Called once when the command executes
	protected void initialize() {
		intake.openIntake();
	}

}
