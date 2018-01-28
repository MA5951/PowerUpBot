/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5951.robot;

import org.usfirst.frc.team5951.robot.commands.caliber.CatchCube;
import org.usfirst.frc.team5951.robot.commands.caliber.ClosePushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.LowerLift;
import org.usfirst.frc.team5951.robot.commands.caliber.OpenPushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.RaiseLift;
import org.usfirst.frc.team5951.robot.commands.caliber.ReleaseCube;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntake;
import org.usfirst.frc.team5951.robot.commands.intake.IntakeCube;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntake;
import org.usfirst.frc.team5951.robot.commands.intake.OutTakeCube;
import org.usfirst.frc.team5951.robot.commands.leds.FlashLEDs;
import org.usfirst.frc.team5951.robot.triggers.CubeInRobot;
import org.usfirst.frc.team5951.robot.util.JoystickUtil;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.filters.LinearDigitalFilter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//using only one joystick for test
	//public static final Joystick DRIVER_STICK = new Joystick(RobotMap.DRIVER_STICK);
	public static final XboxController OPERATOR_STICK = new XboxController(RobotMap.OPERATOR_STICK);

	public static final CubeInRobot CUBE_IN_ROBOT_TRIGGER = new CubeInRobot();
	
	public JoystickButton a = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.A);
	public JoystickButton b = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.B);
	public JoystickButton y = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.Y);
	public JoystickButton x = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.X);
	
	public JoystickButton lb = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.LB);
	public JoystickButton rb = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.RB);
	
	public JoystickButton povUP = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_UP);
	public JoystickButton povDown = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_DOWN);
	public JoystickButton povRight = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_RIGHT);
	public JoystickButton povLeft = new JoystickButton(OPERATOR_STICK, JoystickUtil.XBOX.POV_LEFT);
	

	public OI() {
		
		//Caliber
		CUBE_IN_ROBOT_TRIGGER.whenActive(new FlashLEDs());
		
		a.whenPressed(new OpenPushCube());
		b.whenPressed(new ReleaseCube());
		x.whenPressed(new ClosePushCube());
		y.whenPressed(new CatchCube());
		povUP.whenPressed(new RaiseLift());
		povDown.whenPressed(new LowerLift());
		
		//Intake
		lb.whenPressed(new CloseIntake());
		rb.whenPressed(new OpenIntake());
		povRight.whenPressed(new OutTakeCube());
		povLeft.whenPressed(new IntakeCube());
		
	}
}
