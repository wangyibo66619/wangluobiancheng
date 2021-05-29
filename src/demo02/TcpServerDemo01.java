package demo02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王艺博
 * @date 2021/5/26 10:26
 */
// 服务端
public class TcpServerDemo01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            // 我得有一个地址
            serverSocket = new ServerSocket(9999);
            while (true) {
                // 等待客户端连过来
                accept = serverSocket.accept();
                // 读取客户端消息
                is = accept.getInputStream();
            /*
                byte[] bys = new byte[1024];
                int len;
                while ( (len = is.read(bys)) != -1 ) {
                    System.out.println(new String(bys, 0, len));
                }
             */
                // 管道流
                bos = new ByteArrayOutputStream();
                byte[] bys = new byte[1024];
                int len;
                while ((len = is.read(bys)) != -1) {
                    bos.write(bys, 0, len);
                }
                System.out.println(bos.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
