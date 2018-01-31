package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author sahar balass
 */
public class IntakeSubSystem extends Subsystem {

	// TODO: rename constant in speed/ out speed + formatting needs to be ALL CAPS
	public static final int Intake_Motor = -1;
	public static final int Out_Take_Motor = 1;
	public static final int Stop_Motor = 0;

	private TalonSRX LeftMotor;
	private TalonSRX RightMotor;
	private DoubleSolenoid LeftSolenoid;
	private DoubleSolenoid RightSolenoid;

	public IntakeSubSystem() {
		// TODO: rename constants of ports into 1 and 2 (or left and right)
		LeftMotor = new TalonSRX(RobotMap.TALON_SRX_INTAKE_MOTOR_PORT);
		RightMotor = new TalonSRX(RobotMap.TALON_SRX_INTAKE_MOTOR_PORT_1);
		LeftSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.INTAKE_PISTON_LEFT_REVERSE,
				RobotMap.INTAKE_PISTON_LEFT_FORWORD);
		RightSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.INTAKE_PISTON_RIGHT_FORWORD,
				RobotMap.INTAKE_PISTON_RIGHT_REVERSE);
	}

	/**
	 * Rolls the intake to insert a cube
	 */
	public void insertCube() {
		LeftMotor.set(ControlMode.PercentOutput, Intake_Motor);
		RightMotor.set(ControlMode.PercentOutput, Intake_Motor);
	}

	/**
	 * Rolls the intake to release the cube
	 */
	public void releaseCube() {
		LeftMotor.set(ControlMode.PercentOutput, Out_Take_Motor);
		RightMotor.set(ControlMode.PercentOutput, Out_Take_Motor);
	}

	/**
	 * Stops the rollers
	 */
	public void stopCube() {
		LeftMotor.set(ControlMode.PercentOutput, Stop_Motor);
		RightMotor.set(ControlMode.PercentOutput, Stop_Motor);
	}

	/**
	 * Closes the intake pistons
	 */
	public void closeIntake() {
		LeftSolenoid.set(Value.kReverse);
		RightSolenoid.set(Value.kReverse);
	}

	/**
	 * Opens the intake pistons
	 */
	public void openIntake() {
		LeftSolenoid.set(Value.kForward);
		RightSolenoid.set(Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {

	}

}
