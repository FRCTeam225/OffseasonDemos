
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
    Talon left1 = new Talon(1);
    Talon left2 = new Talon(2);
    Talon left3 = new Talon(3);
    
    Talon right1 = new Talon(4);
    Talon right2 = new Talon(5);
    Talon right3 = new Talon(6);
    
    
    Gyro gyro = new Gyro(1);
    Encoder leftEncoder = new Encoder(2,3);
    
    public double getDistance()
    {
        return leftEncoder.getDistance();
    }
    
    public double getAngle()
    {
        return gyro.getAngle();
    }
    
    public void setMotors(double left, double right)
    {
        left1.set(-left);
        left2.set(-left);
        left3.set(-left);

        right1.set(right);
        right2.set(right);
        right3.set(right);
    }
    
    public void reset()
    {
        leftEncoder.reset();
    }

    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

