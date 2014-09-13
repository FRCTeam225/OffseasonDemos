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
public class TurnTo extends CommandBase {
    
    double target = 0;
    int stableLoops = 0;
    public TurnTo(double angle) {
        target = angle;
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // turn 180 degrees
        double current = drivetrain.getAngle();

        double error = current-target;
        System.out.println(error);

        if ( Math.abs(error) < 10 )
        {
            stableLoops++;
        }
        else
        {
            stableLoops = 0;
        }

        error *= -0.01;
        drivetrain.setMotors(error, -error);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stableLoops > 20;
    }

    // Called once after isFinished returns true
    protected void end() {
        drivetrain.setMotors(0, 0);
        drivetrain.reset();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
