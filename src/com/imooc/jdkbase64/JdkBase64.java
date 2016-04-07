package com.imooc.jdkbase64;


import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;//这个包需要额外导入   rt.jar

public class JdkBase64 {

	/**
	 * @param args
	 * 算法实现：
	 * --Jdk
	 * --Commons Codec
	 * --Bouncy Castle
	 */
	
	/*
	 * Base64的应用场景：e-mail.密钥，证书文件
	 * 基于64个字符的编码算法
	 */
	
	private static String src ="imooc security Base64";
	public static void main(String[] args) throws IOException {
		jdkBase64();
		commonsCodesBase64();
		bouncyCastleBase64();
	}
	
	public static void jdkBase64() throws IOException{
		BASE64Encoder  encoder = new BASE64Encoder();
		String encode = encoder.encode(src.getBytes());
		System.out.println("encode:"+encode);
		
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] b = decoder.decodeBuffer(encode);
		String s = new String(b);
		System.out.println("decode:"+s);
	}

	
	//使用CC方法
	public static void commonsCodesBase64(){
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		System.out.println("encode:"+new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decode:"+new String(decodeBytes));	
	}
	
	//使用BC实现
	public static void bouncyCastleBase64(){
		//由于上面还有一个Base64，所以这里使用全的类路径名：
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		System.out.println("encode:"+new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decode:"+new String(decodeBytes));
	}
}
