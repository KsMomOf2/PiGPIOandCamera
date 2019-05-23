
/**
 * Example of GpioController being used, tests every available pin by flashing an LED
 * 
 * @JackEastman 
 * @5/23/19
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class ControlGpio
{
    public static final GpioController gpio = GpioFactory.getInstance();
    
    public static void main(String[] args)
    {
        //initializes a new GPIO pin with digital output, GPIO pin 07, named MyLED and set to off
        //GPIO pin 7 is in reference to the pi4j pinout diagram
        //final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "MyLED", PinState.LOW);
        //System.out.println("Beginning Test");
        //testLights(pin);
        //System.out.println("Test Finished");
        
        //Above is commented out as Gpio pins cannot be created twice
        System.out.println("Beginning test of all GPIO pins");
        testEveryPin();
    }

    /*
     * Preconditions: GpioPin pin is connected to an LED
     * Will flash the led connected 5 times at an interval of 0.5 second for 0.5 seconds
     */
    public static void testLights(GpioPinDigitalOutput pin)
    {   
        //sets option so that when application is terminated, pin is set to off
        pin.setShutdownOptions(true, PinState.LOW);
        
        //turns pin "high", or on
        pin.high();
        
        for (int i = 0; i < 5; i++)
        {
            pin.high();
            System.out.println("flash");
            try { Thread.sleep(200); }     //sleeps for 0.2 seconds, unless it catches a termination
            catch (InterruptedException e)
                { break; }
            pin.low();
            try { Thread.sleep(200); }     //sleeps for 0.2 second, unless it catches a termination
            catch (InterruptedException e)
                { break; }
        }
    }
    
    public static void testEveryPin()
    {
        final GpioPinDigitalOutput[] pins = {
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_05, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_06, "MyLED", PinState.LOW),
        //gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "MyLED", PinState.LOW),  //Doesn't work
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_08, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_09, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_10, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_11, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_12, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_13, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_14, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_15, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_16, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "MyLED", PinState.LOW),
        //gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "MyLED", PinState.LOW),   //Doesn't exist
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_19, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_20, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_25, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "MyLED", PinState.LOW),
        gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "MyLED", PinState.LOW),
        };
        
        int count = 1;
        for (GpioPinDigitalOutput pin: pins)
        {
            System.out.println("Testing pin #" + count);
            try { Thread.sleep(2000); }     //sleeps for 2 seconds, unless it catches a termination
            catch (InterruptedException e)
                { break; }
            testLights(pin);
            if (count != 6 && count != 17)
                count++;
            else
                count +=2;
        }
    }
}
