package org.usfirst.frc.team5951.robot.commands.caliber;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

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
public class CaliberTakeOut extends CommandGroup {

    public CaliberTakeOut() {
        addSequential(new ReleaseCube());
        Timer.delay(1);
        addSequential(new OpenPushCube());

    }
}
