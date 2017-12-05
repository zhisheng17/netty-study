package com.zhisheng.nio;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by 10412 on 2017/10/23.
 */
public class ByteBufferDemoTest
{
    @Test
    public void testByteBufferRW() throws IOException {
        ByteBufferDemo.readFile("file/ByteBufferTest.txt");
    }
}