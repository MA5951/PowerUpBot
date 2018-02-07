package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class CaliberRumble extends TimedCommand {

	private Caliber caliber;
	private double value;
	
    public CaliberRumble(double timeout, double value) {
        super(timeout);
        caliber = Robot.CALIBER;
        this.value = value;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.caliber.rumbleControllerCaliber(value);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Called once after timeout
    protected void end() {
    	this.caliber.rumbleControllerCaliber(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();    
    }
}
