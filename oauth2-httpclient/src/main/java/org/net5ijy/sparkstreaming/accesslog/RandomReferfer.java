package org.net5ijy.sparkstreaming.accesslog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 获取随机referer
 *
 * @author xuguofeng
 * @date 2019/9/30 16:03
 */
public class RandomReferfer {

  private static List<String> referers;

  private static List<String> query;

  static {

    referers = new ArrayList<>();
    referers.add("https://www.baidu.com/s?wd=");
    referers.add("https://www.sogou.com/web?query=");
    referers.add("https://www.so.com/s?q=");
    referers.add("https://search.yahoo.com/search?p=");

    query = new ArrayList<>();
    query.add("hadoop基础");
    query.add("hadoop高级");
    query.add("大数据");
    query.add("java");
    query.add("Linux");
    query.add("运维");
    query.add("编程语言");
    query.add("spark学习");
  }

  public static String randomReferer() {

    Random random = new Random();
    int nextInt = random.nextInt(10);

    int i = 7;

    if (nextInt < i) {

      String referer = referers.get(random.nextInt(referers.size()));
      String queryStr = query.get(random.nextInt(query.size()));

      return referer + queryStr;
    }

    return "-";
  }
}
