package org.usfirst.frc.team5951.robot.commands.intake;

import org.usfirst.frc.team5951.robot.subsystems.IntakeSubSystem;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * @author sahar balass
 * this command closes the intake system
 */
public class CloseIntake extends InstantCommand {


	public static IntakeSubSystem intake;
    public CloseIntake() {
        super();

    }

    /**
     * 
     */
    protected void initialize() {
    	
    	intake.closeIntake();
    	
    }

}
