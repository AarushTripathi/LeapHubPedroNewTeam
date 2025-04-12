package org.firstinspires.ftc.code.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "driveTest")

public class DriveTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor frontLeftMotor = hardwareMap.get(DcMotor.class, "lf_drive");
        DcMotor backLeftMotor = hardwareMap.get(DcMotor.class, "lb_drive");
        DcMotor frontRightMotor = hardwareMap.get(DcMotor.class, "rf_drive");
        DcMotor backRightMotor = hardwareMap.get(DcMotor.class, "rb_drive");

        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

            double turn = gamepad2.right_stick_x;
            double strafe = gamepad2.left_stick_x;
            double drive = gamepad2.left_stick_y;

            double lfPower = -Range.clip(-strafe - turn + drive, -1.0, 1.0);
            double rfPower = -Range.clip(-strafe - turn - drive, -1.0, 1.0);
            double lbPower = Range.clip(-strafe + turn - drive, -1.0, 1.0);
            double rbPower = -Range.clip(-strafe + turn + drive, -1.0, 1.0);

            frontLeftMotor.setPower(lfPower);
            backLeftMotor.setPower(lbPower);
            frontRightMotor.setPower(rfPower);
            backRightMotor.setPower(rbPower);

        }
    }
}