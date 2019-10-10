package org.net5ijy.oauth2.httpclient;

import com.ggstar.util.ip.IpHelper;

/**
 * 测试ipdatabase
 *
 * @author xuguofeng
 * @date 2019/10/10 14:31
 */
public class TestIpDataBase {

  public static void main(String[] args) {
    String ip = "59.44.43.190";
    String region = IpHelper.findRegionByIp(ip);
    System.out.println(region);
  }
}
