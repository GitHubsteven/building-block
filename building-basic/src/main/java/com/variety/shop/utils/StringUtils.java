//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.variety.shop.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    private static final Pattern special_symbol = Pattern.compile("[.]");
    public static final String LineSeparator = "\r\n";

    public StringUtils() {
    }

    public static String null2Space(String input) {
        return input == null ? "" : input;
    }

    public static String null2Space2(String input) {
        return input == null ? "" : ("null".equalsIgnoreCase(input) ? "" : input);
    }

    public static boolean isEmpty(String chkParam) {
        return chkParam == null || chkParam.length() == 0;
    }

    public static boolean isDigit(String chkParam) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher match = pattern.matcher(chkParam);
        return match.matches();
    }

    public static boolean isNumeric(String chkParam) {
        boolean ret = true;

        try {
            Float.valueOf(chkParam);
        } catch (Exception var3) {
            ret = false;
        }

        return ret;
    }

    public static boolean isNullOrBlank2(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    public static String strAdd(String chr, int len) {
        if (len <= 0) {
            return "";
        } else {
            StringBuilder ret = new StringBuilder(len);

            for (int i = 0; i < len; ++i) {
                ret.append(chr);
            }

            return ret.toString();
        }
    }

    public static String lPad(String source, String chr, int len) {
        int lenleft = len - source.length();
        if (lenleft < 0) {
            lenleft = 0;
        }

        return strAdd(chr, lenleft) + source;
    }

    public static String rPad(String source, String chr, int len) {
        int lenleft = len - source.length();
        if (lenleft < 0) {
            lenleft = 0;
        }

        return source + strAdd(chr, lenleft);
    }

    public static int getByteLength(String content, String charsetName) {
        int byteLength = 0;

        try {
            byte[] byteContent = content.getBytes(charsetName);
            byteLength = byteContent.length;
        } catch (Exception var4) {
            ;
        }

        return byteLength;
    }

    public static String trimImgElement(String content) {
        String ret = content;

        for (int imgBeginIndex = content.indexOf("<img"); imgBeginIndex != -1; imgBeginIndex = ret.indexOf("<img")) {
            int imgEndIndex = ret.indexOf(">", imgBeginIndex);
            if (imgEndIndex == -1) {
                break;
            }

            ++imgEndIndex;
            ret = ret.substring(0, imgBeginIndex) + ret.substring(imgEndIndex, ret.length());
        }

        return ret;
    }

    public static String replaceDot(String str) {
        return special_symbol.matcher(str).replaceAll("->");
    }

    public static String replaceToDot(String str) {
        return str.replaceAll("->", ".");
    }

    public static String format(String msg, String... params) {
        if (params != null && params.length != 0) {
            String msgTmp = msg;
            int i = 0;

            for (int lens = params.length; i < lens; ++i) {
                msgTmp = replace(msgTmp, "{" + i + "}", params[i]);
            }

            return msgTmp;
        } else {
            return msg;
        }
    }

    public static String replace(String val, String find, String rep) {
        if (val != null && !"".equals(val)) {
            StringBuilder ret = new StringBuilder();
            int end = val.indexOf(find);

            int start;
            for (start = 0; end >= 0; end = val.indexOf(find, start)) {
                ret.append(val.substring(start, end));
                ret.append(rep);
                start = end + find.length();
            }

            ret.append(val.substring(start));
            return ret.toString();
        } else {
            return "";
        }
    }

    public static String replaceBlankToDash(String val) {
        return val != null && !"".equals(val) ? val.trim().replaceAll("  ", " ").replaceAll(" ", "-") : "";
    }

    public static int toIntValue(Integer val) {
        return val == null ? 0 : val.intValue();
    }

    public static int toIntValue(Object val) {
        if (val == null) {
            return -1;
        } else if (val instanceof Integer) {
            return ((Integer) val).intValue();
        } else if (val instanceof String) {
            String strVal = (String) val;
            return "".equals(strVal) ? -1 : Integer.valueOf(strVal);
        } else {
            return -1;
        }
    }

    public static String toString(Object val) {
        return val == null ? "" : val.toString();
    }
}
