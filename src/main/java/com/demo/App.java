package com.demo;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        String WEBDRIVER_DRIVER_NAME = "webdriver.driver.name";
        System.out.println( System.getProperty(WEBDRIVER_DRIVER_NAME,"ChromeDriver"));
    }
}
