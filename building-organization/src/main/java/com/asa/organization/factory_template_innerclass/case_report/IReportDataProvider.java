package com.asa.organization.factory_template_innerclass.case_report;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 11:33 2019/5/7.
 */
public class IReportDataProvider {
    // TODO: 2019/5/9 整理模板和内部类的模式
    private List<ISheetDataProvider> sheetDataProviders = new ArrayList<>();

    public List<ISheetDataProvider> getSheetDataProviders() {
        return sheetDataProviders;
    }

}