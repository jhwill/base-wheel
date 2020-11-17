package cn.john.will.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class SHA256Util {

    public static String getSignature(String customerAccessKey, String local_key) {
        String signature = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(local_key.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            signature = Base64.encodeBase64String(sha256_HMAC.doFinal(customerAccessKey.getBytes()));
        } catch (Exception e) {
        }
        return signature;
    }
}
