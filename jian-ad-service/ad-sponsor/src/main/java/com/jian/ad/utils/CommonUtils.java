package com.jian.ad.utils;

import com.jian.ad.exception.AdException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 *  公用工具包
 */
public class CommonUtils {

    //字符串格式定义
    private static String[] parsePatterns = {
        "yyyy-MM-dd" , "yyyy/MM/dd", "yyyy.MM.dd"
    };

    public  static  String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date parseStringDate(String dateString) throws AdException {
        try{
            return DateUtils.parseDate( dateString , parsePatterns);
        }catch (Exception ex){
            throw new AdException(ex.getMessage());
        }
    }

}
