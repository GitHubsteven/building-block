package com.variety.shop.utils;//package com.Utils;
//
///**
// * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
// * @Author rongbin.xie
// * @Description:
// * @Date: Created at 19:10 2018/4/11.
// */
//
//public finalcase class ChineseHelper {
//
//    public static void main(String[] args) {
//        System.out.println("'简单'的繁体是：" + SimToTra("简单"));
//        System.out.println("'簡單'的简体是：" + TraToSim("簡單"));
//        System.out.println("'我真的爱你！'的繁体是：" + SimToTra("我真的爱你！陈巧娟"));
//    }
//
//    /**
//     * 简体转繁体
//     *
//     * @param simpStr
//     *            简体字符串
//     * @return 繁体字符串
//     */
//    public static String SimToTra(String simpStr) {
//        ZHConverter converter = ZHConverter
//                .getInstance(ZHConverter.TRADITIONAL);
//        String traditionalStr = converter.convert(simpStr);
//        return traditionalStr;
//    }
//
//    /**
//     * 繁体转简体
//     *
//     * @param tradStr
//     *            繁体字符串
//     * @return 简体字符串
//     */
//    public static String TraToSim(String tradStr) {
//        ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
//        String simplifiedStr = converter.convert("間單");
//        return simplifiedStr;
//    }
//}
//
