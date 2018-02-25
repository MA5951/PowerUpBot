package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Yair Ziv
 */
public class Brakes extends Subsystem {

	// Components
	private VictorSP brakeMotor;
	private Encoder brakeEncoder;

	// PID controller
	private PIDController pidController;

	// Brakes instance
	private static Brakes m_instance;
	
	private boolean isLocked;
	
	// PID values
	public static final double KP = 0.5;
	public static final double KI = 0;
	public static final double KD = 0;
	
	public static final double LOCKED_POSITION = 50;
	public static final double UNLOCKED_POSITION = 0;

	private Brakes() {
		this.brakeMotor = new VictorSP(RobotMap.LIFT_BRAKE_MOTOR);
		this.brakeMotor.setInverted(false);

		this.brakeEncoder = new Encoder(RobotMap.CALIBER_BRAKE_ENCODER_A, RobotMap.CALIBER_BRAKE_ENCODER_B);
		this.brakeEncoder.setReverseDirection(false);
		
		this.pidController = new PIDController(KP, KI, KD, brakeEncoder, brakeMotor);
		this.pidController.setAbsoluteTolerance(3);
		this.pidController.setOutputRange(-0.3, 0.1);
		
		this.isLocked = false;
	}

	/**
	 * @return an instance of {@link Brakes}
	 */
	public static Brakes getInstance() {
		if (m_instance == null) {
			m_instance = new Brakes();
		}
		return m_instance;
	}
	
	/**
	 * PID Locks the brakes 
	 */
	public void lock() {
		this.pidController.setSetpoint(LOCKED_POSITION);
		this.isLocked = true;
	}
	
	/**
	 * Unlocks the brakes
	 */
	public void unlock() {
		this.pidController.setSetpoint(UNLOCKED_POSITION);
		this.isLocked = false;
	}
	
	/**
	 * @return - Whether the brakes are locked or not
	 */
	public boolean isLocked() {
		return this.isLocked;
	}
	
	/**
	 * @return - Brake motor position
	 */
	public double getBrakesPosition() {
		return this.brakeEncoder.getRaw();
	}
	
	/**
	 * @return PWM Output of the motor
	 */
	public double getOutput() {
		return this.brakeMotor.getRaw();
	}

	public void initDefaultCommand() {
	}
}
