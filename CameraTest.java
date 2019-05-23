
/**
 * Tests to see if the camera works with JRPiCam
 * 
 * @JackEastman 
 * @5/23/19
 */

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
import com.hopding.jrpicam.enums.ImageEffect;
import com.hopding.jrpicam.enums.MeteringMode;
import com.hopding.jrpicam.exceptions.FailedToRunRaspistillException;

public class CameraTest
{
    //Creates a camera object variable as a field
    public static RPiCamera piCam;

    public static void main(String[] args)
    {
        try {
			piCam = new RPiCamera("/home/pi/Pictures");
		} catch (FailedToRunRaspistillException e) {
			e.printStackTrace();
		}
        piCam.setWidth(800).setHeight(600); // Set Camera to produce 800 by 600 images.
        piCam.setBrightness(50);                // Adjust Camera's brightness setting.
        piCam.setExposure(Exposure.AUTO);       // Camera exposure
        piCam.setTimeout(2);                    // Camera timeout delay
        piCam.setAddRawBayer(true);            // Add Raw Bayer data to images
        // resets Camera settings
        piCam.setToDefaults();
        piCam.setWidth(800).setHeight(600); // Set Camera to produce 800 by 600 images.
        
        try {
            piCam.takeStill("Picture1");
        } catch (IOException e) { //Catches exception if Raspistill is not installed
            e.printStackTrace();
        } catch (InterruptedException e) { //Catches exception if 
            e.printStackTrace();
        }
        //BufferedImage image = piCam.takeBufferedStill(); //used for creating buffered images in raspberry pi
    }
}