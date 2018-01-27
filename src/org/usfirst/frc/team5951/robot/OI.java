/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDs;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static final Joystick DRIVER_STICK = new Joystick(RobotMap.DRIVER_STICK);
	public static final XboxController OPERATOR_STICK = new XboxController(RobotMap.OPERATOR_STICK);

	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();

	public OI() {
		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDs());
	}
}
