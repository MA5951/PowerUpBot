package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;

/**
 * This Command moves the caliber's lift motor forward which is raises the caliber
 */
public class RaiseLift extends Command {
	
	public static Caliber caliber;

    public RaiseLift() {
    	caliber = Robot.CALIBER;
    	requires (caliber);
    }

    // Called just before this Command runs the first time- sends zero power to the lift motor
    // using- liftLock method of Caliber subsystem
    protected void initialize() {
    	caliber.liftLock();
    }

    // Called repeatedly when this Command is scheduled to run- sends positive power to the lift motor
    // using- liftRaise method of Caliber subsystem
    protected void execute() {
    	caliber.liftRaise();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true- sends zero power to the lift motor
    // using- liftLock method of Caliber subsystem
    protected void end() {
    	caliber.liftLock();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
