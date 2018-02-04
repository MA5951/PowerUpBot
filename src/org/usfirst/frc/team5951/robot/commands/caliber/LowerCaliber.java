package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LowerCaliber extends InstantCommand {
	Caliber caliber;
    public LowerCaliber() {
        caliber = Robot.CALIBER;
        requires(caliber);
    }

    // Called once when the command executes
    protected void initialize() {
    	if (Caliber.currentPosition == 2) {
    		caliber.switchPosition();
    	} else {
    		caliber.groundPosition();
    	}
    }

}
