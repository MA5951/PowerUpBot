/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Motors
	public static final int LIFT_MOTOR_PORT = 0;
	
	//Pneomatics
	public static final int PCM_PORT = 0;
	public static final int SQUISH_OPEN = 1;
	public static final int SQUISH_CLOSE = 2;
	public static final int PUSH_OPEN = 3;
	public static final int PUSH_CLOSE = 4;
	
}
