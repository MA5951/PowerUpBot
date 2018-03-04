/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.brakes.ResetBrakeEncoder;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ResetStopperEncoder;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ToggleBlocker;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.ToggleBrakes;
import org.usfirst.frc.team5951.robot.commands.caliber.basic.TogglePush;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.BackwardPositionGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.GroundPositionGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.ScalePositionGroup;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.SwitchPositionGroup;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCommand;
import org.usfirst.frc.team5951.robot.commands.intake.OuttakeCommand;
import org.usfirst.frc.team5951.robot.commands.intake.ToggleIntakePosition;
import org.usfirst.frc.team5951.robot.commands.shooter.RollUp;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.triggers.POVDown;
import org.usfirst.frc.team5951.robot.triggers.POVLeft;
import org.usfirst.frc.team5951.robot.triggers.POVRight;
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
	// using only one joystick for test
	public static final Joystick DRIVER_STICK = new Joystick(RobotMap.DRIVER_STICK);
	public static final XboxController OPERATOR_STICK = new XboxController(RobotMap.OPERATOR_STICK);

	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();

	public static final JoystickButton TOGGLE_PUSH = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public static final JoystickButton PREPARE_TO_SHOOT = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public static final JoystickButton TOGGLE_CUBE_CLOBKER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	public static final JoystickButton TOGGLE_INTAKE_PISTONS = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);

	public static final JoystickButton RESET_BRAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.START);
	public static final JoystickButton TOGGLE_BRAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.BACK);
	
	public static final JoystickButton RESET_BLOCKER = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.STICK_LEFT);

	public static final JoystickButton INTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.L1);
	public static final JoystickButton OUTTAKE = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.R1);

	public static final POVDown GROUND_POSITION = new POVDown(OPERATOR_STICK);
	public static final POVLeft SWITCH_POSITION = new POVLeft(OPERATOR_STICK);
	public static final POVUp SCALE_POSITION = new POVUp(OPERATOR_STICK);
	public static final POVRight BACKWARD_POSITION = new POVRight(OPERATOR_STICK);

	public OI() {
//		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDsCube());
//		CUBE_IN_ROBOT_TRIGGER.whenInactive(new LEDsOff());

		TOGGLE_PUSH.whenPressed(new TogglePush());
		PREPARE_TO_SHOOT.whileHeld(new RollUp());
		TOGGLE_CUBE_CLOBKER.toggleWhenPressed(new ToggleBlocker());
		TOGGLE_INTAKE_PISTONS.toggleWhenPressed(new ToggleIntakePosition());

		INTAKE.whileHeld(new IntakeCommand());
		OUTTAKE.whileHeld(new OuttakeCommand());

		GROUND_POSITION.whenActive(new GroundPositionGroup());
		SWITCH_POSITION.whenActive(new SwitchPositionGroup());
		SCALE_POSITION.whenActive(new ScalePositionGroup());
		BACKWARD_POSITION.whenActive(new BackwardPositionGroup());

		RESET_BRAKE.whenPressed(new ResetBrakeEncoder(2));
		TOGGLE_BRAKE.toggleWhenPressed(new ToggleBrakes());
		
		RESET_BLOCKER.whenPressed(new ResetStopperEncoder(4));
	}
}
