package com.zxh.weather.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zxh
 * @Title: StringUtils
 * @ProjectName weather
 * @Description: TODO
 * @date 2018/10/1814:01
 */
public class StringUtils {

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
