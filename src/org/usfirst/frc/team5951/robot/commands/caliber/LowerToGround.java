package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LowerToGround extends InstantCommand {

	private Caliber caliber;
	
    public LowerToGround() {
    	caliber = Robot.CALIBER;
    	requires(caliber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	caliber.groundPosition();
    }
}
