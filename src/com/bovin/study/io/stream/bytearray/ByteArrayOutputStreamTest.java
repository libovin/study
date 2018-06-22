package com.bovin.study.io.stream.bytearray;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ByteArrayOutputStreamTest
 *
 * @author Bovin
 * Create on 2018/6/21
 */
public class ByteArrayOutputStreamTest {

    private static final int LEN = 5;
    // 对应英文字母“abcddefghijklmnopqrsttuvwxyz”
    private static final byte[] ArrayLetters = {
            0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F,
            0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A
    };

    public static void main(String[] args) {
        //String tmp = new String(ArrayLetters);
        //System.out.println("ArrayLetters="+tmp);

        tesByteArrayOutputStream();
    }

    /**
     * ByteArrayOutputStream的API测试函数
     */
    private static void tesByteArrayOutputStream() {
        // 创建ByteArrayOutputStream字节流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        // 依次写入“A”、“B”、“C”三个字母。0x41对应A，0x42对应B，0x43对应C。
        byteArrayOutputStream.write(0x41);
        byteArrayOutputStream.write(0x42);
        byteArrayOutputStream.write(0x43);
        System.out.printf("byteArrayOutputStream=%s\n", byteArrayOutputStream);

        // 将ArrayLetters数组中从“3”开始的后5个字节写入到baos中。
        // 即对应写入“0x64, 0x65, 0x66, 0x67, 0x68”，即“defgh”
        byteArrayOutputStream.write(ArrayLetters, 3, 5);
        System.out.printf("byteArrayOutputStream=%s\n", byteArrayOutputStream);

        // 计算长度
        int size = byteArrayOutputStream.size();
        System.out.printf("size=%s\n", size);

        // 转换成byte[]数组
        byte[] buf = byteArrayOutputStream.toByteArray();
        String str = new String(buf);
        System.out.printf("str=%s\n", str);

        // 将baos写入到另一个输出流中
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            byteArrayOutputStream.writeTo(byteArrayOutputStream2);
            System.out.printf("byteArrayOutputStream2=%s\n", byteArrayOutputStream2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
