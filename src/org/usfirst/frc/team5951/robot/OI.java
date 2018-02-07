/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.caliber.CaliberResetGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.CaliberRumble;
import org.usfirst.frc.team5951.robot.commands.caliber.CaliberShootGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.LowerCaliber;
import org.usfirst.frc.team5951.robot.commands.caliber.RaiseCaliber;
import org.usfirst.frc.team5951.robot.commands.caliber.TogglePush;
import org.usfirst.frc.team5951.robot.commands.caliber.ToggleSquish;
import org.usfirst.frc.team5951.robot.commands.combined.CubeIn;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeGroup;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.OutTakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.ToggleIntake;
import org.usfirst.frc.team5951.robot.commands.intake.TurnCube;
import org.usfirst.frc.team5951.robot.triggers.CaliberPositionBackSwitch;
import org.usfirst.frc.team5951.robot.triggers.CaliberPositionGround;
import org.usfirst.frc.team5951.robot.triggers.CaliberPositionSwitch;
import org.usfirst.frc.team5951.robot.triggers.CaliberUp;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.triggers.CubeStuck;
import org.usfirst.frc.team5951.robot.triggers.POVDown;
import org.usfirst.frc.team5951.robot.triggers.POVUp;
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
	
	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();
	public static final POVUp SWITCH_POSITION = new POVUp();
	public static final POVDown GROUND_POSITION = new POVDown();
	
	public static final CaliberUp CLOSE_INTAKE_WHEN_UP = new CaliberUp();
	public static final CaliberPositionGround RUMBLE_LOW = new CaliberPositionGround();
	public static final CaliberPositionSwitch RUMBLE_MIDDLE = new CaliberPositionSwitch();
	public static final CaliberPositionBackSwitch RUMBLE_HIGH = new CaliberPositionBackSwitch();
//	public static final CubeStuck TURN_CUBE = new CubeStuck();

	
	
	public static final JoystickButton TOGGLE_INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	public static final JoystickButton INSERT_CUBE_INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	public static final JoystickButton EJECT_CUBE_INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.RB);
	
	public static final JoystickButton TOGGLE_PUSH_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public static final JoystickButton TOGGLE_SQUISH_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	public static final JoystickButton SHOOT_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public static final JoystickButton RESET_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);

	
	public OI() {
		
		//Caliber 
		//TODO: remove for testing
		TOGGLE_INTAKE.toggleWhenPressed(new ToggleIntake());
		INSERT_CUBE_INTAKE.whileHeld(new IntakeCube());
		EJECT_CUBE_INTAKE.whileHeld(new OutTakeCube());
		TOGGLE_PUSH_CALIBER.whenPressed(new TogglePush());
		TOGGLE_SQUISH_CALIBER.whenPressed(new ToggleSquish());
		SHOOT_CALIBER.whenPressed(new CaliberShootGroup());
		RESET_CALIBER.whenPressed(new CaliberResetGroup());

		SWITCH_POSITION.whenActive(new RaiseCaliber());
		GROUND_POSITION.whenActive(new LowerCaliber());
		
		CLOSE_INTAKE_WHEN_UP.whenActive(new CloseIntakeGroup());
		RUMBLE_LOW.whenActive(new CaliberRumble(1, 0.3));
		RUMBLE_MIDDLE.whenActive(new CaliberRumble(1, 0.6));
		RUMBLE_HIGH.whenActive(new CaliberRumble(1, 1));
//		TURN_CUBE.whenActive(new TurnCube());
		CUBE_IN_ROBOT_TRIGGER.whenActive(new CubeIn());

		
	}
}
