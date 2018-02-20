package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author sahar balass
 */
public class Intake extends Subsystem {

	// TODO: rename constant in speed/ out speed + formatting needs to be ALL CAPS
	public static final int INTAKE_MOTOR = 1;
	public static final int RELEASE_SPEED = -1;
	public static final int STOP_SPEED = 0;
	public static final double CUBE_STUCK_CURRENT = 10;

	private WPI_TalonSRX leftMotor;
	private WPI_TalonSRX rightMotor;
	private DoubleSolenoid leftSolenoid;
	private DoubleSolenoid rightSolenoid;

	public Intake() {
		// TODO: rename constants of ports into 1 and 2 (or left and right)
		leftMotor = new WPI_TalonSRX(RobotMap.INTAKE_LEFT_MOTOR);
		leftMotor.setInverted(true);
		rightMotor = new WPI_TalonSRX(RobotMap.INTAKE_RIGHT_MOTOR);
		leftSolenoid = new DoubleSolenoid(RobotMap.PCM_PRIMARY_PORT, RobotMap.INTAKE_PISTON_LEFT_REVERSE,
				RobotMap.INTAKE_PISTON_LEFT_FORWORD);
		rightSolenoid = new DoubleSolenoid(RobotMap.PCM_PRIMARY_PORT, RobotMap.INTAKE_PISTON_RIGHT_FORWORD,
				RobotMap.INTAKE_PISTON_RIGHT_REVERSE);

		System.out.println("Intake intake intake intake intake");
	}

	/**
	 * Rolls the intake to insert a cube
	 */
	public void insertCube() {
		leftMotor.set(ControlMode.PercentOutput, INTAKE_MOTOR);
		rightMotor.set(ControlMode.PercentOutput, INTAKE_MOTOR);
	}

	/**
	 * Rolls the intake to release the cube
	 */
	public void releaseCube() {
		leftMotor.set(ControlMode.PercentOutput, RELEASE_SPEED);
		rightMotor.set(ControlMode.PercentOutput, RELEASE_SPEED);
	}
	
	public void turnCube() {
		leftMotor.set(ControlMode.PercentOutput, RELEASE_SPEED);
		rightMotor.set(ControlMode.PercentOutput, -RELEASE_SPEED);
	}

	/**
	 * Stops the rollers
	 */
	public void stopCube() {
		leftMotor.set(ControlMode.PercentOutput, STOP_SPEED);
		rightMotor.set(ControlMode.PercentOutput, STOP_SPEED);
	}

	/**
	 * Closes the intake pistons
	 */
	public void closeIntakeLeft() {
		leftSolenoid.set(Value.kForward);
	}

	public void closeIntakeRight() {
		rightSolenoid.set(Value.kForward);
	}

	/**
	 * Opens the intake pistons
	 */
	public void openIntakeLeft() {
		leftSolenoid.set(Value.kReverse);
	}

	public void openIntakeRight() {
		rightSolenoid.set(Value.kReverse);
	}
	
	public boolean isCubeStuck() {
		return this.leftMotor.getOutputCurrent() >= CUBE_STUCK_CURRENT ||
				this.rightMotor.getOutputCurrent() >= CUBE_STUCK_CURRENT;
	}
	
	public double getLeftCurrent() {
		return this.leftMotor.getOutputCurrent();
	}
	
	public double getRightCurrent() {
		return this.rightMotor.getOutputCurrent();
	}

	@Override
	protected void initDefaultCommand() {

	}

}
