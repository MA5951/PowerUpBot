package org.usfirst.frc.team5951.robot.commands.brakes;

import org.usfirst.frc.team5951.robot.subsystems.Brakes;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class UnlockBrakes extends InstantCommand {

    public UnlockBrakes() {
    	requires(Brakes.getInstance());
    }

    // Called once when the command executes
    protected void initialize() {
    	Brakes.getInstance().unlock();
    }

}
