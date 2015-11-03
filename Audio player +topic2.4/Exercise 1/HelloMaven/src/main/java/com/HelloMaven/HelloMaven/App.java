package com.HelloMaven.HelloMaven;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {	System.out.println( "HelloMaven" );
    	System.out.println( "Enter your name" );
    	Scanner input = new Scanner(System.in);
    	String name = input.next();
        System.out.println( "Hello "+name+"!!!!");
    }
}
