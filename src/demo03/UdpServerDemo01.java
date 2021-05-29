package demo03;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 王艺博
 * @date 2021/5/26 17:24
 */
// 还是要等待客户端的连接
public class UdpServerDemo01 {
    public static void main(String[] args) throws Exception{
        // 开放端口
        DatagramSocket socket = new DatagramSocket(7777);
        //接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length);
        // 阻塞接收
        socket.receive(packet);
        System.out.println(packet.getAddress().getHostName());
        System.out.println(new String(packet.getData(),0, packet.getLength()));
        // 关闭连接
        socket.close();
    }
}
