// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;

//import edu.wpi.first.wpilibj.Filesystem;
//import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Faces;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Mood extends Command {
  private Faces faces;
  private int mood;
  private int mode;
  private int frameNumber;
  private double faceTime;
  
  CommandXboxController controller;
  /** Creates a new smile. */
  public Mood(Faces faces, CommandXboxController controller) {
    this.faces = faces;
    this.controller = controller;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(faces);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mode = 0;
    mood = -1;
    faces.clear();
    faces.resetTime();
    faces.startTime();
    faceTime = 0;
    frameNumber = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(controller.a().getAsBoolean()){
      mood = 0;
    }
    else if (controller.b().getAsBoolean()){
      mood = 1;
    }
    else if (controller.y().getAsBoolean()){
      mood = 2;
    }
    switch (mood){
      case 0:
        faces.setFace(faces.getFace("smile"));
        break;
      case 1:
        faceTime = (faces.getTime() - (0.5625 * frameNumber));
        if(faceTime >= 0.5625){
          mode++;
          mode = (mode % 4);
          frameNumber++;
          
        }           
        if (mode == 0){
          faces.setFace(faces.getFace("dizzyOne"));
        }
        else if (mode == 1){
          faces.setFace(faces.getFace("dizzyTwo"));
        }
        else if (mode == 2){
          faces.setFace(faces.getFace("dizzyThree"));
        }
        else if (mode == 3){
          faces.setFace(faces.getFace("dizzyFour"));
        }
        else{
          mood = 0;
        }
        break;
      case 2:
        faceTime = (faces.getTime() - (0.5625 * frameNumber));
        if(faceTime >= 0.5625){
          mode++;
          mode = (mode % 16);
          frameNumber++;
        }           
        if (mode == 0){
          faces.setFace(faces.getFace("waterOne"));
        }
        else if (mode == 1){
          faces.setFace(faces.getFace("waterTwo"));
        }
        else if (mode == 2){
          faces.setFace(faces.getFace("waterThree"));
        }
        else if (mode == 3){
          faces.setFace(faces.getFace("waterFour"));
        }
        else if (mode == 4){
          faces.setFace(faces.getFace("waterFive"));
        }
        else if (mode == 5){
          faces.setFace(faces.getFace("waterSix"));
        }
        else if (mode == 6){
          faces.setFace(faces.getFace("waterSeven"));
        }
        else if (mode == 7){
          faces.setFace(faces.getFace("waterEight"));
        }
        else if (mode == 8){
          faces.setFace(faces.getFace("waterNine"));
        }
        else if (mode == 9){
          faces.setFace(faces.getFace("waterTen"));
        }
        else if (mode == 10){
          faces.setFace(faces.getFace("waterEleven"));
        }
        else if (mode == 11){
          faces.setFace(faces.getFace("waterTwelve"));
        }
        else if (mode == 12){
          faces.setFace(faces.getFace("waterThirteen"));
        }
        else if (mode == 13){
          faces.setFace(faces.getFace("waterFourteen"));
        }
        else if (mode == 14){
          faces.setFace(faces.getFace("waterFifteen"));
        }
        else if (mode == 15){
          faces.setFace(faces.getFace("waterSixteen"));
        }
      }
    }

  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}