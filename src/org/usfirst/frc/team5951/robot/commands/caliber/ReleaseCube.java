package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * This Instant Command closes the cylinders which are located in the sides of
 * the caliber
 */
public class ReleaseCube extends InstantCommand {

	// Creates a new object of the Caliber subsystem
	public Caliber caliber;

	// In the constructor- sets the Caliber object equal to the Caliber object that
	// is created in the Robot class.
	public ReleaseCube() {
		caliber = Robot.CALIBER;
	}

	// In the Initialize method- runs the method caliberRelease of the caliber one
	// time
	protected void initialize() {
		caliber.caliberRelease();
	}
}
