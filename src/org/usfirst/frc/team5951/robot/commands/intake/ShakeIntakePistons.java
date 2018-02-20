package org.usfirst.frc.team5951.robot.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ShakeIntakePistons extends CommandGroup {

    public ShakeIntakePistons() {
        addSequential(new OpenIntakeGroup());
        addSequential(new WaitCommand(0.4));
        addSequential(new CloseIntakeGroup());
    }
}