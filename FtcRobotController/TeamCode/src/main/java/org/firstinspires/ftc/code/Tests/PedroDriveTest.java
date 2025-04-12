package org.firstinspires.ftc.code.Tests;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.code.Pedro.constants.FConstants;
import org.firstinspires.ftc.code.Pedro.constants.LConstants;

@TeleOp(name = "pedroDriveTest")

public class PedroDriveTest extends LinearOpMode {

    Follower follower;
    private PathChain specHang;

    private final Pose getSpec = new Pose(5.45, 34.5, Math.toRadians(0));
    private final Pose spec = new Pose(38.45, 63, Math.toRadians(180));
    private final Pose park = new Pose(38, 60, Math.toRadians(180));
    public void buildPaths() {
        specHang = follower.pathBuilder()
                .addPath(
                        new BezierCurve(
                                new Point(getSpec),
                                new Point(28.4,36.4,Point.CARTESIAN),
                                new Point(13,43,Point.CARTESIAN),
                                new Point(spec)))
                .setLinearHeadingInterpolation(getSpec.getHeading(), spec.getHeading())
                .build();
    }

    @Override
    public void runOpMode() {

        Constants.setConstants(FConstants.class, LConstants.class);

        follower = new Follower(hardwareMap);
        follower.startTeleopDrive();
        follower.setStartingPose(park);
        buildPaths();

        waitForStart();

        if (isStopRequested()) return;


        while (opModeIsActive()) {
            follower.setTeleOpMovementVectors(-gamepad1.left_stick_y, -gamepad1.left_stick_x, -gamepad1.right_stick_x,true);

            if(gamepad1.a){
                follower.setMaxPower(1.0);
                follower.followPath(specHang,true);
            }

            if(follower.isBusy() && gamepad1.y){
                follower.breakFollowing();
            }

            follower.update();

            telemetry.addData("X", follower.getPose().getX());
            telemetry.addData("Y", follower.getPose().getY());
            telemetry.addData("Heading in Degrees", Math.toDegrees(follower.getPose().getHeading()));

            telemetry.update();

        }

    }
}