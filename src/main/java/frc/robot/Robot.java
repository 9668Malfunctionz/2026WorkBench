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

@SuppressWarnings("removal")
public class Robot extends TimedRobot {
  
  private XboxController controller;
  public static SparkMaxConfig DefaultConfig = new SparkMaxConfig();    
  private SparkMax motor; 
  public static final int kmotorCanID = 2;

  static {
    DefaultConfig.smartCurrentLimit(50);
    DefaultConfig.idleMode(IdleMode.kCoast);
    DefaultConfig.openLoopRampRate(1.0);
    DefaultConfig.inverted(false);
  }

  public Robot() {}

  @Override
  public void robotInit() {
    motor = new SparkMax(kmotorCanID, MotorType.kBrushless);
    motor.configure(DefaultConfig, ResetMode.kNoResetSafeParameters, PersistMode.kNoPersistParameters);
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
  
    if (controller.getAButton()) {
      motor.set(1.0);      
    }
    else {
      motor.stopMotor();
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
