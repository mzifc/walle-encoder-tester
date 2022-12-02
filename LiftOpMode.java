package org.firstinspires.ftc.teamcode.Tests;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class LiftOpMode extends LinearOpMode {
   @Override
   public void runOpMode() throws InterruptedException {
      // position of the dr4b when it is on the **ground
      int liftGroundPosition = 0;

      // position of dr4b when it is **low
      int liftLowPosition = 0;
     
      // position of dr4b when it is **mid
      int liftMidPosition = 0;
     
      // position of dr4b when it is **high
      int liftHighPosition = 0;

      // find a motor in the hardware map named these
      DcMotor rightLift = hardwareMap.dcMotor.get("rightLift");
      DcMotor leftLift = hardwareMap.dcMotor.get("leftLift");
      
      // [LIFT MOTOR].setDirection(DcMotor.Direction.REVERSE);

      // reset the motor encoder so that it reads zero ticks
      rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
      leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

      // sets the starting position of the arm to the down position
      rightLift.setTargetPosition(liftGroundPosition);
      rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      leftLift.setTargetPosition(liftGroundPosition);
      leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
      
      waitForStart();

      while (opModeIsActive()) {
            // if the x button is pressed, move to **ground
            if (gamepad1.x) {
               rightLift.setTargetPosition(liftGroundPosition);
               rightLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               rightLift.setPower(0.5);
               leftLift.setTargetPosition(liftGroundPosition);
               leftLift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               leftLift.setPower(0.5);
            }

            // if the y button is pressed, move to **high
            if (gamepad1.y) {
               armMotor.setTargetPosition(liftHighPosition);
               armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               armMotor.setPower(0.5);
            }
         
            // if the b button is pressed, move to **mid
            if (gamepad1.b) {
               armMotor.setTargetPosition(liftMidPosition);
               armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               armMotor.setPower(0.5);
            }
         
           // if the a button is pressed, move to **low
            if (gamepad1.a) {
               armMotor.setTargetPosition(liftLowPosition);
               armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               armMotor.setPower(0.5);
            }

            // get the current position of the motor
            double position = rightLift.getCurrentPosition();
            double position = leftLift.getCurrentPosition();

            // get the target position of the motor
            double desiredPosition = rightLift.getTargetPosition();
            double desiredPosition = leftLift.getTargetPosition();

            // show the position of the motor on telemetry
            telemetry.addData("Encoder Position", position);

            // show the target position of the motor on telemetry
            telemetry.addData("Desired Position", desiredPosition);

            telemetry.update();
      }
   }
}
