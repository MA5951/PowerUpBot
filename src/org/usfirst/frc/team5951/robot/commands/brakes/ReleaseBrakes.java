package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ReleaseBrakes extends Command {

	public ReleaseBrakes() {
    	requires(Brakes.getInstance());
    	requires(Robot.CALIBER);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.CALIBER.setPosition(Robot.CALIBER.getPosition());
    	Brakes.getInstance().unlock();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Brakes.getInstance().isInPlace();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
