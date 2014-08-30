/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class MyRobot extends IterativeRobot {
    
    Joystick js = new Joystick(1);
    DigitalInput ballSensor = new DigitalInput(7);
    Solenoid arm = new Solenoid(5);
    Solenoid catcher = new Solenoid(6);

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
   
    public void autonomousInit()
    {
        
    }

    
    public void autonomousPeriodic() 
    { 
        
    }
    

    
    public void teleopInit()
    {
        System.out.println("Teleop init called!");
        
        
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    
        if ( js.getRawButton(3) )
        {
            arm.set(true);
            catcher.set(true);
        }
        else 
        {
            arm.set(false);
            catcher.set(false);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
