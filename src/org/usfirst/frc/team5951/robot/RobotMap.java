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
 * @author sahar balass
 */
public class RobotMap {
	
	public static final int PCM = 0;
	public static final int TALON_SRX_INTAKE_MOTOR_PORT = 0;
	public static final int TALON_SRX_INTAKE_MOTOR_PORT_1 = 1;
	public static final int INTAKE_PISTON_LEFT_REVERSE = 2;
	public static final int INTAKE_PISTON_LEFT_FORWORD= 3;
	public static final int INTAKE_PISTON_RIGHT_FORWORD = 2;
	public static final int INTAKE_PISTON_RIGHT_REVERSE= 3;
}
