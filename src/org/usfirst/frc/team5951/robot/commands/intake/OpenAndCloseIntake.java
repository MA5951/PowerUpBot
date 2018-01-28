package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author sahar balass this command close and opens the intake system
 *         begganing
 */
public class OpenAndCloseIntake extends CommandGroup {

	public static IntakeSubSystem intake;

	public OpenAndCloseIntake() {

		addSequential(new CloseIntake());
		addSequential(new OpenIntake());
	}
}
