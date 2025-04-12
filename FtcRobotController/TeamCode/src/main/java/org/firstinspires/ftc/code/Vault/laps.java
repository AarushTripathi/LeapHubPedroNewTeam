//package org.firstinspires.ftc.teamcode.robot;
//
//import com.pedropathing.follower.Follower;
//import com.pedropathing.localization.Pose;
//import com.pedropathing.pathgen.BezierCurve;
//import com.pedropathing.pathgen.BezierLine;
//import com.pedropathing.pathgen.Path;
//import com.pedropathing.pathgen.PathChain;
//import com.pedropathing.pathgen.Point;
//import com.pedropathing.util.Timer;
//import com.pedropathing.util.Constants;
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;
//
//
//import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
//import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;
//
//@Autonomous(name = "laps")
//public class laps extends OpMode {
//
//    private Follower follower;
//    private Timer pathTimer, opmodeTimer;
//    public static double kP_o = 0.01;
//
//    private int pathState;
//
//    private final Pose startPose = new Pose(8, 48, Math.toRadians(0));
//    private final Pose truestart = new Pose(24, 48, Math.toRadians(270));
//
//    private final Pose c1 = new Pose(48, 24, Math.toRadians(270));
//    private final Pose l1 = new Pose(96, 24, Math.toRadians(0));
//
//    private final Pose c2 = new Pose(120, 48, Math.toRadians(0));
//    private final Pose l2 = new Pose(120, 96, Math.toRadians(90));
//
//    private final Pose c3 = new Pose(96, 120, Math.toRadians(90));
//    private final Pose l3 = new Pose(48, 120, Math.toRadians(180));
//
//    private final Pose c4 = new Pose(24, 96, Math.toRadians(180));
//    private final Pose l4 = new Pose(24, 48, Math.toRadians(270));
//
//
//    private Path start;
//    private PathChain line1, curve1, line2, curve2, line3, curve3, line4, curve4;
//
//    public void buildPaths() {
//
//
//        start = new Path(
//                new BezierLine(
//                        new Point(startPose),
//                        new Point(truestart)));
//        start.setLinearHeadingInterpolation(startPose.getHeading(), truestart.getHeading());
//
//        curve1 = follower.pathBuilder()
//                .addPath(
//                        new BezierCurve(
//                                new Point(truestart),
//                                new Point(24,24,Point.CARTESIAN),
//                                new Point(c1)))
//                .setLinearHeadingInterpolation(truestart.getHeading(), c1.getHeading())
//                .build();
//
//        line1 = follower.pathBuilder()
//                .addPath(
//                        new BezierLine(
//                                new Point(c1),
//                                new Point(l1)))
//                .setLinearHeadingInterpolation(c1.getHeading(), l1.getHeading())
//                .build();
//
//        curve2 = follower.pathBuilder()
//                .addPath(
//                        new BezierCurve(
//                                new Point(l1),
//                                new Point(120,24,Point.CARTESIAN),
//                                new Point(c2)))
//                .setLinearHeadingInterpolation(l1.getHeading(), c2.getHeading())
//                .build();
//
//        line2 = follower.pathBuilder()
//                .addPath(
//                        new BezierLine(
//                                new Point(c2),
//                                new Point(l2)))
//                .setLinearHeadingInterpolation(c2.getHeading(), l2.getHeading())
//                .build();
//
//        curve3 = follower.pathBuilder()
//                .addPath(
//                        new BezierCurve(
//                                new Point(l2),
//                                new Point(120,120,Point.CARTESIAN),
//                                new Point(c3)))
//                .setLinearHeadingInterpolation(l2.getHeading(), c3.getHeading())
//                .build();
//
//        line3 = follower.pathBuilder()
//                .addPath(
//                        new BezierLine(
//                                new Point(c3),
//                                new Point(l3)))
//                .setLinearHeadingInterpolation(l3.getHeading(), c3.getHeading())
//                .build();
//
//        curve4 = follower.pathBuilder()
//                .addPath(
//                        new BezierCurve(
//                                new Point(c3),
//                                new Point (24,120,Point.CARTESIAN),
//                                new Point(l4)))
//                .setLinearHeadingInterpolation(c3.getHeading(), l4.getHeading())
//                .build();
//
//        line4 = follower.pathBuilder()
//                .addPath(
//                        new BezierLine(
//                                new Point(c4),
//                                new Point(l4)))
//                .setLinearHeadingInterpolation(c4.getHeading(), l4.getHeading())
//                .build();
//    }
//
//    public void autonomousPathUpdate() {
//        switch (pathState) {
//
//            case 0:
//                follower.setMaxPower(1.0);
//                follower.followPath(start);
//                setPathState(1);
//                break;
//
//            case 1:
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(curve1, true);
//                    setPathState(2);
//                }
//                break;
//
//            case 2:
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(line1, true);
//                    setPathState(3);
//                }
//                break;
//
//            case 3:
//
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(curve2, true);
//                    setPathState(4);
//                }
//                break;
//
//            case 4:
//
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(line2, true);
//                    setPathState(5);
//                }
//                break;
//
//            case 5:
//
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(curve3, true);
//                    setPathState(8);
//                }
//                break;
//
//            case 8:
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(line3, true);
//                    setPathState(9);
//                }
//            case 9:
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(0.5);
//                    follower.followPath(curve4, true);
//                    setPathState(10);
//                }
//                break;
//
//            case 10:
//                if (follower.atParametricEnd()) {
//                    follower.setMaxPower(1.0);
//                    follower.followPath(line4, true);
//                    setPathState(1);
//                }
//                break;
//
//        }
//    }
//
//    public void setPathState(int pState) {
//        pathState = pState;
//        pathTimer.resetTimer();
//    }
//
//    @Override
//    public void loop() {
//
//        follower.update();
//        autonomousPathUpdate();
//
//        telemetry.addData("path state", pathState);
//        telemetry.addData("x", follower.getPose().getX());
//        telemetry.addData("y", follower.getPose().getY());
//        telemetry.addData("heading", follower.getPose().getHeading());
//        telemetry.update();
//    }
//
//    @Override
//    public void init() {
//        pathTimer = new Timer();
//        opmodeTimer = new Timer();
//        opmodeTimer.resetTimer();
//
//
//        Constants.setConstants(FConstants.class, LConstants.class);
//        follower = new Follower(hardwareMap);
//        follower.setStartingPose(startPose);
//        buildPaths();
//
//    }
//
//
//    @Override
//    public void init_loop() {
//
//    }
//
//    @Override
//    public void start() {
//        opmodeTimer.resetTimer();
//        setPathState(0);
//    }
//
//    @Override
//    public void stop() {
//    }
//}