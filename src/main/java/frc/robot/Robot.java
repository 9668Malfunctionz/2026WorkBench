// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Robot extends TimedRobot {
  

  private XboxController controller;
  private double currentRightTriggerValue;
  private double currentLeftTriggerValue;
  public static SparkMaxConfig DefaultConfig = new SparkMaxConfig();    
  private SparkMax motor3; 
  private SparkMax motor7; 
  public static final int kmotor3CanID = 2;
  public static final int kmotor7CanID = 7;

  static {
    DefaultConfig.smartCurrentLimit(50);
    DefaultConfig.idleMode(IdleMode.kCoast);
    DefaultConfig.openLoopRampRate(1.0);
    DefaultConfig.inverted(false);
  }


  public Robot() {}


  @SuppressWarnings("removal")
  @Override
  public void robotInit() {
    motor3 = new SparkMax(kmotor3CanID, MotorType.kBrushless);
    motor3.configure(DefaultConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    motor7 = new SparkMax(kmotor7CanID, MotorType.kBrushless);
    motor7.configure(DefaultConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
    controller = new XboxController(0);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    
    currentRightTriggerValue = controller.getRightTriggerAxis();
    if (currentRightTriggerValue > 0.05) {
      motor3.set(currentRightTriggerValue);
    }
    else {
      motor3.stopMotor();
    }

    currentLeftTriggerValue = controller.getLeftTriggerAxis(); 
    if (currentLeftTriggerValue > 0.05) {
      motor7.set(currentLeftTriggerValue);
    }
    else {
      motor7.stopMotor();
    }
  }
 
  

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
