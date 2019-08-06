package com.maitianer.starter.utils;

import com.maitianer.common.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yuzhe
 * @Date 2019/1/4 16:05
 **/
public class RegexUtils {


    public static List<String> getImageSrcFromHtml(String html) {
        List<String> imageSrcList = new ArrayList<>();
        if (StringUtils.isNotBlank(html)) {
            Pattern p = Pattern.compile("<img\\b[^>]*\\bsrc\\b\\s*=\\s*('|\")?([^'\"\n\r\f>]+(\\.jpg|\\.bmp|\\.eps|\\.gif|\\.mif|\\.miff|\\.png|\\.tif|\\.tiff|\\.svg|\\.wmf|\\.jpe|\\.jpeg|\\.dib|\\.ico|\\.tga|\\.cut|\\.pic)\\b)[^>]*>", Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(html);
            String quote = null;
            String src = null;
            while (m.find()) {
                quote = m.group(1);
                src = (quote == null || quote.trim().length() == 0) ? m.group(2).split("//s+")[0] : m.group(2);
                imageSrcList.add(src);
            }
        }
        return imageSrcList;
    }

}
