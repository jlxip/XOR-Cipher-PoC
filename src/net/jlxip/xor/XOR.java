package net.jlxip.xor;

/*
 * XOR.java by JlXip
 * https://github.com/jlxip/XOR-Cipher-PoC
 * 
 * */

public class XOR {
	public static boolean[] getBinaryValues(byte b) {
		boolean binaryKey[] = new boolean[8];
		for(int i=0;i<8;i++) binaryKey[i] = (b & (byte)(128 / Math.pow(2, i))) != 0;
		return binaryKey;
	}
	
	public static byte getByteFromBinaryValues(boolean[] binaryValues) {
		byte b = 0;
		for(int i=0;i<8;i++) if(binaryValues[i]) b |= (128 >> i);
		return b;
	}
	
	public static byte applyXOR(byte a, byte b) {
		boolean[] binaryA= getBinaryValues(a);
		boolean[] binaryB = getBinaryValues(b);
		
		boolean[] thisByteFinished = new boolean[8];
		for(int j=0;j<8;j++) thisByteFinished[j] = binaryA[j] ^ binaryB[j];
		
		return getByteFromBinaryValues(thisByteFinished);
	}
	
	public static byte[] applyXOR(byte key, byte[] data) {
		byte[] finished = new byte[data.length];
		for(int i=0;i<data.length;i++) finished[i] = applyXOR(data[i], key);
		
		return finished;
	}
}
