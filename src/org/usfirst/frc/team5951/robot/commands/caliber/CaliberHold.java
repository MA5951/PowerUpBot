package org.usfirst.frc.team5951.robot.commands.caliber;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 * This Command Group is making sure that the pushing cylinder is closed when the driver
 * wants to catch a cube.
 * This Command Group is closing the pushing cylinder and opening the
 * catching cylinders sequentially with one second delay. 
 * 
 * using-
 * ClosePushCube command
 * CatchCube command
 */
public class CaliberHold extends CommandGroup {

    public CaliberHold() {
    	addSequential(new ReleaseCube());
    	addSequential(new TimedCommand(1));
        addSequential(new CatchCube());
  
    }
}
