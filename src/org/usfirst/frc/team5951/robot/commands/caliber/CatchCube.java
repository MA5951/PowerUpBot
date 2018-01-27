package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * This Instant Command opens the cylinders which are located in the sides of the caliber
 */
public class CatchCube extends InstantCommand {
	
	//Creates a new object of the Caliber subsystem
	public static Caliber caliber;

	//In the constructor- sets the Caliber object equal to the Caliber object that is created in the Robot class.
    public CatchCube() {
    	caliber = Robot.caliber;
    }
    
    //In the Initialize method- runs the method caliberCatch of the caliber one time
    protected void initialize() {
    	caliber.caliberCatch();
    }

}
