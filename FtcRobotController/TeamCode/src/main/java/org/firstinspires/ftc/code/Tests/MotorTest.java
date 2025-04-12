package org.firstinspires.ftc.code.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "motorTest")

public class MotorTest extends LinearOpMode {

    @Override
    public void runOpMode() {

        //add more motors as needed
        DcMotor motor1 = hardwareMap.get(DcMotor.class, "m1");

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            //copy these as needed
            if (gamepad1.y)
                motor1.setPower(1.0);
            else if (gamepad1.a)
                motor1.setPower(-1.0);
            else
                motor1.setPower(0);

        }
    }
}