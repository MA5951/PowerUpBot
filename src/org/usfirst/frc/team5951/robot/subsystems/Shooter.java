
package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.shooter.StopShot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
public class Shooter extends Subsystem {
	private TalonSRX highMotorA;
	private TalonSRX highMotorB;
	private TalonSRX lowMotorA;
	private TalonSRX lowMotorB;
	//TODO: add constants for forward speed
	//TODO: change shot to shoot
	public Shooter() {
		//TODO set one motor high and low as reverse
		this.highMotorA= new TalonSRX(RobotMap.k_SHOOTER_HIGH_A_TALON);
		this.highMotorB= new TalonSRX(RobotMap.k_SHOOTER_HIGH_B_TALON);
		this.lowMotorA= new TalonSRX(RobotMap.k_SHOOTER_LOW_A_TALON);
		this.lowMotorB= new TalonSRX(RobotMap.k_SHOOTER_LOW_B_TALON);
		
	}
	/**
	 * this function shot the cube to the scale
	 */
	public void shotHigh() {
		highMotorA.set(highMotorA.getControlMode(),1);
		highMotorB.set(highMotorB.getControlMode(),1);
		lowMotorA.set(lowMotorA.getControlMode(), 0);
		lowMotorB.set(lowMotorB.getControlMode(), 0);
	}
	/**
	 * this function shot the cube to the switch
	 */
	public void shotLow() {
		highMotorA.set(highMotorA.getControlMode(),0);
		highMotorB.set(highMotorB.getControlMode(),0);
		lowMotorA.set(lowMotorA.getControlMode(), 1);
		lowMotorB.set(lowMotorB.getControlMode(), 1);
	}
	/**
	 * this function stop all the motors of the subsystem 
	 */
	public void stop() {
		highMotorA.set(highMotorA.getControlMode(),0);
		highMotorB.set(highMotorB.getControlMode(),0);
		lowMotorA.set(lowMotorA.getControlMode(), 0);
		lowMotorB.set(lowMotorB.getControlMode(), 0);
	}
	public void shot() {

		highMotorA.set(highMotorA.getControlMode(),1);
		highMotorB.set(highMotorB.getControlMode(),1);
		lowMotorA.set(lowMotorA.getControlMode(), 1);
		lowMotorB.set(lowMotorB.getControlMode(), 1);
	}
	protected void initDefaultCommand() {
		setDefaultCommand(new StopShot());
		
	}
	
	
}
