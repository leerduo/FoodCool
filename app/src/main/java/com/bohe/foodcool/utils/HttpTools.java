package com.bohe.foodcool.utils;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
public final  class HttpTools {


    private HttpTools() {

    }

    private static final int CONNECT_TIMEOUT = 5000;

    private static final int READ_TIMEOUT = 30000;

    /**
     * Get 请求方式
     * @param url
     * @return
     */
    public static byte[] doGet(String url) {
        byte[] ret = null;

        if (url != null) {

            HttpURLConnection conn = null;

            try {
                URL u = new URL(url);
                conn = (HttpURLConnection) u.openConnection();

                //  设置连接的配置
                conn.setConnectTimeout(CONNECT_TIMEOUT);
                conn.setReadTimeout(READ_TIMEOUT);

                conn.setRequestMethod("GET");

                //  设置接受的内容压缩比编码算法
                conn.setRequestProperty("Accept-Encoding","gzip");

                conn.connect();
                int code = conn.getResponseCode();
                if (code == 200) {
                    // TODO 给 data 赋值
                    InputStream fin = null;
                    try {
                        fin = conn.getInputStream();

                        // TODO    进行网络输入流的GZIP压缩

                        String encoding = conn.getHeaderField("Content-Encoding");

                        if("gzip".equals(encoding)){
                            fin = new GZIPInputStream(fin);
                        }

                        ret = StreamUtil.readStream(fin);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        StreamUtil.close(fin);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                StreamUtil.close(conn);
            }
        }
        return ret;
    }



}
