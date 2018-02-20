package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.RaiseCaliber;
import org.usfirst.frc.team5951.robot.commands.intake.CloseIntakeGroup;
import org.usfirst.frc.team5951.robot.commands.intake.OpenLeftIntake;
import org.usfirst.frc.team5951.robot.commands.intake.OpenRightIntake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RaiseCaliberGroup extends CommandGroup {

    public RaiseCaliberGroup() {
    	addSequential(new OpenLeftIntake());
    	addSequential(new OpenRightIntake());
    	addSequential(new RaiseCaliber());
    	addSequential(new WaitCommand(0.3));
    	addSequential(new CloseIntakeGroup());
    }
}
