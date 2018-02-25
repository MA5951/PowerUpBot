package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ToggleBrakes extends InstantCommand {

    public ToggleBrakes() {
    	requires(Brakes.getInstance());
    }

    // Called once when the command executes
    protected void initialize() {
    	if(Brakes.getInstance().isLocked())
    		Brakes.getInstance().unlock();
    	else
    		Brakes.getInstance().lock();
    }

}
