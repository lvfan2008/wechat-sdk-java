package fan.lv.wechat.util;

import lombok.Data;

import java.nio.charset.Charset;

/**
 * @author lv_fan2008
 */
@Data
public class SimpleHttpResp {
    /**
     * 是否为原始流
     */
    Boolean isText = true;

    /**
     * 原始流的文件名：Content-disposition:attachment; filename=xxxx.jpg
     */
    String filename;

    /**
     * 字符集
     */
    String charset;

    /**
     * 原始流，最大长度Integer.MAX_VALUE
     */
    byte[] content;

    /**
     * 文本时，可以取对应的内容
     *
     * @return 内容
     */
    public String content() {
        Charset cs = charset == null ? Charset.defaultCharset() : Charset.forName(charset);
        return new String(content, cs);
    }

    /**
     * 是否为json格式
     *
     * @return 是否为json格式
     */
    public boolean isJson() {
        return isText && (content().trim().startsWith("{") || content().trim().startsWith("["));
    }

    /**
     * 是否为xml格式
     *
     * @return 是否为xml格式
     */
    public boolean isXml() {
        return isText && (content().trim().startsWith("<xml>") || content().trim().startsWith("<?xml"));
    }
}
