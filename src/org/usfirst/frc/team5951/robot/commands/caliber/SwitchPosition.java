package org.usfirst.frc.team5951.robot.commands.caliber;

import org.usfirst.frc.team5951.robot.Robot;
import org.usfirst.frc.team5951.robot.subsystems.Caliber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.filters.LinearDigitalFilter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SwitchPosition extends Command {
	Caliber caliber;
    public SwitchPosition() {
        caliber = Robot.CALIBER;
        requires(caliber);
    }

    // Called once when the command executes
    protected void initialize() {
    	caliber.switchPosition();
    	System.out.println("Called");
    }
    
    
    @Override
    protected void execute() {
    	// TODO Auto-generated method stub
    	SmartDashboard.putNumber("Value: ", caliber.getPosition());
    	SmartDashboard.putNumber("Motor current: ", caliber.getCurrent());
    }

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
