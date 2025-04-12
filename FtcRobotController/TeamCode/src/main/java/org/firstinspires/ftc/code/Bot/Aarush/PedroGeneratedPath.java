////Just for notes. Do not use this.
//
//package org.firstinspires.ftc.code.Bot.Aarush;
//
//import com.pedropathing.pathgen.PathBuilder;
//import com.pedropathing.follower.Follower;
//import com.pedropathing.localization.Pose;
//import com.pedropathing.pathgen.BezierCurve;
//import com.pedropathing.pathgen.BezierLine;
//import com.pedropathing.pathgen.PathChain;
//import com.pedropathing.pathgen.Point;
//import com.pedropathing.util.Timer;
//import com.pedropathing.util.Constants;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//
//
//import org.firstinspires.ftc.code.Pedro.constants.FConstants;
//import org.firstinspires.ftc.code.Pedro.constants.LConstants;
//
//public class PedroGeneratedPath
//{
//
//    public static PathBuilder builder = new PathBuilder();
//
//    public static PathChain line1 = builder
//            .addPath(
//                    new BezierLine(
//                            new Point(8.000, 65.000, Point.CARTESIAN),
//                            new Point(38.000, 65.000, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(180))
//            .build();
//
//    public static PathChain line2 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(38.000, 65.000, Point.CARTESIAN),
//                            new Point(5.308, 35.077, Point.CARTESIAN),
//                            new Point(55.385, 34.846, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(0))
//            .build();
//
//    public static PathChain line3 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(55.385, 34.846, Point.CARTESIAN),
//                            new Point(80.769, 31.385, Point.CARTESIAN),
//                            new Point(58.154, 24.692, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line4 = builder
//            .addPath(
//                    new BezierLine(
//                            new Point(58.154, 24.692, Point.CARTESIAN),
//                            new Point(12.692, 24.462, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line5 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(12.692, 24.462, Point.CARTESIAN),
//                            new Point(6.692, 13.615, Point.CARTESIAN),
//                            new Point(56.538, 39.923, Point.CARTESIAN),
//                            new Point(63.231, 13.615, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(-22))
//            .build();
//
//    public static PathChain line6 = builder
//            .addPath(
//                    new BezierLine(
//                            new Point(63.231, 13.615, Point.CARTESIAN),
//                            new Point(12.462, 12.923, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line7 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(12.462, 12.923, Point.CARTESIAN),
//                            new Point(39.231, 29.077, Point.CARTESIAN),
//                            new Point(63.692, 8.538, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line8 = builder
//            .addPath(
//                    new BezierLine(
//                            new Point(63.692, 8.538, Point.CARTESIAN),
//                            new Point(21.462, 8.308, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line9 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(21.462, 8.308, Point.CARTESIAN),
//                            new Point(29.000, 21.000, Point.CARTESIAN),
//                            new Point(9.923, 26.538, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(0))
//            .build();
//
//    public static PathChain line10 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(9.923, 26.538, Point.CARTESIAN),
//                            new Point(16.154, 54.231, Point.CARTESIAN),
//                            new Point(37.154, 60.692, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(180))
//            .build();
//
//    public static PathChain line11 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(37.154, 60.692, Point.CARTESIAN),
//                            new Point(26.538, 35.769, Point.CARTESIAN),
//                            new Point(10.846, 26.538, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(0))
//            .build();
//
//    public static PathChain line12 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(10.846, 26.538, Point.CARTESIAN),
//                            new Point(13.154, 49.615, Point.CARTESIAN),
//                            new Point(37.154, 69.462, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(180))
//            .build();
//
//    public static PathChain line13 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(37.154, 69.462, Point.CARTESIAN),
//                            new Point(43.154, 51.000, Point.CARTESIAN),
//                            new Point(11.077, 26.077, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(0))
//            .build();
//
//    public static PathChain line14 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(11.077, 26.077, Point.CARTESIAN),
//                            new Point(20.769, 71.308, Point.CARTESIAN),
//                            new Point(37.846, 74.077, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(180))
//            .build();
//
//    public static PathChain line15 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(37.846, 74.077, Point.CARTESIAN),
//                            new Point(37.615, 44.077, Point.CARTESIAN),
//                            new Point(11.538, 25.615, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(0))
//            .build();
//
//    public static PathChain line16 = builder
//            .addPath(
//                    new BezierCurve(
//                            new Point(11.538, 25.615, Point.CARTESIAN),
//                            new Point(11.538, 59.077, Point.CARTESIAN),
//                            new Point(38.077, 77.769, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(0), Math.toRadians(180))
//            .build();
//
//    public static PathChain line17 = builder
//            .addPath(
//                    new BezierLine(
//                            new Point(38.077, 77.769, Point.CARTESIAN),
//                            new Point(10.154, 12.923, Point.CARTESIAN)
//                    )
//            )
//            .setLinearHeadingInterpolation(Math.toRadians(180), Math.toRadians(90))
//            .build();
//}
