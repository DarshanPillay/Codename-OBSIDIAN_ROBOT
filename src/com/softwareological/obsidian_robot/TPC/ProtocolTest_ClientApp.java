package com.softwareological.obsidian_robot.TPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Protocol Test Client console test application.
 * 
 * This is the client component of the Protocol Test Client/Server console test application
 * that test the protocol used in this project.
 * 
 * @author Kaylen Travis Pillay
 * @version 1.0
 */
public class ProtocolTest_ClientApp {

	/**
	 * Application.
	 * 
	 * This is the Client application that test the client side of the
	 * Protocol Test Client/Server application. This allows us to perform the TPC, by
	 * testing the protocol designed for this project.
	 * 
	 * @param args the required command-line arguments to run the client test application.
	 * @author Kaylen Travis Pillay
	 * @version 1.0
	 */
	public static void main(String[] args) {
		/*
		 * Note that if you run the server of a Windows machine, you can to 
		 * command-prompt and type 'ipconfig'. Look for your IPv4 address and
		 * assign that value to the ipAddress variable.
		 */
		String ipAddress = "ENTER THE IP_ADDRESS OF THE SERVER";
		int portNumber = 4444;
		
		try(
			Socket socket = new Socket(ipAddress,portNumber);
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Scanner scanner = new Scanner(System.in);
			)
		{
			String message;
			System.out.println(bufferedReader.readLine());
			
			while((message = scanner.nextLine()) != null) {
				printWriter.println(message);
				System.out.println(bufferedReader.readLine());
				if(message.equals("Bye.")) {
					break;
				}
			}
		}
		catch(IOException e) {
			System.out.println("Unable to connect to the server.");
		}
	}

}
