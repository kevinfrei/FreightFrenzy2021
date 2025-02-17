package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.technototes.library.util.Color;
import com.technototes.library.logger.Log;
import com.technototes.library.logger.Loggable;

import org.firstinspires.ftc.teamcode.subsystems.CapSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.CarouselSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.DrivebaseSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.VisionSubsystem;

import static org.firstinspires.ftc.teamcode.Robot.SubsystemConstants.*;

public class Robot implements Loggable {
    @Config
    public static class SubsystemConstants {
        public static boolean LIFT_CONNECTED = true;
        public static boolean DEPOSIT_CONNECTED = true;
        public static boolean EXTENSION_CONNECTED = true;
        public static boolean DRIVE_CONNECTED = true;
        public static boolean CAROUSEL_CONNECTED = true;
        public static boolean INTAKE_CONNECTED = true;
        public static boolean VISION_CONNECTED = true;
        public static boolean CAP_CONNECTED = false;

    }

    @Log.NumberBar(name = "Lift", min = 0, max = 1100, scale = 100, completeBarColor = Color.PURPLE)
    public LiftSubsystem liftSubsystem;

    @Log(name = "Deposit", entryColor = Color.PINK)
    public ArmSubsystem armSubsystem;

    @Log(name = "Extension", entryColor = Color.BLUE)
    public ExtensionSubsystem extensionSubsystem;

    @Log(name = "Drivebase", entryColor = Color.BLUE)
    public DrivebaseSubsystem drivebaseSubsystem;

    @Log.NumberSlider(name = "Carousel", sliderBackground = Color.CYAN, slider = Color.LIME)
    public CarouselSubsystem carouselSubsystem;

    @Log.NumberSlider(name = "Intake", sliderBackground = Color.RED, slider = Color.ORANGE)
    public IntakeSubsystem intakeSubsystem;

    @Log.NumberSlider(name = "Cap", color = Color.MAGENTA)
    public CapSubsystem capSubsystem;

    public VisionSubsystem visionSubsystem;

    public Robot(Hardware hardware){
        if(LIFT_CONNECTED) liftSubsystem = new LiftSubsystem(hardware.liftMotor);

        if(DEPOSIT_CONNECTED) armSubsystem = new ArmSubsystem(hardware.dumpServo, hardware.armServo);

        if(EXTENSION_CONNECTED) extensionSubsystem = new ExtensionSubsystem(hardware.slideServo, hardware.turretServo);

        if(DRIVE_CONNECTED) drivebaseSubsystem = new DrivebaseSubsystem(hardware.flDriveMotor, hardware.frDriveMotor, hardware.rlDriveMotor, hardware.rrDriveMotor,
                hardware.imu, hardware.leftRangeSensor, hardware.rightRangeSensor, hardware.frontRangeSensor);

        if(CAROUSEL_CONNECTED) carouselSubsystem = new CarouselSubsystem(hardware.carouselMotor);

        if(INTAKE_CONNECTED) intakeSubsystem = new IntakeSubsystem(hardware.intakeMotor);

        if(VISION_CONNECTED) visionSubsystem = new VisionSubsystem(hardware.camera);

        if(CAP_CONNECTED) capSubsystem = new CapSubsystem(hardware.capServo);
    }
}
