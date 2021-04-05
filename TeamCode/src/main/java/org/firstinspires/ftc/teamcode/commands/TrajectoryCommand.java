package org.firstinspires.ftc.teamcode.commands;

import android.util.Pair;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.TrajectoryBuilder;

import org.firstinspires.ftc.teamcode.subsystems.DrivebaseSubsystem;

public class TrajectoryCommand extends PathCommand {
    public Pair<Double, Pose2d>[] pose2d;
    public TrajectoryBuilder trajectory;
    public double startAngle;

    public TrajectoryCommand(DrivebaseSubsystem sub, double starta, Pair<Double, Pose2d>... pose) {
        super(sub);
        pose2d = pose;
        startAngle = starta;
//        for(int i = 0; i < pose2d.length; i++){
//            Pair<Double, Pose2d> p = pose2d[i];
//            pose2d[i] = new Pair<>(p.first, new Pose2d(p.second.getX(), p.second.getY(), Math.toRadians(p.second.getHeading())));
//        }
    }
    public TrajectoryCommand(DrivebaseSubsystem sub, Pair<Double, Pose2d>... pose){
        this(sub, sub.getPoseEstimate().getHeading(), pose);

    }

    @Override
    public void init() {
        trajectory = subsystem.trajectoryBuilder(subsystem.getPoseEstimate(), Math.toRadians(startAngle));
        for(Pair<Double, Pose2d> p : pose2d){
            trajectory = trajectory.splineToSplineHeading(p.second, Math.toRadians(p.first));
        }
        subsystem.followTrajectoryAsync(trajectory.build());
    }

}
