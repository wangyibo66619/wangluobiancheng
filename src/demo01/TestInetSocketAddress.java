package demo01;

import java.net.InetSocketAddress;

/**
 * @author 王艺博
 * @date 2021/5/25 21:14
 */
public class TestInetSocketAddress {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("localhost",8080);
        System.out.println(inetSocketAddress1);
        System.out.println(inetSocketAddress2);

        System.out.println(inetSocketAddress1.getAddress());
        System.out.println(inetSocketAddress1.getHostName());// 地址
        System.out.println(inetSocketAddress1.getPort());// 端口
    }

}
