package org.firstinspires.ftc.teamcode.commands.autonomous;

import com.technototes.library.command.SequentialCommandGroup;
import com.technototes.library.command.WaitCommand;
import com.technototes.path.command.TrajectorySequenceCommand;

import org.firstinspires.ftc.teamcode.commands.dump.DumpCollectCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeInCommand;
import org.firstinspires.ftc.teamcode.commands.intake.IntakeStopCommand;
import org.firstinspires.ftc.teamcode.subsystems.DumpSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;

public class AutonomousLoopCommandGroup extends SequentialCommandGroup {
    public AutonomousLoopCommandGroup(DrivebaseSubsystem drive, DumpSubsystem bucket, IntakeSubsystem intake){
        super(new DumpCollectCommand(bucket),
            new AutonomousBucketDumpCommand(bucket).withTimeout(3), // Bucket command
                new WaitCommand(0.5),
                new DumpCollectCommand(bucket),
                new TrajectorySequenceCommand(drive, AutonomousConstants.RED_ALLIANCE_HUB_LEVEL3_TO_DEPOT_COLLECT1),
                new IntakeInCommand(intake),
                new WaitCommand(0.5),
                new IntakeStopCommand(intake),
                new TrajectorySequenceCommand(drive, AutonomousConstants.RED_DEPOT_COLLECT1_TO_ALLIANCE_HUB_LEVEL3));
    }
}
