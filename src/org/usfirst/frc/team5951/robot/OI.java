/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.auton.LeftSwitchRightAngle;
import org.usfirst.frc.team5951.robot.commands.auton.MiddleToLeftAuton;
import org.usfirst.frc.team5951.robot.commands.auton.MiddleToLeftTwoCubeAuto;
import org.usfirst.frc.team5951.robot.commands.auton.MiddleToRightTwoCubeAuto;
import org.usfirst.frc.team5951.robot.commands.caliber.TogglePush;
import org.usfirst.frc.team5951.robot.commands.caliber.ToggleSquish;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.CaliberShootGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerCaliberGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.RaiseCaliberGroup;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.OutTakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.ShakeIntakePistons;
import org.usfirst.frc.team5951.robot.commands.intake.ToggleIntakePistons;
import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDsCube;
import org.usfirst.frc.team5951.robot.commands.leds.LEDsOff;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.triggers.CubeStuckTrigger;
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
	public static final POVUp RAISE_CALIBER = new POVUp();
	public static final POVDown LOWER_CALIBER = new POVDown();
	public static final CubeStuckTrigger CUBE_STUCK = new CubeStuckTrigger();
	
	public static final JoystickButton TOGGLE_INTAKE_PISTONS = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	public static final JoystickButton INSERT_CUBE_INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	public static final JoystickButton EJECT_CUBE_INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.RB);
	
	public static final JoystickButton TOGGLE_PUSH_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public static final JoystickButton TOGGLE_SQUISH_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	public static final JoystickButton SHOOT_CALIBER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public static final JoystickButton SHAKE_PISTONS = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	
	public static final JoystickButton DRIVE_1 = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.BACK);

	
	public OI() {
		
		//Caliber 
		//TODO: remove for testing
		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDsCube());
		CUBE_IN_ROBOT_TRIGGER.whenInactive(new LEDsOff());
		TOGGLE_INTAKE_PISTONS.toggleWhenPressed(new ToggleIntakePistons());
		INSERT_CUBE_INTAKE.whileHeld(new IntakeCube());
		EJECT_CUBE_INTAKE.whileHeld(new OutTakeCube());
		TOGGLE_PUSH_CALIBER.whenPressed(new TogglePush());
		TOGGLE_SQUISH_CALIBER.whenPressed(new ToggleSquish());
		SHOOT_CALIBER.whenPressed(new CaliberShootGroup());
		SHAKE_PISTONS.whenPressed(new ShakeIntakePistons());

		RAISE_CALIBER.whenActive(new RaiseCaliberGroup());
		LOWER_CALIBER.whenActive(new LowerCaliberGroup());

		DRIVE_1.whenPressed(new MiddleToRightTwoCubeAuto
				());
	}
}
