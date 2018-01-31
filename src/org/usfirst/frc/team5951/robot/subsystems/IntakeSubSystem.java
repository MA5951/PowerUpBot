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

	public static final int SPEED_IN = -1;
	public static final int SPEED_OUT = 1;
	public static final int Stop_Motor = 0;

	private TalonSRX LeftMotor;
	private TalonSRX RightMotor;
	private DoubleSolenoid LeftSolenoid;
	private DoubleSolenoid RightSolenoid;

	public IntakeSubSystem() {
		// TODO: rename constants of ports into 1 and 2 (or left and right)
		LeftMotor = new TalonSRX(RobotMap.TALON_SRX_INTAKE_MOTOR_PORT_1);
		RightMotor = new TalonSRX(RobotMap.TALON_SRX_INTAKE_MOTOR_PORT_2);
		LeftSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.INTAKE_PISTON_LEFT_REVERSE,
				RobotMap.INTAKE_PISTON_LEFT_FORWORD);
		RightSolenoid = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.INTAKE_PISTON_RIGHT_FORWORD,
				RobotMap.INTAKE_PISTON_RIGHT_REVERSE);
	}

	public void takeCubeInside() {
		LeftMotor.set(ControlMode.PercentOutput, SPEED_IN);
		RightMotor.set(ControlMode.PercentOutput, SPEED_IN);

	}

	public void shootCube() {

		LeftMotor.set(ControlMode.PercentOutput, SPEED_OUT);
		RightMotor.set(ControlMode.PercentOutput, SPEED_OUT);

	}

	public void stopCube() {

		LeftMotor.set(ControlMode.PercentOutput, Stop_Motor);
		RightMotor.set(ControlMode.PercentOutput, Stop_Motor);

	}

	public void closeIntake() {
		LeftSolenoid.set(Value.kReverse);
		RightSolenoid.set(Value.kReverse);
	}

	public void openIntake() {
		LeftSolenoid.set(Value.kForward);
		RightSolenoid.set(Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
