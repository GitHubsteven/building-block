package bean.response;

import java.io.Serializable;

// FIXME generate failure  field _$Data243

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/14
 * @Time: 12:14
 * @Description:
 * @version: 1.0.0
 */
public abstract class AbstractResponse implements Serializable {

    /**
     * date : 20180814
     * message : Success !
     * status : 200
     * city : 上海
     * count : 1
     * data : {"shidu":"83%","pm25":9,"pm10":27,"quality":"优","wendu":"29","ganmao":"各类人群可自由活动","yesterday":{"date":"13日星期一","sunrise":"05:17","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"18:40","aqi":30,"fx":"东南风","fl":"4-5级","type":"阴","notice":"不要被阴云遮挡住好心情"},"forecast":[{"date":"14日星期二","sunrise":"05:18","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"18:39","aqi":25,"fx":"东南风","fl":"5-6级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"15日星期三","sunrise":"05:18","high":"高温 34.0℃","low":"低温 27.0℃","sunset":"18:38","aqi":29,"fx":"东北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"16日星期四","sunrise":"05:19","high":"高温 32.0℃","low":"低温 27.0℃","sunset":"18:37","aqi":27,"fx":"东北风","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"17日星期五","sunrise":"05:20","high":"高温 33.0℃","low":"低温 27.0℃","sunset":"18:36","aqi":31,"fx":"东北风","fl":"4-5级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"18日星期六","sunrise":"05:20","high":"高温 31.0℃","low":"低温 27.0℃","sunset":"18:35","aqi":37,"fx":"东风","fl":"3-4级","type":"中雨","notice":"记得随身携带雨伞哦"}]}
     */

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;

    public static class DataBean implements Serializable {
        /**
         * shidu : 83%
         * pm25 : 9
         * pm10 : 27
         * quality : 优
         * wendu : 29
         * ganmao : 各类人群可自由活动
         * yesterday : {"date":"13日星期一","sunrise":"05:17","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"18:40","aqi":30,"fx":"东南风","fl":"4-5级","type":"阴","notice":"不要被阴云遮挡住好心情"}
         * forecast : [{"date":"14日星期二","sunrise":"05:18","high":"高温 33.0℃","low":"低温 28.0℃","sunset":"18:39","aqi":25,"fx":"东南风","fl":"5-6级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"15日星期三","sunrise":"05:18","high":"高温 34.0℃","low":"低温 27.0℃","sunset":"18:38","aqi":29,"fx":"东北风","fl":"3-4级","type":"多云","notice":"阴晴之间，谨防紫外线侵扰"},{"date":"16日星期四","sunrise":"05:19","high":"高温 32.0℃","low":"低温 27.0℃","sunset":"18:37","aqi":27,"fx":"东北风","fl":"<3级","type":"阵雨","notice":"阵雨来袭，出门记得带伞"},{"date":"17日星期五","sunrise":"05:20","high":"高温 33.0℃","low":"低温 27.0℃","sunset":"18:36","aqi":31,"fx":"东北风","fl":"4-5级","type":"小雨","notice":"雨虽小，注意保暖别感冒"},{"date":"18日星期六","sunrise":"05:20","high":"高温 31.0℃","low":"低温 27.0℃","sunset":"18:35","aqi":37,"fx":"东风","fl":"3-4级","type":"中雨","notice":"记得随身携带雨伞哦"}]
         */

        private String shidu;
        private int pm25;
        private int pm10;
        private String quality;
        private String wendu;
        private String ganmao;

        public String getShidu() {
            return shidu;
        }

        public void setShidu(String shidu) {
            this.shidu = shidu;
        }

        public int getPm25() {
            return pm25;
        }

        public void setPm25(int pm25) {
            this.pm25 = pm25;
        }

        public int getPm10() {
            return pm10;
        }

        public void setPm10(int pm10) {
            this.pm10 = pm10;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public static class YesterdayBean implements Serializable {
            /**
             * date : 13日星期一
             * sunrise : 05:17
             * high : 高温 33.0℃
             * low : 低温 28.0℃
             * sunset : 18:40
             * aqi : 30
             * fx : 东南风
             * fl : 4-5级
             * type : 阴
             * notice : 不要被阴云遮挡住好心情
             */

            private String date;
            private String sunrise;
            private String high;
            private String low;
            private String sunset;
            private int aqi;
            private String fx;
            private String fl;
            private String type;
            private String notice;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getSunrise() {
                return sunrise;
            }

            public void setSunrise(String sunrise) {
                this.sunrise = sunrise;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getSunset() {
                return sunset;
            }

            public void setSunset(String sunset) {
                this.sunset = sunset;
            }

            public int getAqi() {
                return aqi;
            }

            public void setAqi(int aqi) {
                this.aqi = aqi;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getNotice() {
                return notice;
            }

            public void setNotice(String notice) {
                this.notice = notice;
            }
        }
    }
}