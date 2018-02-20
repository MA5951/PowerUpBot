package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.commands.misc.RumbleJoystick;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;
import org.usfirst.frc.team5951.robot.util.Constants;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class RaiseCaliber extends InstantCommand {

	private Caliber caliber;
	
    public RaiseCaliber() {
    	caliber = Robot.CALIBER;
    	requires(this.caliber);        
    }

    // Called once when the command executes
    protected void initialize() {
    	if(Caliber.currentPosition == 0) {
    		caliber.groundToSwitchPosition();
    		new RumbleJoystick(Constants.RUMBLE_TIMEOUT, Constants.SWITCH_POSITION_RUMBLE).start();
    	} else {
    		caliber.backPosition();
    		new RumbleJoystick(Constants.RUMBLE_TIMEOUT, Constants.BACK_POSITION_RUMBLE).start();
    	}
    }

}
