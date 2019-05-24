package parser;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:20 2019/5/17.
 */
@Setter
@Getter
public class FieldInfo {
    private String access = "private";  //默认为private
    private String fieldName;
    private String type;
    private String comment;

    private List<FieldInfo> subClzFieldsIfExist; //如果类型是class的话，那么就存在
}