package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleSquish extends InstantCommand {
	Caliber caliber;
    public ToggleSquish() {
    	caliber = Robot.CALIBER;
        
    }

    // Called once when the command executes
    protected void initialize() {
    	caliber.toggleSqiush();
    }

}
