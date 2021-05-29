package demo02;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author 王艺博
 * @date 2021/5/26 10:25
 */
// 客户端
public class TcpClientDemo01 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        try {
            // 连接服务器地址，端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            // 端口号
            int port = 9999;
            // 创建一个Socket连接
            socket = new Socket(serverIP,9999);
            // 发送消息 IO流
            os = socket.getOutputStream();
            os.write("你好，我是大根".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
