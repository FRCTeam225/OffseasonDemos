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
    
    Joystick leftJS = new Joystick(1);
    Joystick rightJS = new Joystick(2);
    
    Talon left1 = new Talon(1);
    Talon left2 = new Talon(2);
    Talon left3 = new Talon(3);
    
    Talon right1 = new Talon(4);
    Talon right2 = new Talon(5);
    Talon right3 = new Talon(6);
    
    Talon roller = new Talon(9);
    
    DigitalInput ballSensor = new DigitalInput(7);
    
    Gyro gyro = new Gyro(1);
    Encoder leftEncoder = new Encoder(2,3);
    
    Timer timer = new Timer();

    Solenoid arm = new Solenoid(5);
    Solenoid catcher = new Solenoid(6);
        
    int state = 0;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        leftEncoder.start();
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

    /**
     * This function is called periodically during autonomous
     */
    
    public void autonomousInit()
    {
        state = 1;
        leftEncoder.reset();
        timer.reset();
        timer.start();
    }

    
    public void autonomousPeriodic() 
    { 
        if (state == 1)
        {
           arm.set(true);
           roller.set(1);
           if (ballSensor.get())
           {
               state++;
               roller.set(0);
           }
            // pickup ball, wait til you see the ball
        }
        else if ( state == 2 )
        {
           arm.set(false);
           state++;
            // close intake
        }
        else if (state == 3 )
        {
            // turn 180 degrees
            double current = gyro.getAngle();
            double target = 180;

            double error = current-target;
            System.out.println(error);
        
            if ( Math.abs(error) < 10 )
            {
                state++;
                leftEncoder.reset();
                System.out.println("AT TARGET!");
            }

            error *= -0.01;
            setMotors(error, -error);
        }
        else if (state == 4)
        {
            // drive forward
            double current = leftEncoder.getDistance();
            double target = 3000;

            double error = current-target;
            System.out.println(error);

            if ( Math.abs(error) < 100 )
            {
                System.out.println("AT TARGET!");
                state++;
            }

            error *= -0.0003;
            setMotors(error, error);
        }
        else if ( state == 5 )
        {
            roller.set(-1);
            if (ballSensor.get() == false)
            {
               roller.set(0);
               state++;
            }
            // spit ball
        }
        else 
        {
            setMotors(0,0);
        }
    }
    

    
    public void teleopInit()
    { 
    }
    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {

    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}