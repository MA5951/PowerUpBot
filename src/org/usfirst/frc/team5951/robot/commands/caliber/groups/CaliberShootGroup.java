package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.PushCube;
import org.usfirst.frc.team5951.robot.commands.caliber.ReleaseCube;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * This Command Group is taking out the cube with the pushing cylinder after the Catching 
 * cylinders release the cube.
 * This Command Group is closing the pushing cylinder and opening the
 * catching cylinders sequentially with one second delay. 
 * 
 * using-
 * ReleaseCube command
 * OpenPushCube command
 */
public class CaliberShootGroup extends CommandGroup {

    public CaliberShootGroup() {
        addSequential(new ReleaseCube());
        addSequential(new TimedCommand(0.1));
        addSequential(new PushCube());

    }
}
