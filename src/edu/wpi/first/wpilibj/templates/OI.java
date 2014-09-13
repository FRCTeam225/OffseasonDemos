
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.DigitalIOButton;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.CollectBall;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public OI()
    {
        Joystick driver = new Joystick(1);
        new JoystickButton(driver, 1).whenPressed(new CollectBall());
        new JoystickButton(driver, 2).whenPressed(new SpitBall());
    }
}

