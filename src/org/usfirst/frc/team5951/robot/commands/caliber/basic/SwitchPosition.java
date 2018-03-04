package org.usfirst.frc.team5951.robot.commands.caliber.basic;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchPosition extends Command {

	private Caliber caliber;
	private boolean startedMoving;
	
    public SwitchPosition() {
    	this.caliber = Robot.CALIBER;
    	requires(this.caliber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.caliber.switchPosition();
    	startedMoving = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	if(this.caliber.getCaliberRate() > 10)
//    		this.startedMoving = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return this.caliber.isInPlace() && Math.abs(this.caliber.getCaliberRate()) < 20;
    	return Math.abs(this.caliber.getCaliberRate()) < 5 && startedMoving;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
