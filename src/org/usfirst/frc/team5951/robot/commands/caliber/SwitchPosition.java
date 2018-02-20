package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeGroup;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SwitchPosition extends InstantCommand {

	private Caliber caliber;
	
    public SwitchPosition() {
        caliber = Robot.CALIBER;
        requires(caliber);
    }

    // Called once when the command executes
    protected void initialize() {
    	caliber.groundToSwitchPosition();
    	new CloseIntakeGroup();
    }

}
