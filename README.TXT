PROJECT TITLE: JavaGPIO
PURPOSE OF PROJECT: To make the GPIO work in Java development
DATE: 5/23/19
AUTHORS: Jack Eastman, Mrs. Kelly

USER INSTRUCTIONS:

1) Install pi4j from either the pi4j website at pi4j.com/1.2/download.html
   or by running the follow command in terminal. Pi4j 

    curl -sSL https://pi4j.com/install | sudo bash

2) Ensure that the latest version of WiringPi is installed by running

    gpio -v
    gpio -readall // will give you a listing of the pins

   Compare the version number with the number on the website wiringpi.com/download-and-install
   This step is crucial in newer Raspberry pi kernels, as their processor identifier changed
   and will not be compatible with older versions of WiringPi

3) Import the pi4j packages that you need into the Java program you are writing
   The import statements are as follows

    import com.pi4j.io.gpio.GpioController;     //Used to create gpio object and use methods
    import com.pi4j.io.gpio.GpioFactory;        //Used to instantiate the gpio object
    import com.pi4j.io.gpio.GpioPin;        //Generic gpio pin class
    import com.pi4j.io.gpio.GpioPinDigitalInput;
    import com.pi4j.io.gpio.GpioPinDigitalOutput;
    import com.pi4j.io.gpio.PinDirection;
    import com.pi4j.io.gpio.PinMode;
    import com.pi4j.io.gpio.PinPullResistance;
    import com.pi4j.io.gpio.PinState;
    import com.pi4j.io.gpio.RaspiPin;           //Used to identify pins on the Raspberry pi to define
    import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
    import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
    import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
    import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
    import com.pi4j.io.gpio.event.GpioPinListener;
    import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
    import com.pi4j.io.gpio.event.GpioPinEvent;
    import com.pi4j.io.gpio.event.GpioPinListenerDigital;
    import com.pi4j.io.gpio.event.PinEventType;

   The first two imports are always necessary to create the GpioController object and use its methods
   
4) Write the code, using as necessary the documentation from https://pi4j.com/1.2/apidocs/index.html

5) To run from Geany IDE:



6) To run from Terminal:


    Compile:

         javac -classpath .:classes:/opt/pi4j/lib/'*' -d . $filename
    
    Run:
    
         sudo pi4j --run $filename
         
7) To run from Geany, set the Build Commands (Build Menu) to the following:
    
    Compile javac  -classpath .:classes:/opt/pi4j/lib/'*' -d . "%f"
    Run     pi4j --run "%f"
    
    then use the menu to compile/run

NOTES:
When compiling and running files, make sure you are in the correct directory, the same as the file

If you run into an error where the file won't run because the hardware cannot be detected,
    make sure that pi4j and wiringPi are updated, and if they are, uninstall and reinstall pi4j.
    This issue may occur in the newer version of Raspbian

The pinout and gpio numbers are, by default, the same as in wiringPi. They are not the standard pin numbers.
    See the gpio pinout at https://pi4j.com/1.2/pin-numbering-scheme.html
    The pinout has been tested to be true on a Raspberry Pi 3 B+.
    Pin 17, 18, 19, and 20 do not exist on the version 1 boards that we have.
    
RASPBERRY PI CAMERA IN JAVA

1) Download JRPiCamera from github at https://github.com/Hopding/JRPiCam

2) Extract the files into your working directory.

3) For ease of use and compiling, take the folder JRPiCam-master/src/main/java/com and put it into the top level of your directory
   This makes compiling and importing much easier later on. The import statements in the example files and in the CameraTest file
   assume that the /com folder is in the same folder as the file being run.
   
4) Import the necessary packages into the program to use. These may include

    import java.io.File;
    import java.io.IOException;
    import javax.imageio.ImageIO;
    import java.awt.image.BufferedImage;
    import java.io.BufferedInputStream;
    import java.util.*;
    import com.hopding.jrpicam.RPiCamera;
    import com.hopding.jrpicam.enums.AWB;
    import com.hopding.jrpicam.enums.DRC;
    import com.hopding.jrpicam.enums.Encoding;
    import com.hopding.jrpicam.enums.Exposure;  
    import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;
    
   and more than can be found within the /com folder.
   
5) Use the documentation found at github.com/Hopding/JRPiCam/wiki for information on the methods

6) Compile and run files as usual.

Notes:

See CameraTest.java to see an implementation of the JRPiCamera

Make sure to catch all the exceptions listed in the method name line of the method
