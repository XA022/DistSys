import java.io.*;
import java.net.*;
class UDPClient 
{    
	public static void main(String args[]) throws Exception    
	{       
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));       
		DatagramSocket clientSocket = new DatagramSocket();       
		InetAddress IPAddress = InetAddress.getByName("localhost");       
		byte[] sendData = new byte[1024];       
		byte[] receiveData = new byte[1024];       
		byte key = 7;
		//kryptering
		
		
		String sentence = inFromUser.readLine();       
		sendData = sentence.getBytes();       
		for(int i=0; i < sendData.length; i++)
		{
			
			
		}
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9890);       
		clientSocket.send(sendPacket);       
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);       
		clientSocket.receive(receivePacket);       
		String modifiedSentence = new String(receivePacket.getData());       
		System.out.println("FROM SERVER:" + modifiedSentence);       
		clientSocket.close();    
	} 
}