/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.templates.commands.CollectBall;
import edu.wpi.first.wpilibj.templates.commands.DriveTo;
import edu.wpi.first.wpilibj.templates.commands.SpitBall;
import edu.wpi.first.wpilibj.templates.commands.TurnTo;

/**
 *
 * @author Andrew
 */
public class AutonomousCommand extends CommandGroup {
    
    public AutonomousCommand() {
        addSequential(new CollectBall());
        addSequential(new TurnTo(180));
        addSequential(new DriveTo(-3000, 180));
        addSequential(new SpitBall());
        addSequential(new WaitCommand(0.5));
        addSequential(new TurnTo(0));
        addSequential(new DriveTo(-4000, 0));
        addSequential(new CollectBall());
        addSequential(new WaitCommand(0.5));
        addSequential(new TurnTo(180));
        addSequential(new DriveTo(-4000, 180));
        addSequential(new SpitBall());
    }
}
