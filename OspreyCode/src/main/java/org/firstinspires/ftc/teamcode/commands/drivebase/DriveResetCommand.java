package org.firstinspires.ftc.teamcode.commands.drivebase;

import com.technototes.library.command.Command;

import org.firstinspires.ftc.teamcode.subsystems.DrivebaseSubsystem;


public class DriveResetCommand implements Command {
    public DrivebaseSubsystem subsystem;
    public DriveResetCommand(DrivebaseSubsystem s){
        subsystem = s;
    }
    @Override
    public void execute() {
        subsystem.setExternalHeading(0);
        subsystem.resetGyro();
    }
}
