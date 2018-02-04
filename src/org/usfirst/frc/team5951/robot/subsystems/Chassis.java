package org.usfirst.frc.team5951.robot.subsystems;

import org.usfirst.frc.team5951.robot.RobotMap;
import org.usfirst.frc.team5951.robot.commands.chassis.ArcadeDrive;
import org.usfirst.frc.team5951.robot.util.ChassisMath;
import org.usfirst.frc.team5951.robot.util.ChassisSide;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
	private WPI_TalonSRX leadRightMotor, rightFollower1, rightFollower2,
						leadLeftMotor, leftFollower1, leftFollower2;				

	private ChassisSide leftChassisSide, rightChassisSide;

	private AHRS navX;

	// Global variables
	private int multiplier = 1;

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
		//Lead motors init
		this.leadRightMotor = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_LEADER);
		this.leadLeftMotor = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_LEADER);
		
		//Followers init
		this.leftFollower1 = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_1);
		this.leftFollower2 = new WPI_TalonSRX(RobotMap.CHASSIS_LEFT_FOLLOWER_2);
		
		this.rightFollower1 = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_1);
		this.rightFollower2 = new WPI_TalonSRX(RobotMap.CHASSIS_RIGHT_FOLLOWER_2);
		
		this.leadRightMotor.setInverted(false);
		this.rightFollower1.setInverted(true);
		this.rightFollower2.setInverted(false);
		this.leadLeftMotor.setInverted(false);
		this.leftFollower1.setInverted(false);
		this.leftFollower2.setInverted(false);

		// Case 3 motor drivetrain
		this.leftChassisSide = new ChassisSide(leadLeftMotor, leftFollower1,
				leftFollower2);

		this.rightChassisSide = new ChassisSide(leadRightMotor, rightFollower1,
				rightFollower2);
		
		this.leadLeftMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		this.leadRightMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);

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
	@Deprecated
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
		//TODO: add right side
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
	public void setMultiplyer(int multiplyer) {
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
