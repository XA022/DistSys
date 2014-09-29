import java.io.*; 
import java.net.*; 

public class TcpClient
{  
	
	public static void main(String argv[]) throws Exception  
	{   
		//Opretter Strings til at afsende og modtage
		String sentence;   
		String modifiedSentence;   
		InetAddress IPAddress = InetAddress.getByName("172.17.172.159");
		//InetAddress fortæller hvilken IP at du skal svare på
		
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));   
		//Reader input fra user
		
		Socket clientSocket = new Socket(IPAddress, 6789);   
		//Generer en åbning (ClientSocket) i form a localhost igennem port 6789 
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());   
		//DataOutputStream læser ClientSocket og får info om åbningen gennem denne)
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));   
		//Læser inputtet fra 
		sentence = inFromUser.readLine();   
		
		outToServer.writeBytes(sentence + '\n');   
		
		modifiedSentence = inFromServer.readLine();   
		
		System.out.println("FROM Mathias: " + modifiedSentence);   
		
		clientSocket.close();  
		} 
	}  
	