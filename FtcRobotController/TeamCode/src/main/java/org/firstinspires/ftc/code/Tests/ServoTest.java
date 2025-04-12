package org.firstinspires.ftc.code.Tests;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@Config
@TeleOp
public class ServoTest extends LinearOpMode {
    public static double testPos = 0.5; //EDIT THIS IN DASH


    @Override
    public void runOpMode() throws InterruptedException {
        Servo claw = hardwareMap.get(Servo.class, "claw");
        waitForStart();

        while(opModeIsActive()){
            claw.setPosition(testPos);
        }
    }
}