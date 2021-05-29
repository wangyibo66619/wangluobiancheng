package demo02;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 王艺博
 * @date 2021/5/26 14:54
 */
public class TcpServerSocketDemo02 {
    public static void main(String[] args) throws Exception{
        // 创建服务
        ServerSocket serverSocket = new ServerSocket(7777);
        // 监听客户端的连接
        Socket accept = serverSocket.accept();// 阻塞式监听，会一直等待客户端连接
        // 获取输入流
        InputStream is = accept.getInputStream();
        // 文件输出
        FileOutputStream fis = new FileOutputStream("receive.png");
        byte[] buffer = new byte[1024];
        int len;
        while ( (len = is.read(buffer)) != -1 ) {
            fis.write(buffer,0,len);
        }


        // 通知客户端我接受完毕了
        OutputStream os = accept.getOutputStream();
        os.write("我接受完毕了，你可以断开了".getBytes());
        // 关闭资源
        os.close();
        fis.close();
        is.close();
        accept.close();
        serverSocket.close();

    }
}
