package org.net5ijy.sparkstreaming.accesslog;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取URL列表
 *
 * @author xuguofeng
 * @date 2019/9/30 15:30
 */
public class RandomUrl {

  public static void main(String[] args) {

    List<Url> urls = urls();

    for (Url url : urls) {
      System.out.println(url);
    }
  }

  public static List<Url> urls() {

    List<Url> urls = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(
        new InputStreamReader(new FileInputStream("logs/url.txt")))) {

      String line = reader.readLine();

      while (line != null) {
        String[] fields = line.split("\\s{4}");
        urls.add(new Url(fields[0], fields[1]));
        line = reader.readLine();
      }

      return urls;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static class Url {

    private String urlStr;

    private String name;

    public Url(String urlStr, String name) {
      this.urlStr = urlStr;
      this.name = name;
    }

    public String getUrlStr() {
      return urlStr;
    }

    public String getName() {
      return name;
    }

    @Override
    public String toString() {
      return "Url{" +
          "urlStr='" + urlStr + '\'' +
          ", name='" + name + '\'' +
          '}';
    }
  }
}
