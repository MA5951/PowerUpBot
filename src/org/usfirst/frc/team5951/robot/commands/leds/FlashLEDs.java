package org.usfirst.frc.team5951.robot.commands.leds;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Flashed the LEDs as indicators
 */
public class FlashLEDs extends CommandGroup {

    public FlashLEDs() {
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.2));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.2));
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.2));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.2));
        addSequential(new LEDsOn());
        addSequential(new WaitCommand(0.2));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.2));
    }
}
