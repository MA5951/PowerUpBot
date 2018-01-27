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
	
	//OI
	public static final int DRIVER_STICK = 0;
	public static final int OPERATOR_STICK = 1;
	
	//Chassis
	public static final int CHASSIS_RIGHT_LEADER = 1; 
	public static final int CHASSIS_RIGHT_FOLLOWER_1 = 2;
	public static final int CHASSIS_RIGHT_FOLLOWER_2 = 3;
	public static final int CHASSIS_LEFT_LEADER = 4;
	public static final int CHASSIS_LEFT_FOLLOWER_1 = 5;
	public static final int CHASSIS_LEFT_FOLLOWER_2 = 6;
	
	//LEDs
	public static final int LED_RELAY = 1;
	
}
