package org.usfirst.frc.team5951.robot.commands.chassis;

import org.usfirst.frc.team5951.robot.subsystems.Chassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToAngle extends Command {

	private Chassis chassis;
	
	private double rotateAngle;
	
    public TurnToAngle(double rotateAngle) {
    	this.chassis = Chassis.getInstance();
    	requires(this.chassis);
    	
    	this.rotateAngle = rotateAngle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.chassis.resetGyro();
    	this.chassis.setMultiplyer(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.chassis.arcadeDrive(0, getDistanceError() * Chassis.ROTATE_KP);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(this.getDistanceError()) < 2);
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private double getDistanceError() {
    	return this.rotateAngle - this.chassis.getYaw();
    }
}
