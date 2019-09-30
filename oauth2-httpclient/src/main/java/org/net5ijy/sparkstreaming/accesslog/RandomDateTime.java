package org.net5ijy.sparkstreaming.accesslog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 根据给定时间点和最大时间差距获取一个随机时间
 *
 * @author xuguofeng
 * @date 2019/9/30 15:08
 */
public class RandomDateTime {

  private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

  public static final int OFFSET_MINUTE = 1000 * 60;

  public static final int OFFSET_HOUR = 1000 * 60 * 60;

  public static final int OFFSET_DAY = 1000 * 60 * 60 * 24;

  public static final int OFFSET_WEEK = 1000 * 60 * 60 * 24 * 7;

  public static String randomDateStr(String source, int offset) {

    SimpleDateFormat format = new SimpleDateFormat(PATTERN);

    try {
      Date date = format.parse(source);

      return randomDateStr(date, offset);

    } catch (ParseException e) {
      return "-";
    }
  }

  public static String randomDateStr(Date source, int offset) {
    Date date = randomDate(source, offset);
    return new SimpleDateFormat(PATTERN).format(date);
  }

  public static Date randomDate(Date source, int offset) {

    long l = source.getTime();

    Random random = new Random();
    int i = random.nextInt(Math.abs(offset));

    long l1 = l + i * (offset / Math.abs(offset));

    return new Date(l1);
  }

  public static String randomDateStr(int offset) {
    return randomDateStr(new Date(System.currentTimeMillis() - offset), offset);
  }

  public static void main(String[] args) {

    int n = 20;

    for (int i = 0; i < n; i++) {

      String randomDateStr = randomDateStr(OFFSET_MINUTE);

      System.out.println(randomDateStr);
    }
  }
}
