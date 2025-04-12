//package org.firstinspires.ftc.teamcode.robot;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//import com.qualcomm.robotcore.hardware.DistanceSensor;
//import com.qualcomm.robotcore.hardware.Gamepad;
//import com.qualcomm.robotcore.util.Range;
//import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
//import com.qualcomm.robotcore.hardware.NormalizedRGBA;
//
//import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
//
//@TeleOp(name = "NMColor (don't touch this either)")
//
//public class NMColorTest extends LinearOpMode {
//    CRServo fl; // front left gecko
//    CRServo fr; // front right gecko
//
//    DistanceSensor distance;
//    NormalizedColorSensor color;
//
//    double red;
//    double blue;
//    double green;
//
//    private static final double limit = 0.5;
//
//    double Alliance = 1; // 1 = blue, 2 = red
//
//    @Override
//    public void runOpMode() {
//
//        fr = hardwareMap.get(CRServo.class, "fr");
//        fl = hardwareMap.get(CRServo.class, "fl");
//
//        distance = hardwareMap.get(DistanceSensor.class, "color");
//        color = hardwareMap.get(NormalizedColorSensor.class, "color");
//
//        waitForStart();
//
//
//        if (isStopRequested()) return;
//
//        while (opModeIsActive()) {
//            NormalizedRGBA colors = color.getNormalizedColors();
//            double dist = distance.getDistance(DistanceUnit.INCH);
//            red = colors.red;
//            blue = colors.blue;
//            green = colors.green;
//
//                    controlSample(gamepad2);
//
//                    if(Alliance==1) {
//                        long startTime = System.currentTimeMillis(); // Record time before starting
//                        while ((detectColor(red, blue, green).equals("Red") || detectColor(red, blue, green).equals("Yellow"))
//                                && dist <= limit
//                                && (System.currentTimeMillis() - startTime < 2000)) { // Timeout after 2 sec
//                            outtakeSample();
//                            dist = distance.getDistance(DistanceUnit.INCH); // Continuously update distance
//                            red = colors.red();
//                            blue = colors.blue();
//                            green = colors.green();
//                        }
//                        idleSample(); // Stop wheels once outtaking is complete
//
//                    }
//
//                    if(Alliance==2) {
//                        while ((detectColor(red,blue,green).equals("Blue") || detectColor(red,blue,green).equals("Yellow")) && dist <= limit) {
//                            outtakeSample();
//                        }
//                    }
//
//            if(Alliance == 1)
//                telemetry.addLine("Blue Side TeleOp Mode");
//
//            if(Alliance == 2)
//                telemetry.addLine("Red Side TeleOp Mode");
//
//            telemetry.update();
//        }
//    }
//
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
//    public String detectColor(double red, double blue, double green) {
//
//        if (red > 0.5 && green > 0.4 && blue < 0.3) {
//            return "Yellow";
//        }
//
//        if (red > 0.5 && green < 0.3 && blue < 0.3) {
//            return "Red";
//        }
//
//        if (blue > 0.5 && green < 0.3 && red < 0.3) {
//            return "Blue";
//        }
//        return "None";
//    }
//
//}
