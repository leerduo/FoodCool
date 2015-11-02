package com.bohe.foodcool.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;

/**
 * Created by wangteng.
 * Time:2015/11/2
 * Email:843203996@qq.com
 */
public final class StreamUtil {

    private StreamUtil() {

    }

    public static void close(Object stream) {
        if (stream != null) {

            try {

                if (stream instanceof InputStream) {
                    ((InputStream) stream).close();
                } else if (stream instanceof OutputStream) {
                    ((OutputStream) stream).close();
                } else if (stream instanceof Reader) {
                    ((Reader) stream).close();
                } else if (stream instanceof Writer) {
                    ((Writer) stream).close();
                } else if (stream instanceof HttpURLConnection) {
                    ((HttpURLConnection) stream).disconnect();
                }

            } catch (Exception ex) {

            }

        }
    }

    /**
     * @param in
     * @return
     * @throws IOException
     */
    public static byte[] readStream(InputStream in) throws IOException {
        byte[] ret = null;

        if (in != null) {

            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buf = new byte[128];

            int len;

            while (true) {
                len = in.read(buf);
                if (len == -1) {
                    break;
                }
                bout.write(buf, 0, len);
            }

            // 注意  buf 必须要进行 = null 的操作
            // 减少内存溢出的可能性
            buf = null;

            ret = bout.toByteArray();

            bout.close();

        }

        return ret;
    }

}
