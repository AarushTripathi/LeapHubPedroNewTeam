/* package org.firstinspires.ftc.teamcode.robot;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.BezierLine;
import com.pedropathing.pathgen.Path;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Timer;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


import org.firstinspires.ftc.teamcode.pedroPathing.constants.FConstants;
import org.firstinspires.ftc.teamcode.pedroPathing.constants.LConstants;

@Autonomous(name = "FourSpec")
public class fourSpec extends OpMode {

    private Follower follower;
    private Timer pathTimer, actionTimer, opmodeTimer;
    public static double kP_o = 0.01;
    private DcMotor back;
    private CRServo bl;
    private CRServo br;


    private int pathState;

    private final Pose startPose = new Pose(8, 63, Math.toRadians(180));

    private final Pose holdPre = new Pose(34.8, 63, Math.toRadians(180));
    private final Pose scorePre = new Pose(38, 63, Math.toRadians(180));

    private final Pose lineup1 = new Pose(60, 23, Math.toRadians(0));
    private final Pose push1 = new Pose(15, 23, Math.toRadians(0));

    private final Pose lineup2 = new Pose(60, 12.4, Math.toRadians(0));
    private final Pose push2 = new Pose(15, 12.4, Math.toRadians(0));

    private final Pose lineup3 = new Pose(60, 8.9, Math.toRadians(0));
    private final Pose push3 = new Pose(15, 8.9, Math.toRadians(0));

    private final Pose lineSpec = new Pose(11.5,26,Math.toRadians(0));
    private final Pose getSpec = new Pose(8, 26, Math.toRadians(0));

    private final Pose half = new Pose(24.5,48,0);
    private final Pose rotate = new Pose(24.5,59,180);


    private final Pose spec1 = new Pose(38, 61, Math.toRadians(180));
    private final Pose spec2 = new Pose(38, 65, Math.toRadians(180));
    private final Pose spec3 = new Pose(38, 67, Math.toRadians(180));
    private final Pose park = new Pose(10.2, 13, Math.toRadians(90));

    private Path preloadH, end;
    private PathChain preloadS, samp1L, samp1, samp2L, samp2, samp3L, samp3,line, get, half1, rotate1, hang1, rotateBack1, halfBack1, line2, get2, half2, rotate2,  hang2, rotateBack2, halfBack2, line3, get3, half3, rotate3, hang3;

    public void buildPaths() {


        preloadH = new Path(
                new BezierLine(
                        new Point(startPose),
                        new Point(holdPre)));
        preloadH.setLinearHeadingInterpolation(startPose.getHeading(), holdPre.getHeading());


        preloadS = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(holdPre),
                                new Point(scorePre)))
                .setLinearHeadingInterpolation(holdPre.getHeading(), scorePre.getHeading())
                .build();

        samp1L = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(scorePre),
                                new Point(0.000, 29.000, Point.CARTESIAN),
                                new Point(79.600, 37.800, Point.CARTESIAN),
                                new Point(lineup1)))
                .setLinearHeadingInterpolation(scorePre.getHeading(), lineup1.getHeading())
                .build();

        samp1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineup1),
                                new Point(push1)))
                .setLinearHeadingInterpolation(lineup1.getHeading(), push1.getHeading())
                .build();

        samp2L = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(push1),
                                new Point(51.200, 36.700, Point.CARTESIAN),
                                new Point(lineup2)))
                .setLinearHeadingInterpolation(push1.getHeading(), lineup2.getHeading())
                .build();

        samp2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineup2),
                                new Point(push2)))
                .setLinearHeadingInterpolation(lineup2.getHeading(), push2.getHeading())
                .build();

        samp3L = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(push2),
                                new Point(40.900, 31.900, Point.CARTESIAN),
                                new Point(lineup3)))
                .setLinearHeadingInterpolation(push2.getHeading(), lineup3.getHeading())
                .build();

        samp3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineup3),
                                new Point(push3)))
                .setLinearHeadingInterpolation(lineup3.getHeading(), push3.getHeading())
                .build();


        line = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(push3),
                                new Point(lineSpec)))
                .setLinearHeadingInterpolation(push3.getHeading(), lineSpec.getHeading())
                .build();

        get = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineSpec),
                                new Point(getSpec)))
                .setLinearHeadingInterpolation(lineSpec.getHeading(), getSpec.getHeading())
                .build();

        half1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(getSpec),
                                new Point(half)))
                .setLinearHeadingInterpolation(getSpec.getHeading(), half.getHeading())
                .build();

        rotate1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(half),
                                new Point(rotate)))
                .setLinearHeadingInterpolation(half.getHeading(), rotate.getHeading())
                .build();


        hang1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(rotate),
                                new Point(spec1)))
                .setLinearHeadingInterpolation(rotate.getHeading(), spec1.getHeading())
                .build();

        rotateBack1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(spec1),
                                new Point(rotate)))
                .setLinearHeadingInterpolation(spec1.getHeading(), rotate.getHeading())
                .build();

        halfBack1 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(rotate),
                                new Point(half)))
                .setLinearHeadingInterpolation(rotate.getHeading(), half.getHeading())
                .build();


        line2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(half),
                                new Point(lineSpec)))
                .setLinearHeadingInterpolation(half.getHeading(), lineSpec.getHeading())
                .build();

        get2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineSpec),
                                new Point(getSpec)))
                .setLinearHeadingInterpolation(lineSpec.getHeading(), getSpec.getHeading())
                .build();

        half2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(getSpec),
                                new Point(half)))
                .setLinearHeadingInterpolation(getSpec.getHeading(), half.getHeading())
                .build();

        rotate2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(half),
                                new Point(rotate)))
                .setLinearHeadingInterpolation(half.getHeading(), rotate.getHeading())
                .build();

        hang2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(rotate),
                                new Point(spec2)))
                .setLinearHeadingInterpolation(rotate.getHeading(), spec2.getHeading())
                .build();

        rotateBack2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(spec2),
                                new Point(rotate)))
                .setLinearHeadingInterpolation(spec2.getHeading(), rotate.getHeading())
                .build();

        halfBack2 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(rotate),
                                new Point(half)))
                .setLinearHeadingInterpolation(rotate.getHeading(), half.getHeading())
                .build();


        line3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(half),
                                new Point(lineSpec)))
                .setLinearHeadingInterpolation(half.getHeading(), lineSpec.getHeading())
                .build();

        get3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(lineSpec),
                                new Point(getSpec)))
                .setLinearHeadingInterpolation(lineSpec.getHeading(), getSpec.getHeading())
                .build();

        half3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(getSpec),
                                new Point(half)))
                .setLinearHeadingInterpolation(getSpec.getHeading(), half.getHeading())
                .build();

        rotate3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(half),
                                new Point(rotate)))
                .setLinearHeadingInterpolation(half.getHeading(), rotate.getHeading())
                .build();

        hang3 = follower.pathBuilder()
                .addPath(
                        new BezierLine(
                                new Point(rotate),
                                new Point(spec3)))
                .setLinearHeadingInterpolation(rotate.getHeading(), spec3.getHeading())
                .build();


        end = new Path(
                new BezierLine(
                        new Point(spec3),
                        new Point(park)));
        end.setLinearHeadingInterpolation(spec3.getHeading(), park.getHeading());
    }

    public double outtakePid(double target, double current) {
        return (target - current) * kP_o;
    }

    public void outtake(int targetPosition) {
        back.setTargetPosition(targetPosition);
        back.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        back.setPower(outtakePid(targetPosition, back.getCurrentPosition()));
    }
    public void autonomousPathUpdate() {
        switch (pathState) {

            case 0:
                outtake(2600);
                follower.setMaxPower(1.0);
                follower.followPath(preloadH);
                setPathState(1);
                break;

            case 1:
                if(follower.atParametricEnd() && back.getCurrentPosition() >= 2575) {
                    follower.setMaxPower(1.0);
                    follower.followPath(preloadS,true);
                    outtake(0);
                    setPathState(2);
                }
                break;

            case 2:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    outtake(0);
                    follower.followPath(samp1L,true);
                    setPathState(3);
                }
                break;

            case 3:

                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(samp1,true);
                    setPathState(4);
                }
                break;

            case 4:

                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(samp2L,true);
                    setPathState(5);
                }
                break;

            case 5:

                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(samp2,true);
                    setPathState(6);
                }
                break;

            case 6:

                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(samp3L,true);
                    setPathState(7);
                }
                break;

            case 7:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(samp3, true);
                    setPathState(8);
                }
                break;

            case 8:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(line,true);
                    setPathState(9);
                }
            case 9:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(get,true);
                    setPathState(10);
                }
                break;

            case 10:
                if(follower.atParametricEnd() ) {
                    follower.setMaxPower(1.0);
                    follower.followPath(half1,true);
                    setPathState(11);
                }
                break;

            case 11:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(rotate1,true);
                    setPathState(12);
                }

            case 12:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(hang1,true);
                    setPathState(13);
                }
                break;

            case 13:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(rotateBack1,true);
                    setPathState(14);
                }
                break;
            case 14:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(halfBack1,true);
                    setPathState(15);
                }

            case 15:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(line2,true);
                    setPathState(16);
                }

                break;

            case 16:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(get2,true);
                    setPathState(17);
                }
                break;

            case 17:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    outtake(0);
                    follower.followPath(half2,true);
                    setPathState(18);
                }

            case 18:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(rotate2,true);
                    setPathState(19);
                }
                break;

            case 19:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(hang2,true);
                    setPathState(20);
                }
                break;

            case 20:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(rotateBack2,true);
                    setPathState(21);
                }
                break;
            case 21:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(halfBack2,true);
                    setPathState(22);
                }

            case 22:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(line3,true);
                    setPathState(23);
                }

                break;

            case 23:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(get3,true);
                    setPathState(24);
                }
                break;

            case 24:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    outtake(0);
                    follower.followPath(half3,true);
                    setPathState(25);
                }

            case 25:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(rotate3,true);
                    setPathState(26);
                }
                break;

            case 26:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    follower.followPath(hang3,true);
                    setPathState(27);
                }
                break;

            case 27:
                if(follower.atParametricEnd()) {
                    follower.setMaxPower(1.0);
                    outtake(0);
                    follower.followPath(end,true);
                    setPathState(-1);
                }
                break;

        }
    }

    public void setPathState(int pState) {
        pathState = pState;
        pathTimer.resetTimer();
    }

    @Override
    public void loop() {

        follower.update();
        autonomousPathUpdate();

        telemetry.addData("path state", pathState);
        telemetry.addData("x", follower.getPose().getX());
        telemetry.addData("y", follower.getPose().getY());
        telemetry.addData("heading", follower.getPose().getHeading());
        telemetry.addData("t-value", follower.getCurrentTValue());
        telemetry.addData("Trans error mag", follower.getTranslationalError().getMagnitude());
        telemetry.addData("Heading Error mag", follower.headingError);
        telemetry.addData("Velocity mag", follower.getVelocityMagnitude());
        telemetry.update();
    }

    @Override
    public void init() {
        pathTimer = new Timer();
        opmodeTimer = new Timer();
        opmodeTimer.resetTimer();
        bl = hardwareMap.get(CRServo.class,"bl");
        br = hardwareMap.get(CRServo.class,"br");
        back = hardwareMap.get(DcMotor.class, "back");
        back.setDirection(DcMotorSimple.Direction.REVERSE);
        back.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        Constants.setConstants(FConstants.class, LConstants.class);
        follower = new Follower(hardwareMap);
        follower.setStartingPose(startPose);
        buildPaths();

    }


    @Override
    public void init_loop() {

    }

    @Override
    public void start() {
        opmodeTimer.resetTimer();
        setPathState(0);
    }

    @Override
    public void stop() {
    }
}
*/
