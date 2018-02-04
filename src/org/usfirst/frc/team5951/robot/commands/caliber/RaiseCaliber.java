package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RaiseCaliber extends InstantCommand {

	private Caliber caliber;
	
    public RaiseCaliber() {
    	caliber = Robot.CALIBER;
    	requires(this.caliber);        
    }

    // Called once when the command executes
    protected void initialize() {
    	if(Caliber.currentPosition == 0) {
    		caliber.switchPosition();
    	} else {
    		caliber.backPosition();
    	}
    }

}
