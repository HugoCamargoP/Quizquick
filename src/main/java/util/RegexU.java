/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author root
 */
public class RegexU {
    public static boolean isValidMail (String input) {
        Pattern p = Pattern.compile("^[A-Za-z0-9[{punct}.][{punct}_][{punct}-]]+[{punct}@]{1}[A-Za-z0-9]+[{punct}.]{1}[A-Za-z0-9]+[[{punct}.]{1}[A-Za-z0-9]+]*");
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    public static boolean isValidNick (String input) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]{5,13}");
        Matcher m = p.matcher(input);
        return m.matches();
    }
    
    public static boolean isValidHash_1 (String input) {
        Pattern p = Pattern.compile("^[A-Za-z0-9]{40}");
        Matcher m = p.matcher(input);
        return m.matches();
    }
}
