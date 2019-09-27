package org.net5ijy.oauth2.httpclient;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import org.net5ijy.commons.web.response.HtmlResponseHolder;
import org.net5ijy.commons.web.util.HttpClientUtil;

/**
 * 测试访问http://localhost:7003/order/demo?access_token=295ee60e-0aa5-4215-90ac-3676100ebb02
 *
 * @author xuguofeng
 * @date 2019/9/25 11:14
 */
public class TestHttpClient {

  public static void main(String[] args) {

    // 创建线程池
    ThreadFactory threadFactory = Thread::new;

    ExecutorService executorService =
        new ThreadPoolExecutor(
            20,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(16), threadFactory, new AbortPolicy());

    int times = 1;

    for (int i = 0; i < times; i++) {
      executorService.execute(new HttpClientRunnable());
    }
  }

  private static class HttpClientRunnable implements Runnable {

    private static String url = "http://localhost:7003/order/demo?access_token=";
    private static String token = "295ee60e-0aa5-4215-90ac-3676100ebb02";

    @Override
    public void run() {

      Random random = new Random();

      String name = Thread.currentThread().getName();

      int times = 1000000;

      for (int i = 0; i < times; i++) {

        String response = HttpClientUtil.doGet(url + token);

        Map<String, String> map = new HashMap<>(16);

        HtmlResponseHolder html =
            HttpClientUtil.getHtml(url + token, map, map);

        String content = html.getContent();

        System.out.println(name + ": " + response);
        System.out.println(name + ": " + content);

        try {
          Thread.sleep(random.nextInt(1000) + 500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
