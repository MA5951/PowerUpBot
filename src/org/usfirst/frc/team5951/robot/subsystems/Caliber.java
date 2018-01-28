package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

/**
 * Caliber subsystem-
 * 1 TalonSRX- liftMotor
 * 2 DoubleSolenoids- squish,push
 * 3 static final integers for 0 power, negative power and positive power- NO_SPEEED, MIN_SPEED, MAX_SPEED
 * 
 * methods-
 * liftRaise
 * liftLower
 * liftLock
 * caliberPushOpen
 * caliberPushClose
 * caliberCatch
 * caliberRelease * 
 **/

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Caliber extends Subsystem {
	
	//Create TalonSRK
	private TalonSRX liftMotor;  
	
	//Create 2 DoubleSolenoids
	private DoubleSolenoid squish, push;
	
	//Sets speed values	
	public static final int MAX_SPEED = 1;
	public static final int MIN_SPEED = -1;
	public static final int NO_SPEED = 0;
	
	//Sets the TalonSRX and the 2DoubleSolenoids and puts their ports
	public Caliber() {
		liftMotor = new TalonSRX (RobotMap.LIFT_MOTOR_PORT);
		squish = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.SQUISH_OPEN, RobotMap.SQUISH_CLOSE);
		push = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.PUSH_OPEN, RobotMap.PUSH_CLOSE);		
	}
	
	//Raises the caliber lift with MAX_SPEED and in the PercentOutput control mode
	public void liftRaise() {
		liftMotor.set(ControlMode.PercentOutput, MAX_SPEED);
	}
	
	//Lowers the caliber lift with MIN_SPEED and in the PercentOutput control mode
	public void liftLower() {
		liftMotor.set(ControlMode.PercentOutput, MIN_SPEED);
	}
	
	//Stops the caliber lift with NO_SPEED and in the PercentOutput control mode
	public void liftLock() {
		liftMotor.set(ControlMode.PercentOutput, NO_SPEED);
	}
	
	//Opens the push cylinder
	public void caliberPushOpen() {
		push.set(Value.kForward);		
	}
	
	//Closes the push cylinder
	public void caliberPushClose() {
		push.set(Value.kReverse);		
	}
	
	//Opens the squish/catch cylinder
	public void caliberCatch() {
		squish.set(Value.kForward);
	}
	
	//Closes the squish/catch cylinder
	public void caliberRelease() {
		squish.set(Value.kReverse);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
