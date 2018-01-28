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
 * @author FRC 5951 programming
 *  
 */
public class RobotMap {
	//TODO: fix the port until Tue (30/1/18)
	//Caliber
	public static final int LIFT_MOTOR_PORT = 0;
	
	public static final int PCM_PORT = 0;
	public static final int SQUISH_OPEN = 1;
	public static final int SQUISH_CLOSE = 2;
	public static final int PUSH_OPEN = 3;
	public static final int PUSH_CLOSE = 4;
	
	public static final int LEFT_IR = 0;
	public static final int RIGHT_IR = 1;

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

	
	//TODO: remove k
	//shooter
	public static final int k_SHOOTER_HIGH_A_TALON=1;
	public static final int k_SHOOTER_HIGH_B_TALON=2;
	public static final int k_SHOOTER_LOW_A_TALON=3;
	public static final int k_SHOOTER_LOW_B_TALON=4;

	public static final int TALON_SRX_INTAKE_MOTOR_PORT = 0;
	public static final int TALON_SRX_INTAKE_MOTOR_PORT_1 = 1;
	public static final int INTAKE_PISTON_LEFT_FORWORD= 3;
	public static final int INTAKE_PISTON_LEFT_REVERSE = 2;
	public static final int INTAKE_PISTON_RIGHT_FORWORD = 2;
	public static final int INTAKE_PISTON_RIGHT_REVERSE= 3;
}
