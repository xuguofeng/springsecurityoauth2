package org.net5ijy.sparkstreaming.accesslog;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import org.net5ijy.sparkstreaming.accesslog.RandomUrl.Url;

/**
 * 访问日志生产
 *
 * @author xuguofeng
 * @date 2019/9/30 16:04
 */
public class RandomAccessLogProducer {

  public static void main(String[] args) {

    int n = 100;

    try (PrintWriter writer = new PrintWriter(new FileOutputStream("logs/access_log.txt", true))) {

      for (int i = 0; i < n; i++) {
        String log = log();
        System.out.println(log);
        writer.println(log);
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static String log() {

    Random random = new Random();

    List<String> ips = RandomIps.ips();
    String ip = ips.get(random.nextInt(ips.size()));

    String randomDateStr = RandomDateTime.randomDateStr(RandomDateTime.OFFSET_MINUTE);

    List<Url> urls = RandomUrl.urls();
    String url = urls.get(random.nextInt(urls.size())).getUrlStr();

    String randomStatus = RandomStatus.randomStatus();

    String randomReferer = RandomReferfer.randomReferer();

    return ip
        + " "
        + randomDateStr
        + " "
        + "\""
        + "GET"
        + " "
        + url
        + "\""
        + " "
        + randomStatus
        + " "
        + randomReferer;
  }
}
