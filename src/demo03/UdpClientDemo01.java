package demo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author 王艺博
 * @date 2021/5/26 17:10
 */
// 不需要连接服务器
public class UdpClientDemo01 {
    public static void main(String[] args) throws Exception{
        // 建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        // 建个包
        String msg = "你好";
        // 发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 7777;
        // 数据，数据长度的起始，数据的长度，要发送给谁
        DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,7777);
        // 发送包
        socket.send(packet);

        // 关闭流
        socket.close();
    }
}
