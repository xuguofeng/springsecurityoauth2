package org.net5ijy.sparkstreaming.accesslog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机获取一个向右状态码
 *
 * @author xuguofeng
 * @date 2019/9/30 15:47
 */
public class RandomStatus {

  private static List<String> statusList;

  static {
    statusList = new ArrayList<>();
    statusList.add("200");
    statusList.add("200");
    statusList.add("200");
    statusList.add("200");
    statusList.add("200");
    statusList.add("200");
    statusList.add("500");
    statusList.add("500");
    statusList.add("400");
    statusList.add("400");
  }

  public static String randomStatus() {
    Random random = new Random();
    int nextInt = random.nextInt(statusList.size());
    return statusList.get(nextInt);
  }
}
