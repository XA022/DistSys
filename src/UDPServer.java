import java.io.*; 
import java.net.*; 
	class UDPServer 
	{    
		public static void main(String args[]) throws Exception       
		{   
			// Create client socket
			DatagramSocket serverSocket = new DatagramSocket(9890);             
			
			// Creates bytes to receive and send data
			byte[] receiveData = new byte[1024];             
			byte[] sendData = new byte[1024]; 
			byte key = 7;
			
			//While loop to run the sequence
			
			while(true)                
			{                
				
				// Create a data to receive
				DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);                   
				
				// Receive data from server
				serverSocket.receive(receivePacket);                   
				
				// transforms the datapacket from bytes to a sting  
				String sentence = new String( receivePacket.getData());                   
				//prints the string sentence.
				System.out.println("RECEIVED: " + sentence);                   
				//Gets the IPAddress from the receivePacket and saved it in a InetAddress
				InetAddress IPAddress = receivePacket.getAddress();                   
				//Gets the Port number from the receivePacket and saves it in a int 
				int port = receivePacket.getPort();                   
				//Transforms the sentence to Uppercase (the normal reply from a UDP server)
				String capitalizedSentence = sentence.toUpperCase();                   
				//Transforms the new sentence to bytes and saved it in a string
				sendData = capitalizedSentence.getBytes();                   
				//Creates a new packet with some meta data 
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);                   
				//Sends the new packet
				serverSocket.send(sendPacket);               
			}       
		}
	}