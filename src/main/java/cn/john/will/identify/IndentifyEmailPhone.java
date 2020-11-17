package cn.john.will.identify;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndentifyEmailPhone {
    /**
     * 鉴别手机好长度数字
     *
     * @param phone
     * @author jhw
     */
    public static boolean isNumeric(String phone) {
        String pattern = "^[0-9]*$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(phone);
        return m.matches();
    }

    /**
     * 鉴别邮箱
     *
     * @param email
     * @author jhw
     */
    public static boolean isEmail(String email) {
 /*        判断邮箱格式是否正确：合法的邮箱名中至少要包含"@", 并且"@"是在"."之前  
        1、获取文件名中"@"符号的位置 
        2、获取邮箱中"."号的位置 
        3、判断必须包含"@"符号，且"@"必须在"."之前 
         获取邮箱中"@"符号的位置  
        int index2 = email.indexOf("@");  
         获取邮箱中"."号的位置  
        int index3 = email.lastIndexOf('.');  
         判断必须包含"@"符号，且"@"必须在"."之前  
        if (index2 != -1 && index3 > index2) {
            return true;
        } else {
            return false;
        } */

        String pattern = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);
        return m.matches();
    }
}
