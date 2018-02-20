package org.usfirst.frc.team5951.robot.commands.caliber.groups;

import org.usfirst.frc.team5951.robot.commands.caliber.LowerCaliber;
import org.usfirst.frc.team5951.robot.commands.intake.OpenIntakeGroup;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LowerCaliberGroup extends CommandGroup {

    public LowerCaliberGroup() {
        addSequential(new OpenIntakeGroup());
        addSequential(new WaitCommand(0.3));
        addSequential(new LowerCaliber());
    }
}
