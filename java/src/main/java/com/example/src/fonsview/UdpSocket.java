package com.example.src.fonsview;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/* Packet structure
 * 
 * Packet start constant (3735928559 aka 0xDEADBEEF)
 * Packet type (ACK, NAK, PKT)
 * Packet index (sequence)
 * Packet length
 * Packet data
 */

public class UdpSocket extends DatagramSocket 
{
	protected static final int CLIENT_RECV_TIMEOUT = 200;
	
	/* Defines the start of a new packet */
	protected static final int START_ID = 1001;

	/* ACK = Acknowledgement, NAK = Negative Acknowledgement, PKT = (Arbitrary) Packet */
	protected static final int ACK_ID = 0x4;
	protected static final int NAK_ID = 0x8;
	protected static final int PKT_ID = 0x1;
	protected static final int MESSAGE_ID = 0x2;
	protected static final int UDP_END_ID = 0x16;
	protected static final int IPLEN = 16;

	public ByteArrayOutputStream setSendPacketHead(int dataTpye, int dataSequence, int dataLength, String sendToAddr, int sendToPort) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);

		byte[] IP = new byte[IPLEN];
		dataOutputStream.writeInt(START_ID);
		dataOutputStream.writeInt(dataTpye);
		dataOutputStream.writeInt(dataSequence);
		dataOutputStream.writeInt(dataLength);
		System.arraycopy(sendToAddr.getBytes(), 0, IP, 0, sendToAddr.length()%(IPLEN+1));
		dataOutputStream.write(IP);
		dataOutputStream.writeInt(sendToPort);
		dataOutputStream.flush();
		return byteArrayOutputStream;

	}

	public void sendPacket(InetAddress address, int port, int dataTpye, int dataSequence, int dataLength, String sendToAddr, int sendToPort,byte[] data) throws IOException
	{
		ByteArrayOutputStream byteArrayOutputStream = setSendPacketHead( dataTpye,  dataSequence,  dataLength, sendToAddr,  sendToPort);
		DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
		dataOutputStream.write(data);
		dataOutputStream.flush();
		byte[] sendBuffer = byteArrayOutputStream.toByteArray();
		send(new DatagramPacket(sendBuffer, sendBuffer.length, address, port));
	}
	public void sendReqPacket(InetAddress address, int port, int dataTpye, int dataSequence) throws IOException
	{
		ByteArrayOutputStream byteArrayOutputStream = setSendPacketHead( dataTpye,  dataSequence,  0, "",  0);
		byte[] sendBuffer = byteArrayOutputStream.toByteArray();
		send(new DatagramPacket(sendBuffer, sendBuffer.length, address, port));
	}

	public UdpSocket() throws SocketException
	{
		super();
	}
	
	public UdpSocket(int port) throws SocketException
	{
		super(port);
	}
}
