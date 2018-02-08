package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.commands.caliber.groups.LowerToGroundGroup;
import org.usfirst.frc.team5951.robot.commands.misc.RumbleJoystick;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;
import org.usfirst.frc.team5951.robot.util.Constants;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class LowerCaliber extends InstantCommand {
	Caliber caliber;
    public LowerCaliber() {
        caliber = Robot.CALIBER;
        requires(caliber);
    }

    // Called once when the command executes
    protected void initialize() {
    	if (Caliber.currentPosition == 2) {
    		caliber.switchPosition();
    		new RumbleJoystick(Constants.RUMBLE_TIMEOUT, Constants.SWITCH_POSITION_RUMBLE).start();
    	} else {
    		new LowerToGroundGroup().start();
    		new RumbleJoystick(Constants.RUMBLE_TIMEOUT, Constants.GROUND_POSITION_RUMBLE).start();
    	}
    }

}
