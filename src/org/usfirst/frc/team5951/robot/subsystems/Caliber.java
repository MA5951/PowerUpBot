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
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Caliber extends Subsystem {

	// Create TalonSRK
	private WPI_TalonSRX mainLiftMotor;
	private WPI_TalonSRX secondaryLiftMotor;

	// Create 2 DoubleSolenoids
	private DoubleSolenoid squish, push;

	// TODO: move up
	// Create 2 digital inputs for IR sensors
	private DigitalInput leftIR;
	private DigitalInput rightIR;

	// Sets speed values
	// TODO: rename MAX MIN speed
	public static final double FORWARD_SPEED = 0.8;
	public static final double BACKWARD_SPEED = -0.1;
	public static final double NO_SPEED = 0;

	// Sets position values
	// Practice robot
	// public static final int GROUND_POSITION = 270;
	// public static final int SWITCH_POSITION = 950;
	// public static final int BACK_POSITION = 1300;
	// Competition robot
	public static final int GROUND_POSITION = 1765;
	public static final int SWITCH_POSITION = 1200;
	public static final int LITTLE_OVER_SWITCH_POSITION = 1170;
	public static final int BACK_POSITION = 750;

	public static int currentPosition = 0;

	// Set PID values
	public static final double KP_TO_FORWARD = 2.15;
	public static final double KP_BACKWARD_TO_SWITCH = 1.5;
	public static final double KP_SWITCH_TO_BACKWARD = 1;
	public static final double KI_TO_FORWARD = 0.001;
	public static final double KI_TO_BACKWARD = 0;
	public static final double KD = 1;

	// Set pulses
	public static final double ENCODER_DPP = 500;

	// Sets the TalonSRX, the IR sensors and the 2DoubleSolenoids and puts their
	// ports
	public Caliber() {
		mainLiftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR_MAIN_PORT);
		secondaryLiftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR_SECONDARY_PORT);

		squish = new DoubleSolenoid(RobotMap.PCM_SECONDARY_PORT, RobotMap.SQUISH_OPEN, RobotMap.SQUISH_CLOSE);

		mainLiftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		mainLiftMotor.config_kP(0, KP_TO_FORWARD, 0);
		mainLiftMotor.config_kI(0, KI_TO_FORWARD, 0);
		mainLiftMotor.config_kD(0, KD, 0);
		mainLiftMotor.configPeakOutputForward(0.2, 0);
		mainLiftMotor.configPeakOutputReverse(-1, 0);

		mainLiftMotor.setInverted(false);
		secondaryLiftMotor.setInverted(true);
		// Set pulses
		push = new DoubleSolenoid(RobotMap.PCM_PRIMARY_PORT, RobotMap.PUSH_OPEN, RobotMap.PUSH_CLOSE);

		leftIR = new DigitalInput(RobotMap.LEFT_IR);
		rightIR = new DigitalInput(RobotMap.RIGHT_IR);

		secondaryLiftMotor.follow(mainLiftMotor);
	}

	// Raises the caliber lift with MAX_SPEED and in the PercentOutput control mode
	public void liftRaise() {
		mainLiftMotor.set(ControlMode.PercentOutput, FORWARD_SPEED);
	}

	// Lowers the caliber lift with MIN_SPEED and in the PercentOutput control mode
	public void liftLower() {
		mainLiftMotor.set(ControlMode.PercentOutput, BACKWARD_SPEED);
	}

	// Stops the caliber lift with NO_SPEED and in the PercentOutput control mode
	public void liftLock() {
		mainLiftMotor.set(ControlMode.PercentOutput, NO_SPEED);
		mainLiftMotor.setNeutralMode(NeutralMode.Brake);
	}

	public void liftNoPower() {
		mainLiftMotor.set(ControlMode.PercentOutput, NO_SPEED);
	}

	// Opens the push cylinder
	public void caliberPush() {
		squish.set(Value.kReverse);
		push.set(Value.kForward);
	}

	// Closes the push cylinder
	public void caliberRetract() {
		push.set(Value.kReverse);
	}

	// Opens the squish/catch cylinder
	public void caliberCatch() {
		if (push.get() != Value.kForward) {
			squish.set(Value.kForward);
		}
	}

	// Closes the squish/catch cylinder
	public void caliberRelease() {
		squish.set(Value.kReverse);
	}

	// Returns the left IR value
	public boolean leftIR() {
		return !leftIR.get();
	}

	// Returns the right IR value
	public boolean rightIR() {
		return !rightIR.get();
	}

	// Returns true if the left IR value or the right IR value is true
	// Returns the opposite because the sensor outputs true if there is no object.
	public boolean isCubeIn() {
		return !leftIR.get() || !rightIR.get();
	}

	/**
	 * Gets the caliber to the ground intake position
	 */
	public void groundPosition() {
		mainLiftMotor.config_kP(0, KP_TO_FORWARD, 0);
		mainLiftMotor.config_kI(0, KI_TO_BACKWARD, 0);
		mainLiftMotor.set(ControlMode.PercentOutput, 0.09);
		currentPosition = 0;
	}

	/**
	 * Gets the caliber to the switch shoot position
	 */
	public void groundToSwitchPosition() {
		mainLiftMotor.config_kP(0, KP_TO_FORWARD, 0);
		mainLiftMotor.config_kI(0, KI_TO_FORWARD, 0);
		mainLiftMotor.set(ControlMode.Position, SWITCH_POSITION);
		currentPosition = 1;
	}

	public void backwardToSwitchPosition() {
		mainLiftMotor.config_kP(0, KP_BACKWARD_TO_SWITCH, 0);
		mainLiftMotor.config_kI(0, KI_TO_BACKWARD, 0);
		mainLiftMotor.set(ControlMode.Position, SWITCH_POSITION);
		currentPosition = 1;
	}

	public void littleOverSwitchPosition() {
		mainLiftMotor.config_kP(0, KP_TO_FORWARD, 0);
		mainLiftMotor.config_kI(0, KI_TO_BACKWARD, 0);
		mainLiftMotor.set(ControlMode.Position, LITTLE_OVER_SWITCH_POSITION);
		currentPosition = 1;
	}

	/**
	 * Gets the caliber to the back shooting position
	 */
	public void backPosition() {
		mainLiftMotor.config_kP(0, KP_SWITCH_TO_BACKWARD, 0);
		mainLiftMotor.config_kI(0, KI_TO_BACKWARD, 0);
		mainLiftMotor.set(ControlMode.Position, BACK_POSITION);
		currentPosition = 2;
	}

	public void stopCaliber() {
		mainLiftMotor.set(ControlMode.PercentOutput, 0);
	}

	public void togglePush() {
		if (push.get() == Value.kForward) {
			caliberRetract();
		} else {
			caliberPush();
		}

	}

	public double getPosition() {
		return mainLiftMotor.getSensorCollection().getPulseWidthPosition();
	}

	public void toggleSqiush() {
		if (squish.get() == Value.kForward) {
			caliberRelease();
		} else {
			caliberCatch();
		}

	}

	@Override
	protected void initDefaultCommand() {
	}

	public double getOutput() {
		// TODO Auto-generated method stub
		return mainLiftMotor.getMotorOutputPercent();
	}
}
