package org.firstinspires.ftc.teamcode.commands.drivebase;

import com.acmerobotics.roadrunner.drive.DriveSignal;
import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.technototes.library.command.Command;
import com.technototes.library.control.Stick;

import org.firstinspires.ftc.teamcode.subsystems.DrivebaseSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand implements Command {
    public DrivebaseSubsystem subsystem;
    public DoubleSupplier x, y, r;
    public DriveCommand(DrivebaseSubsystem sub, Stick stick1, Stick stick2) {
        addRequirements(sub);
        subsystem = sub;
        x = stick1.getXSupplier();
        y = stick1.getYSupplier();
        r = stick2.getXSupplier();
    }

    @Override
    public void execute() {
        Vector2d input = new Vector2d(
                y.getAsDouble(),
                x.getAsDouble()
        ).rotated(-subsystem.getExternalHeading());
        subsystem.setSafeDrivePower(
                new Pose2d(
                        Math.pow(input.getX(), 1),
                        Math.pow(input.getY(), 1),
                        -Math.pow(r.getAsDouble()*subsystem.speed, 3)
                )
        );
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean cancel) {
        if(cancel) subsystem.setDriveSignal(new DriveSignal());
    }
}