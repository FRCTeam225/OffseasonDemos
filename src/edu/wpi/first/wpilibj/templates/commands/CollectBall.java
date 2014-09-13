/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 * @author Andrew
 */
public class CollectBall extends CommandGroup {
    
    public CollectBall() {
        addSequential(new RunRollerUntilBall());
        addSequential(new WaitCommand(1));
        addSequential(new BringInArm());
    }
}