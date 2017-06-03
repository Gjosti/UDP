import java.io.*;
import java.net.*;

public class UDPKlient {

	public static void main(String[] args) throws Exception{
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = inFromUser.readLine();
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,9876);
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length,IPAddress,9876);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData(),0,receivePacket.getLength());
		System.out.println("From SERVER: " + modifiedSentence);
		clientSocket.close();

	}

}