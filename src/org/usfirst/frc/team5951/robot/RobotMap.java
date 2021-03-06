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
 * 
 * @author FRC 5951 programming
 * 
 */
public class RobotMap {
	
	// OI
	public static final int DRIVER_STICK = 0;
	public static final int OPERATOR_STICK = 1;
	
	
	// Caliber
	public static final int LIFT_MOTOR_PORT = 9;

	// Chassis
	public static final int CHASSIS_RIGHT_LEADER = 5;
	public static final int CHASSIS_RIGHT_FOLLOWER_1 = 6;
	public static final int CHASSIS_RIGHT_FOLLOWER_2 = 7;
	public static final int CHASSIS_LEFT_LEADER = 2;
	public static final int CHASSIS_LEFT_FOLLOWER_1 = 3;
	public static final int CHASSIS_LEFT_FOLLOWER_2 = 4;

	// shooter
	public static final int SHOOTER_HIGH_A_TALON = 10;
	public static final int SHOOTER_HIGH_B_TALON = 11;
	public static final int SHOOTER_LOW_A_TALON = 12;
	public static final int SHOOTER_LOW_B_TALON = 13;

	public static final int INTAKE_LEFT_MOTOR = 1;
	public static final int INTAKE_RIGHT_MOTOR = 8;

	public static final int PCM_PORT = 0;
	public static final int SQUISH_OPEN = 5;
	public static final int SQUISH_CLOSE = 4;
	public static final int PUSH_OPEN = 2;
	public static final int PUSH_CLOSE = 0;

	public static final int INTAKE_PISTON_LEFT_FORWORD = 3;
	public static final int INTAKE_PISTON_LEFT_REVERSE = 1;
	public static final int INTAKE_PISTON_RIGHT_FORWORD = 7;
	public static final int INTAKE_PISTON_RIGHT_REVERSE = 6;

	public static final int LEFT_IR = 1;
	public static final int RIGHT_IR = 2;

	// LEDs
	public static final int LED_RELAY = 0;
}
