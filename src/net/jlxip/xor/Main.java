package net.jlxip.xor;

public class Main {
	public static void main(String[] args) {
		byte key = (byte)0xFC;
		String data = "Hello XOR";
		
		byte[] encoded = XOR.applyXOR(key, data.getBytes());
		System.out.println("Encoded: " + new String(encoded));
		
		byte[] decoded = XOR.applyXOR(key, encoded);
		System.out.println("Decoded: " + new String(decoded));
	}
}