package org.net5ijy.sparkstreaming.accesslog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 访问日志生产 - 生成随机IP地址
 *
 * @author xuguofeng
 * @date 2019/9/30 14:47
 */
public class RandomIps {

  public static void main(String[] args) {

    produceIps();
    List<String> ips = ips();
    System.out.println("ips.size = " + ips.size());
  }

  public static void produceIps() {

    try (PrintWriter writer = new PrintWriter(new FileOutputStream("logs/ip.txt"))) {

      List<String> ips = new ArrayList<>();
      ips.add("10");
      ips.add("163");
      ips.add("100");
      ips.add("200");
      ips.add("167");
      ips.add("50");
      ips.add("89");
      ips.add("106");
      ips.add("203");
      ips.add("118");
      ips.add("20");
      ips.add("98");
      ips.add("56");
      ips.add("202");
      ips.add("90");
      ips.add("22");

      Random random = new Random();

      int count = 1000;
      int count1 = 4;

      for (int i = 0; i < count; i++) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < count1; j++) {
          String n = ips.get(random.nextInt(ips.size()));
          builder.append(n).append(".");
        }
        writer.println(builder.substring(0, builder.length() - 2));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static List<String> ips() {

    List<String> ips = new ArrayList<>();

    File ip = new File("logs/ip.txt");
    if (!ip.exists() || ip.length() == 0) {
      System.out.println(">>> WARN: ip.txt not exists, will create it.");
      produceIps();
    }

    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("logs/ip.txt")))) {

      String line = reader.readLine();

      while (line != null) {
        ips.add(line);
        line = reader.readLine();
      }

      return ips;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
