/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Andrew
 */
public class SpitBall extends CommandBase {
    
    public SpitBall() {
        requires(arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        arm.setRoller(-1);
        arm.set(false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !arm.hasBall();
    }

    // Called once after isFinished returns true
    protected void end() {
        arm.setRoller(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
