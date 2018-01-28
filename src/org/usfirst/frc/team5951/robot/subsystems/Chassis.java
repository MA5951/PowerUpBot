package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.chassis.ArcadeDrive;
import org.usfirst.frc.team5951.robot.util.ChassisMath;
import org.usfirst.frc.team5951.robot.util.ChassisSide;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * TODO Find roborio orientation
 * 
 */
public class Chassis extends Subsystem {

	// Component declarations
	private WPI_TalonSRX leadRightMotor, leadLeftMotor;

	private ChassisSide leftChassisSide, rightChassisSide;

	private AHRS navX;

	// Global variables
	private byte multiplier = 1;

	public static final double DEAD_ZONE = 0.05;

	public static final double ENCODER_PULSE_PER_METER = 1248;

	// PID Values
	// Turn PID
	public static final double ROTATE_KP = 0.05;

	// Drive PID
	public static final double DRIVE_KP = 0.05;

	// Chassis object for reference
	private static Chassis m_chassis;

	public Chassis() {
		this.leadRightMotor = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_LEADER);

		this.leadLeftMotor = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_LEADER);

		// Case 3 motor drivetrain
		this.leftChassisSide = new ChassisSide(leadLeftMotor, new TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_1),
				new TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_2));

		this.rightChassisSide = new ChassisSide(leadRightMotor, new TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_1),
				new TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_2));

		// Case 2 motor drivetrain
		/*
		this.leftChassisSide = new ChassisSide(leadLeftMotor, new TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_1));

		this.rightChassisSide = new ChassisSide(leadRightMotor, new TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_1));
		*/

		this.navX = new AHRS(Port.kMXP);
	}

	/**
	 * Returns the same instance of chassis every time for no chance of 2 chassis at
	 * the same time
	 */
	public static Chassis getInstance() {
		if (m_chassis == null) {
			m_chassis = new Chassis();
		}

		return m_chassis;
	}

	/**
	 * Arcade drive method Multiplier is either 1 or -1, used when wanted to control
	 * robot reverse.
	 * 
	 * @param moveValue
	 *            - Y axis of joystick
	 * @param rotateValue
	 *            - X axis of joystick
	 */
	public void arcadeDrive(double moveValue, double rotateValue) {
		double[] output = ChassisMath.calculatePower(moveValue, rotateValue);

		this.leftChassisSide.set(ControlMode.PercentOutput, output[0] * this.multiplier);
		this.rightChassisSide.set(ControlMode.PercentOutput, output[1] * this.multiplier);
	}

	/**
	 * Arcade drive with dead-zone UNTESTED Multiplier is either 1 or -1 used when
	 * wanted to control the robot in reverse
	 * 
	 * @param moveValue
	 *            - Y axis of joystick
	 * @param rotateValue
	 *            - X axis of joystick
	 */
	public void arcadeDriveDZ(double moveValue, double rotateValue) {
		double[] output = ChassisMath.calculatePowerDZ(moveValue, rotateValue, DEAD_ZONE);

		this.leftChassisSide.set(ControlMode.PercentOutput, output[0] * this.multiplier);
		this.rightChassisSide.set(ControlMode.PercentOutput, output[1] * this.multiplier);
	}

	/**
	 * Stops the chassis, sets the outputs to (0,0)
	 */
	public void stopChassis() {
		this.leftChassisSide.set(ControlMode.PercentOutput, 0);
		this.rightChassisSide.set(ControlMode.PercentOutput, 0);
	}

	/**
	 * Resets the yaw gyro position
	 */
	public void resetGyro() {
		this.navX.zeroYaw();
	}

	public void resetEncoders() {
		this.leadLeftMotor.setSelectedSensorPosition(0, 0, 0);
	}

	/**
	 * Return yaw value rotation (x, z axis)
	 * 
	 * @return
	 */
	public double getYaw() {
		return this.navX.getYaw();
	}

	/**
	 * Returns the change rate of the robot's angle
	 * 
	 * @return
	 */
	public double getYawRate() {
		return this.navX.getRate();
	}

	/**
	 * Left chassis distance
	 */
	public double getLeftDistance() {
		return this.leadLeftMotor.getSelectedSensorPosition(0) * ENCODER_PULSE_PER_METER;
	}

	/**
	 * Right chassis distance
	 */
	public double getRightDistance() {
		return this.leadRightMotor.getSelectedSensorPosition(0) * ENCODER_PULSE_PER_METER;
	}

	/**
	 * Average distance of the encoders
	 * 
	 * @return
	 */
	public double getAverageDistance() {
		return (this.getRightDistance() + this.getLeftDistance()) / 2.0;
	}

	/**
	 * Sets the multiplier
	 */
	public void setMultiplyer(byte multiplyer) {
		this.multiplier = multiplyer;
	}
	
	/**
	 * Inverts the chassis, forward is reverse, left is right
	 */
	public void invertChassis() {
		this.multiplier *= -1;
	}

	/**
	 * When no command is running on the chassis, use the {@link ArcadeDrive}
	 * command
	 */
	public void initDefaultCommand() {
		this.setDefaultCommand(new ArcadeDrive());
	}
}
