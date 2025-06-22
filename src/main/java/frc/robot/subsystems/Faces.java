package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

//import edu.wpi.first.wpilibj.util.Color;

import java.io.FileReader;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Properties;

//import edu.wpi.first.wpilibj.AddressableLED;
//import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Timer;

import com.ctre.phoenix6.controls.SolidColor;
import com.ctre.phoenix6.hardware.CANdle;
import com.ctre.phoenix6.signals.RGBWColor;


public class Faces extends SubsystemBase {
    //private static final int LED_PIN = 1;//port number
    private static final int NUM_LEDS = 264;//number of lights (16 by 16 plus 8)
    //private static final double BRIGHTNESS = 0.5;

    private Timer time = new Timer();
    //private AddressableLED led = new AddressableLED(LED_PIN);
    //private AddressableLEDBuffer ledBuffer = new AddressableLEDBuffer(NUM_LEDS);
    private CANdle candle = new CANdle(1);


    //private static final Map<String, short[]> Face = new HashMap<String, short[]>();

    public short[] chosenFace = {  
        50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0,50,50,0
    };
    public short[]previousFace = chosenFace;
    public short[]defaultFace = chosenFace;
    //private final LEDPattern blue = LEDPattern.solid(new Color(.2, .2, .2));
    public Faces() {
        //led = new AddressableLED(LED_PIN);
        //led.setLength(NUM_LEDS);
        //led.start();
        //blue.applyTo(ledBuffer);
    }
    public void resetTime(){
       time.reset();
    }
    public void startTime(){
        time.start();
     }
    public double getTime(){
        return time.get();
    }

    public void clear() {
        candle.setControl(new SolidColor(0, 263).withColor( new RGBWColor(0, 0, 0, 0)));

    }
    public void makeFace(short[] pixelsArray){
        for (int i = 0, j = 8; j < NUM_LEDS && i + 2 < pixelsArray.length; i += 3, j++) {  
            candle.setControl(new SolidColor(j, j).withColor( new RGBWColor(pixelsArray[i], pixelsArray[i + 1], pixelsArray[i + 2], 0)));
        }
        //led.setData(ledBuffer);
    }
    public void setFace(short[] face){
        chosenFace = face;
    }

    public short[] getFace(String name) {
        try {
            FileReader faceFile = new FileReader(Filesystem.getDeployDirectory() + "/faces.properties");
            Properties p = new Properties();
            p.load(faceFile);
            return convertToArray(p.getProperty(name));
        } catch (Exception e) {
            System.err.println("Error loading face properties: " + e);
            return defaultFace;
        }
    }

    public short[] convertToArray(String input) {
        String[] stringArray = input.split(",");
        short[] shortArray = new short[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            try {
                shortArray[i] = Short.parseShort(stringArray[i].trim());
            } catch (NumberFormatException e) {
                System.err.println("Error parsing short: " + e);
                return new short[0];
            }
        }
        return shortArray;
    }

    @Override
    public void periodic() {
       //led.setData(ledBuffer);
       if(previousFace != chosenFace){
       System.out.println("It changed");
       previousFace = chosenFace;
       makeFace(chosenFace);
       }
       //led.setData(ledBuffer);
       /*try {
        getFace("smile");
       } catch (Exception e) {
        // TODO: handle exception
        System.err.println(e);
       }*/
    }
}
