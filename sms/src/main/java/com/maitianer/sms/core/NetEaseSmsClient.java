package com.maitianer.sms.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 网易云短信
 * @author chen
 */
public class NetEaseSmsClient extends AbstractSmsClient {

    private final static int SUCCESS_CODE = 200;

    private final String DEFAULT_API_GATEWAY = "https://api.netease.im/sms/sendtemplate.action";

    public NetEaseSmsClient(String appKey, String appSecret, String signName) {
        this.apiGateway = DEFAULT_API_GATEWAY;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.signName = signName;
        this.smsClientName = "网易云通讯";
    }

    private String convertParams(Map<String, Object> params) {
        if (params == null) {
            return null;
        }
        List<Object> list = new ArrayList<>();
        for(String key : params.keySet()){
            list.add(params.get(key));
        }
        return JSON.toJSONString(list);
    }

    @Override
    public boolean sendTemplateSms(String[] mobiles, String templateId, Map<String, Object> params) throws SmsClientException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(apiGateway);
        String curTime = String.valueOf((new Date()).getTime() / 1000L);
        /*
         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
         */
        String nonce = "Qqz7gxsvNBE892ZE";
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);

        // 设置请求的header
        httpPost.addHeader("AppKey", appKey);
        httpPost.addHeader("Nonce", nonce);
        httpPost.addHeader("CurTime", curTime);
        httpPost.addHeader("CheckSum", checkSum);
        String contentType = "application/x-www-form-urlencoded;charset=utf-8";
        httpPost.addHeader("Content-Type", contentType);

        // 设置请求的的参数，requestBody参数
        List<NameValuePair> nvps = new ArrayList<>();
        /*
         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
         */
        nvps.add(new BasicNameValuePair("templateid", templateId));
        nvps.add(new BasicNameValuePair("mobiles", JSON.toJSONString(mobiles)));
        nvps.add(new BasicNameValuePair("params", convertParams(params)));


        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            // 执行请求
            HttpResponse response = httpClient.execute(httpPost);
            /*
             * 1.打印执行结果，打印结果一般会200、315、403、404、413、414、500
             * 2.具体的code有问题的可以参考官网的Code状态表
             */
            String json = EntityUtils.toString(response.getEntity(), "utf-8");
            JSONObject result = JSON.parseObject(json);

            if (SUCCESS_CODE == result.getIntValue("code")) {
                return true;
            }else {
                logger.error("{}：接口调用结果不成功，错误结果：{}", smsClientName, json);
                return false;
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new SmsClientException(e);
        }
    }

    protected class NetEaseSmsResult {

        private int code;
        private String msg;
        private String desc;

        public boolean isSuccess() {
            return code == SUCCESS_CODE;
        }

        public int getCode() {
            return code;
        }

        public NetEaseSmsResult setCode(int code) {
            this.code = code;
            return this;
        }

        public String getMsg() {
            return msg;
        }

        public NetEaseSmsResult setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public String getDesc() {
            return desc;
        }

        public NetEaseSmsResult setDesc(String desc) {
            this.desc = desc;
            return this;
        }

    }

    /**
     *
     * <p>Title: CheckSumBuilder</p>
     * <p>Description: 构造 CheckSum 的工具类 </p>
     * <p>Company: com.netease.vcloud</p>
     * @date       2016-6-21
     */
    public static class CheckSumBuilder {
        /**
         *
         * <p>Title: getCheckSum</p>
         * <p>Description: 将appSecret、 nonce、 curTime 按照SHA-1加密算法生成 checkSum</p>
         * @param appSecret  开发者平台分配的appkey
         * @param nonce      随机数（随机数，最大长度128个字符）
         * @param curTime    当前UTC时间戳，从1970年1月1日0点0分0秒开始到现在的秒数
         * @return 加密生成的checkSum
         */
        public static String getCheckSum(String appSecret, String nonce, String curTime) {
            return encode("sha1", appSecret + nonce + curTime);
        }
        /**
         *
         * <p>Title: encode</p>
         * <p>Description: 将数据按照指定的加密算法加密</p>
         * @param algorithm    加密的算法
         * @param value        待加密的数据
         * @return 加密之后的数据
         */
        private static String encode(String algorithm, String value) {
            if (value == null) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
                messageDigest.update(value.getBytes());
                return getFormattedText(messageDigest.digest());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        /**
         *
         * <p>Title: getFormattedText</p>
         * <p>Description: 从摘要中取未加工的字节并将其格式化</p>
         * @param bytes    从摘要中取得的未加工的字节
         * @return 格式化后的字节
         */
        private static String getFormattedText(byte[] bytes) {
            int len = bytes.length;
            StringBuilder buf = new StringBuilder(len * 2);
            for (int j = 0; j < len; j++) {
                buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
                buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
            }
            return buf.toString();
        }
        /**
         * 十六进制数据的char数组
         */
        private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    }
}
