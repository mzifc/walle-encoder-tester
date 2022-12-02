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

      // Find a motor in the hardware map named motors
      DcMotor rightLift = hardwareMap.dcMotor.get("rightLift");
      DcMotor leftLift = hardwareMap.dcMotor.get("leftLift");

      // reset the motor encoder so that it reads zero ticks
      armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

      // Sets the starting position of the arm to the down position
      armMotor.setTargetPosition(liftGroundPosition);
      armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

      waitForStart();

      while (opModeIsActive()) {
            // If the A button is pressed, raise the arm
            if (gamepad1.a) {
               armMotor.setTargetPosition(armUpPosition);
               armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               armMotor.setPower(0.5);
            }

            // If the B button is pressed, lower the arm
            if (gamepad1.b) {
               armMotor.setTargetPosition(armDownPosition);
               armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
               armMotor.setPower(0.5);
            }

            // Get the current position of the armMotor
            double position = armMotor.getCurrentPosition();

            // Get the target position of the armMotor
            double desiredPosition = armMotor.getTargetPosition();

            // Show the position of the armMotor on telemetry
            telemetry.addData("Encoder Position", position);

            // Show the target position of the armMotor on telemetry
            telemetry.addData("Desired Position", desiredPosition);

            telemetry.update();
      }
   }
}
