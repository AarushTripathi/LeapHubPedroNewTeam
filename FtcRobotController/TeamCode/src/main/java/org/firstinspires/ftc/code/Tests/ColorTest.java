//package org.firstinspires.ftc.code.Tests;
//
//import com.qualcomm.hardware.rev.RevColorSensorV3;
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.hardware.ColorRangeSensor;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//
//@TeleOp(name = "Color Tester")
//public class ColorTest extends LinearOpMode {
//
//    CRServo fl;
//    CRServo fr;
//    ColorRangeSensor color;
//
//    private static final double limit = 0.5;
//    double Alliance; // 1 = blue, 2 = red
//
//    @Override
//    public void runOpMode() {
//        fr = hardwareMap.get(CRServo.class, "fr");
//        fl = hardwareMap.get(CRServo.class, "fl");
//
//        color = hardwareMap.get(RevColorSensorV3.class, "color");
//
//        color.enableLed(true);
//        Alliance = 1; // 1 = Blue, 2 = Red
//
//        waitForStart();
//        if (isStopRequested()) return;
//
//        while (opModeIsActive()) {
//            double dist = color.getDistance(DistanceUnit.INCH); // Distance in inches
//            double irValue = color.getLightDetected(); // IR Reflection Intensity (0-1)
//            String detectedColor = detectColor(color, irValue);
//
//            controlSample(gamepad2);
//
//            if (Alliance == 1) {
//                long startTime = System.currentTimeMillis();
//                while ((detectedColor.equals("Red") || detectedColor.equals("Yellow"))
//                        && dist <= limit
//                        && irValue > 0.2  // Ensuring IR reflection is significant
//                        && (System.currentTimeMillis() - startTime < 2000)) {
//                    outtakeSample();
//                    dist = color.getDistance(DistanceUnit.INCH);
//                    irValue = color.getLightDetected();
//                    detectedColor = detectColor(color, irValue);
//                }
//            }
//
//            if (Alliance == 2) {
//                long startTime = System.currentTimeMillis();
//                while ((detectedColor.equals("Blue") || detectedColor.equals("Yellow"))
//                        && dist <= limit
//                        && irValue > 0.2
//                        && (System.currentTimeMillis() - startTime < 2000)) {
//                    outtakeSample();
//                    dist = color.getDistance(DistanceUnit.INCH);
//                    irValue = color.getLightDetected();
//                    detectedColor = detectColor(color, irValue);
//                }
//            }
//
//
//        }
//    }
//
//    public void intakeSample() {
//        fl.setPower(-1.0);
//        fr.setPower(1.0);
//    }
//
//    public void outtakeSample() {
//        fl.setPower(1.0);
//        fr.setPower(-1.0);
//    }
//
//    public void idleSample() {
//        fl.setPower(0);
//        fr.setPower(0);
//    }
//
//    public void controlSample(Gamepad gamepad) {
//        if (gamepad2.right_stick_button) {
//            intakeSample();
//        } else if (gamepad2.left_stick_button) {
//            outtakeSample();
//        } else {
//            idleSample();
//        }
//    }
//
//    public String detectColor(ColorRangeSensor color, double irValue) {
//        NormalizedRGBA colors = color.getNormalizedColors();
//
//        double red = colors.red ;
//        double green = colors.green;
//        double blue = colors.blue;
//
//        String detectedColor = "None";
//
//        if (irValue > 0.3) { // Strong IR reflection → likely a sample
//            if (red >= 0.03 & green >= 0.002 && blue <= 0.02) {
//                detectedColor = "Red";
//            } else if (red >= 0.05 && green >= 0.07 && blue <= 0.02) {
//                detectedColor = "Yellow";
//            } else if (blue > 0.0003 && green < 0.0001 && red < 0.0001) {
//                detectedColor = "Blue";
//            }
//        }
//
//        telemetry.addData("Detected Color", detectedColor);
//        telemetry.addData("IR Reflection", irValue);
//        telemetry.addData("Red", red);
//        telemetry.addData("Green", green);
//        telemetry.addData("Blue", blue);
//
//        telemetry.update();
//        return detectedColor;
//    }
//}
