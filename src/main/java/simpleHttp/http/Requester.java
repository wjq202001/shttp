package simpleHttp.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Wang Juqiang on 2018/3/17.
 */
public class Requester {
    public static String get(RequestSettings requestSettings) throws IOException {
        return sendRequest(requestSettings, null);
    }

    public static String post(RequestSettings requestSettings, String postBody) throws IOException {
        return sendRequest(requestSettings, postBody.getBytes());
    }

    private static String sendRequest(RequestSettings requestSettings, byte[] postBody) throws IOException {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = requestSettings.getUrl();
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestMethod(requestSettings.getMethod().toString());
            connection.setConnectTimeout(requestSettings.getTimeOut());
            connection.setRequestProperty("content-type", requestSettings.getContentType());
            connection.setRequestProperty("accept", requestSettings.getAccept());
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("charset", requestSettings.getCharset());
            connection.setRequestProperty("user-agent",
                    requestSettings.getUserAgent());
            if (postBody != null) {
                connection.setDoOutput(true);
                connection.getOutputStream().write(postBody);
            }


            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
        /*
        Map<String, List<String>> map = connection.getHeaderFields();
        // 遍历所有的响应头字段
        for (String key : map.keySet()) {
            System.out.println(key + "--->" + map.get(key));
        }
        */
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            Integer code = connection.getResponseCode();
            if (code == 200) {
//                log.info("200响应URL："+url + "响应编码:"+code +". SourceUrl:" +sourceUrl);
            } else {
//                log.error("非200响应URL："+url+"响应编码:"+code +". SourceUrl:" +sourceUrl);
            }
        } catch (Exception e) {
            throw e;
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
