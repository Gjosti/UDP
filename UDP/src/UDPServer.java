import java.io.*;
import java.net.*;



public class UDPServer {
	public static void main(String args[]) throws Exception
	{
		//setter opp socket og byte som databeholder som skal sendes/mottas
		DatagramSocket serverSocket = new DatagramSocket(9876);
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[1024];
			
			//l�kke som kj�rer selve serveren
			while(true){
				//mottar pakke
				DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
				serverSocket.receive(receivePacket);
				//omgj�r packet om til faktisk data vi mennesker kan lese og forst�
				String sentence = new String(receivePacket.getData(),0,receivePacket.getLength());
				//her kan vi allerede vise tekst som er mottatt og behandle den
				
				String behandletSentence = sentence.toUpperCase();
				InetAddress IPAddress = receivePacket.getAddress();
				int port = receivePacket.getPort();	
				System.out.println("Received: " + sentence );
				sendData = behandletSentence.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
				serverSocket.send(sendPacket);
				
				
			}
	}
}
