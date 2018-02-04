package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * This Instant Command opens the cylinder which is located in the back of the
 * caliber
 */
public class PushCube extends InstantCommand {

	// Creates a new object of the Caliber subsystem
	public Caliber caliber;

	// In the constructor- sets the Caliber object equal to the Caliber object that
	// is created in the Robot class.
	public PushCube() {
		caliber = Robot.CALIBER;
	}

	// In the Initialize method- runs the method caliberPushOpen of the caliber one
	// time
	protected void initialize() {
		caliber.caliberPush();
	}

}
