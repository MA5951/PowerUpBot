package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class CaliberOverSwitch extends InstantCommand {

	private Caliber caliber;
	
    public CaliberOverSwitch() {
    	this.caliber = Robot.CALIBER;
    	requires(this.caliber);
    }

    // Called once when the command executes
    protected void initialize() {
    	this.caliber.littleOverSwitchPosition();
    }

}
