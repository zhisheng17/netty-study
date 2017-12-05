package com.zhisheng.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ByteBuffer 介绍
 * Created by 10412 on 2017/10/23.
 */
public class ByteBufferDemo
{
    public static void readFile(String fileName) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);    //分配一个新的字节缓冲区
        int size = fileChannel.read(byteBuffer);
        while (size > 0) {
            //把ByteBuffer从写模式转换为读模式
            byteBuffer.flip();
            while (byteBuffer.remaining() > 0) {
                System.out.print((char) byteBuffer.get());
            }

           /* Charset charset = Charset.forName("UTF-8");
            System.out.print(charset.newDecoder().decode(byteBuffer).toString());*/

            byteBuffer.clear();
            size = fileChannel.read(byteBuffer);
        }
        fileChannel.close();
        randomAccessFile.close();
    }

}
