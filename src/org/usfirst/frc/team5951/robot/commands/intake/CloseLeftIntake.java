package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CloseLeftIntake extends InstantCommand {

	Intake intake;
    public CloseLeftIntake() {
        intake = Robot.INTAKE;
    }

    // Called once when the command executes
    protected void initialize() {
    	intake.closeIntakeLeft();
    }

}
