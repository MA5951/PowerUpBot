/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDs;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.util.JoystickUtil;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//using only one joystick for test
	public static final Joystick DRIVER_STICK = new Joystick(RobotMap.DRIVER_STICK);
	public static final XboxController OPERATOR_STICK = new XboxController(RobotMap.OPERATOR_STICK);
	//TODO: remove for testing
	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();
	
	public static JoystickButton RESET_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public static JoystickButton b = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	public static JoystickButton y = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public static JoystickButton x = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	        
	public static JoystickButton lb = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	public static JoystickButton rb = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.RB);
	        
	//TODO: make this work...
	public static JoystickButton povUP = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_UP);
	public static JoystickButton povDown = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_DOWN);
	public static JoystickButton povRight = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_RIGHT);
	public static JoystickButton povLeft = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_LEFT);
	

	public OI() {
		
		//Caliber 
		//TODO: remove for testing
		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDs());
		
	}
}
