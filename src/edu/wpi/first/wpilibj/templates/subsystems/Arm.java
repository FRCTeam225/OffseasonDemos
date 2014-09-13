/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Andrew
 */
public class Arm extends Subsystem {

    Solenoid arm = new Solenoid(5);
    Relay arm2 = new Relay(2);
    
    Talon roller = new Talon(9);
    DigitalInput ballSensor = new DigitalInput(7);
    
    public boolean hasBall()
    {
        return ballSensor.get();
    }
    
    public void set(boolean out)
    {
        if ( out )
        {
            arm.set(true);
            arm2.set(Relay.Value.kForward);
        }
        else
        {
            arm.set(false);
            arm2.set(Relay.Value.kOff);
        }
    }
    
    public void setRoller(double speed)
    {
        roller.set(speed);
    }
    
    
    protected void initDefaultCommand() {
        
    }
    
}
