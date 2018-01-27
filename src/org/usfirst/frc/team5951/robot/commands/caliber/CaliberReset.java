package org.usfirst.frc.team5951.robot.commands.caliber;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command Group is resets the pneomatics of the caliber.
 * This Command Group is closing the pushing cylinder and closing the
 * catching cylinders parallel with one second delay. 
 * 
 * using-
 * ClosePushCube command
 * ReleaseCube command
 */
public class CaliberReset extends CommandGroup {

    public CaliberReset() {
         addParallel(new ClosePushCube());
         Timer.delay(1);
         addParallel(new ReleaseCube());
    }
}
