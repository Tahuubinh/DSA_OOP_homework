package Eggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Hello
{
    public static void main(String[] args) throws IOException
    {
        //Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input your name: ");
        String name = reader.readLine();
        System.out.println("Your name is: " + name);
    }
}