package com.ljy.iot.server;

import com.ljy.iot.handler.EchoServerHandler;
import com.ljy.iot.decoder.MyDelimiterBasedFrameDecoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author : 夕
 * @date : 2019/8/8
 */
public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public void start() throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup(); //3 创建 EventLoopGroup
        try {
            ServerBootstrap b = new ServerBootstrap(); //4 创建 ServerBootstrap
            b.group(group)
                    .channel(NioServerSocketChannel.class)        //5 指定使用 NIO 的传输 Channel
                    .localAddress(new InetSocketAddress(port))    //6 设置 socket 地址使用所选的端口
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        public void initChannel(SocketChannel ch)
                                throws Exception {
                            //分割符
                            ByteBuf delimiter = Unpooled.copiedBuffer(new byte[]{(byte)0x7b});
                            //打印分隔符
                            ch.pipeline().addLast("frameDecoder", new MyDelimiterBasedFrameDecoder(1024,false, delimiter));
                            ch.pipeline().addLast(  //7 添加 EchoServerHandler 到 Channel 的 ChannelPipeline
                                    new EchoServerHandler());
                        }
                    });


            ChannelFuture f = b.bind().sync();            //8 绑定的服务器;sync 等待服务器关闭
            System.out.println(EchoServer.class.getName() + " started and listen on " + f.channel().localAddress());
            f.channel().closeFuture().sync();            //9 关闭 channel 和 块，直到它被关闭
        } finally {
            group.shutdownGracefully().sync();            //10 .关闭 EventLoopGroup，释放所有资源。
        }
    }

}