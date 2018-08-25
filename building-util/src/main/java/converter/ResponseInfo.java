package converter;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: jet.xie
 * @Date: 2018/8/24
 * @Time: 16:26
 * @Description:
 * @version: 1.0.0
 */
public class ResponseInfo {
    private String success;
    private String errorCode;
    private String errorMsg;
    private ItemListInfo itemList;
    public static class ItemListInfo {
        private ItemInfo item;
        public static class ItemInfo {
            private String itemId;
            private String itemCode;
            private String itemFlag;
            private String version;
            private String itemName;
            private String itemTitle;
            private String productCode;
            private String providerTpId;
            private String attributes;
            private String remarks;
            private String barCode;
            private String type;
            private String brand;
            private String brandName;
            private String specification;
            private String color;
            private String size;
            private String approvalNumber;
            private String grossWeight;
            private String netWeight;
            private String length;
            private String width;
            private String height;
            private String volume;
            private String pcs;
            private String isShelflife;
            private String lifecycle;
            private String rejectLifecycle;
            private String lockupLifecycle;
            private String adventLifecycle;
            private String isSnMgt;
            private String isHygroscopic;
            private String isDanger;
            private String isBatchMgt;
            private String snInMode;
            private String snOutMode;
            private String snMode;
            private String packagingScheme;
            private String isProduceCodeMgt;
            private String extendFields;
            private String cartonLength;
            private String cartonWidth;
            private String cartonHeight;
            private String cartonWeight;
            private String cartonVolume;
            private String isPoMgt;
            private String isPrecious;
            private String temperatureRequirement;
            private String dosageForms;
            private String producingArea;
            private String manufacturer;
            private String classification;
            private String firstState;
            private String isImported;
            private String isDrugs;
            private String category;
            private String categoryName;
            private String unit;
            private String includeBattery;
            private String packageUnit;
            private String materialGroup;
            private String materialClass;
            private SnSampleListInfo snSampleList;
            public static class SnSampleListInfo {
                private SnSampleInfo snSample;
                public static class SnSampleInfo {
                    private String sampleSeq;
                    private String sampleDesc;
                    private SampleRuleListInfo sampleRuleList;
                    public static class SampleRuleListInfo {
                        private SampleRuleInfo sampleRule;
                        public static class SampleRuleInfo {
                            private String ruleDesc;
                            private String ruleRegularExpression;
                            private String ruleImgUrl;
                            private String ruleSample;
                        }
                    }
                }
            }
            private String grayFlag;
        }
    }
}