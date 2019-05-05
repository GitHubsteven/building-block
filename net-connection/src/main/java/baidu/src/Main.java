package baidu.src;


import baidu.src.com.baidu.translate.demo.TransApi;

public class Main {

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "";
    private static final String SECURITY_KEY = "";

    public static void main(String[] args) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);

        String query = "高度600米 \n" +
                "宽度400米";
        System.out.println(api.getTransResult(query, "auto", "auto"));
    }

}
