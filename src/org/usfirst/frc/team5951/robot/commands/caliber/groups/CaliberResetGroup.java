package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.ReleaseCube;
import org.usfirst.frc.team5951.robot.commands.caliber.RetractCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * This Command Group is resets the pneomatics of the caliber.
 * This Command Group is closing the pushing cylinder and closing the
 * catching cylinders parallel with one second delay. 
 * 
 * using-
 * ClosePushCube command
 * ReleaseCube command
 */

//TODO: change name 
//TODO: wait less time 
public class CaliberResetGroup extends CommandGroup {

    public CaliberResetGroup() {
         addParallel(new ReleaseCube());
         addSequential(new TimedCommand(0.1));
         addParallel(new RetractCube());
    }
}
