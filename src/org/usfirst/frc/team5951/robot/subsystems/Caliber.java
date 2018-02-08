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
	private WPI_TalonSRX liftMotor;

	// Create 2 DoubleSolenoids
	private DoubleSolenoid squish, push;

	// TODO: move up
	// Create 2 digital inputs for IR sensors
	public DigitalInput leftIR;
	public DigitalInput rightIR;

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
	public static final int GROUND_POSITION = 1056
			;
	public static final int SWITCH_POSITION = 1736;
	public static final int BACK_POSITION = 2086;

	public static int currentPosition = 0;

	// Set PID values
	public static final double KP = 2.5;
	public static final double KI = 0;
	public static final double KD = 0;

	// Set pulses
	public static final double ENCODER_DPP = 500;

	// Sets the TalonSRX, the IR sensors and the 2DoubleSolenoids and puts their
	// ports
	public Caliber() {
		liftMotor = new WPI_TalonSRX(RobotMap.LIFT_MOTOR_PORT);
		squish = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.SQUISH_OPEN, RobotMap.SQUISH_CLOSE);

		liftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		liftMotor.config_kP(0, KP, 0);
		liftMotor.config_kI(0, KI, 0);
		liftMotor.config_kD(0, KD, 0);
		liftMotor.configPeakOutputForward(1, 0);
		liftMotor.configPeakOutputReverse(-0.7, 0);

		liftMotor.setInverted(true);
		liftMotor.setSensorPhase(true);
		// Set pulses
		push = new DoubleSolenoid(RobotMap.PCM_PORT, RobotMap.PUSH_OPEN, RobotMap.PUSH_CLOSE);

		leftIR = new DigitalInput(RobotMap.LEFT_IR);
		rightIR = new DigitalInput(RobotMap.RIGHT_IR);
	}

	// Raises the caliber lift with MAX_SPEED and in the PercentOutput control mode
	public void liftRaise() {
		liftMotor.set(ControlMode.PercentOutput, FORWARD_SPEED);
	}

	// Lowers the caliber lift with MIN_SPEED and in the PercentOutput control mode
	public void liftLower() {
		liftMotor.set(ControlMode.PercentOutput, BACKWARD_SPEED);
	}

	// Stops the caliber lift with NO_SPEED and in the PercentOutput control mode
	public void liftLock() {
		liftMotor.set(ControlMode.PercentOutput, NO_SPEED);
		liftMotor.setNeutralMode(NeutralMode.Brake);
	}

	public void liftNoPower() {
		liftMotor.set(ControlMode.PercentOutput, NO_SPEED);
	}

	// Opens the push cylinder
	public void caliberPush() {
		push.set(Value.kForward);
	}

	// Closes the push cylinder
	public void caliberRetract() {
		push.set(Value.kReverse);
	}

	// Opens the squish/catch cylinder
	public void caliberCatch() {
		squish.set(Value.kForward);
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
		liftMotor.set(ControlMode.PercentOutput, -0.1);
		currentPosition = 0;
	}

	/**
	 * Gets the caliber to the switch shoot position
	 */
	public void switchPosition() {
		liftMotor.set(ControlMode.Position, SWITCH_POSITION);
		currentPosition = 1;
	}

	public void backPosition() {
		liftMotor.set(ControlMode.Position, BACK_POSITION);
		currentPosition = 2;
	}

	public void togglePush() {
		if (push.get() == Value.kForward) {
			caliberRetract();
		} else {
			caliberPush();
		}

	}

	public double getPosition() {
		return liftMotor.getSensorCollection().getPulseWidthPosition();
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

	public double getCurrent() {
		// TODO Auto-generated method stub
		return liftMotor.getOutputCurrent();
	}
}
