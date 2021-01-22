package util;


/**
 * @author rongbin.xie
 * @version 1.0.0
 * @date 2021/1/15
 * @description 生成规则： req:"1" + db:"1"
 * @copyright COPYRIGHT © 2014 - 2021 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 **/
public enum CompareTypeEnum implements ObjEnum<String> {

    /**
     * 请求参数中存在，但是db中不存在
     */
    REQ_BUT_DB("10"),
    /**
     * db中存在，但是请求参数不存在
     */
    DB_BUT_REQ("01"),
    /**
     * 两者皆存在
     */
    BOTH_EXIST("11");


    private String value;

    CompareTypeEnum(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    public CompareTypeEnum fromValueNotNull(String val) {
        final CompareTypeEnum result = ObjEnum.forEnum(CompareTypeEnum.values(), val);
        if (result == null) {
            final String message = "get CompareTypeEnum failed from value: " + val;
            throw new RuntimeException(message);
        }
        return result;
    }


}
