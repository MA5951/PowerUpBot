package org.usfirst.frc.team5951.robot.triggers;

import org.usfirst.frc.team5951.robot.OI;
import org.usfirst.frc.team5951.robot.Robot;

import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 */
public class CaliberDown extends Trigger {

    public boolean get() {
        return Robot.CALIBER.currentPosition == 1 && OI.OPERATOR_STICK.getPOV() > 90 &&
          	   OI.OPERATOR_STICK.getPOV() < 270;
    }
}
