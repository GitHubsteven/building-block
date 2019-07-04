package com.variety.shop.indi.design.pattern.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rongbin.xie on 2017/10/16.
 */
public class getColumnName {
    public static void main(String[] args) {
        Map<String,String> data =new HashMap<>();
        data.put("name","jack");
        data.put("age","12");
        data.put("sex","Female");
        data.put("EX","rose");
        data.put("ex-age","11");




        String[] singleMan = {"name","age","sex"};
        String[] noSingMan = {"name","age","sex","EX","ex-age"};
    }
    /**场景
     *
     * // 初始化待插入列表
     List<WmsMtSkuMappingModel> skuMappingModelList = new ArrayList<WmsMtSkuMappingModel>();
     int total = 0;   // 总记录数
     int exist = 0;   // 已存在记录数
     int update = 0;  // 更新记录数
     int success = 0; // 导入成功记录数
     int invalid = 0; // 无效行数：code/size/upc其中一项为空就无效
     while (csvReader.readRecord()) {
     total++;
     String code = "";
     String sku = "";
     String upc = "";
     String size = "";

     // 根据供应商读取 code sku upc
     if (WmsConstant.SneakerheadSupplier.ADIDAS.value().equals(supplier)) {
     code = StringUtils.trimToEmpty(csvReader.get("Material #"));
     size = StringUtils.trimToEmpty(csvReader.get("Size"));
     // 阿迪达斯，4-表示4.5，此处转化一下
     if (size.endsWith("-")) {
     int index = size.lastIndexOf("-");
     size = size.substring(0, index) + ".5";
     }
     sku = code + "-" + size;
     upc = StringUtils.trimToEmpty(csvReader.get("UPC"));
     } else if (WmsConstant.SneakerheadSupplier.NIKE.value().equals(supplier)) {
     code = StringUtils.trimToEmpty(csvReader.get("Style Number-Color Code"));
     size = StringUtils.trimToEmpty(csvReader.get("Size ID"));
     sku = code + "-" + size;
     upc = StringUtils.trimToEmpty(csvReader.get("UPC"));
     } else if (WmsConstant.SneakerheadSupplier.NEWBALANCE.value().equals(supplier)) {
     code = StringUtils.trimToEmpty(csvReader.get("StyleNo"));
     size = StringUtils.trimToEmpty(csvReader.get("Size"));
     int len = size.length();
     if (len > 2) {
     size = size.substring(0, 2) + "." + size.substring(2);
     } else if (len == 2) {
     // 如果原始size两位数，则最大15，超过15中间加. 比如45再次处理成4.5
     if (StringUtils.isNumeric(size)) {
     int intSize = Integer.valueOf(size).intValue();
     if (intSize > 15) {
     size = String.valueOf(intSize / 10) + "." + String.valueOf(intSize % 10);
     }
     }
     }
     sku = code + "-" + size;
     upc = StringUtils.trimToEmpty(csvReader.get("EAN/UPC"));
     } else if (WmsConstant.SneakerheadSupplier.REEBOK.value().equals(supplier)) {
     code = StringUtils.trimToEmpty(csvReader.get("Material #"));
     size = StringUtils.trimToEmpty(csvReader.get("Size"));
     sku = code + "-" + size;
     upc = StringUtils.trimToEmpty(csvReader.get("UPC"));
     }
     // 无效，直接跳过
     if ("".equals(code) || "".equals(size) || "".equals(upc)) {
     invalid++;
     continue;
     }

     // 是否已经存在，如果存在直接跳过
     WmsMtSkuMappingModel targetSkuMapping = this.getSkuMappingByCodeSku(channelId, code, sku);
     if (targetSkuMapping != null) {
     if (upc.equals(targetSkuMapping.getBarcode())) {
     exist++;
     } else {
     WmsMtSkuMappingModel updateSkuMapping = new WmsMtSkuMappingModel();
     updateSkuMapping.setId(targetSkuMapping.getId());
     updateSkuMapping.setBarcode(upc);
     updateSkuMapping.setModifier(userName);
     int affected = wmsMtSkuMappingDao.update(updateSkuMapping);
     if (affected <= 0) {
     $error("{}更新品牌方UPC扩展记录(channelId={}, code={}, sku={}, barcode={}->{})失败，受影响行数({})",
     userName, channelId, code, sku, targetSkuMapping.getBarcode(), upc);
     throw new CodeException(CodeConstant.Common.UPDATE_ERROR);
     }
     update++;
     }
     continue;
     }

     // 初始化一条UPC记录
     WmsMtSkuMappingModel skuMappingModel = new WmsMtSkuMappingModel();
     skuMappingModel.setChannelId(channelId);
     skuMappingModel.setProductCode(code);
     skuMappingModel.setSku(sku);
     skuMappingModel.setBarcode(upc);
     skuMappingModel.setCreater(userName);
     skuMappingModel.setModifier(userName);
     skuMappingModel.setActive(Boolean.TRUE);
     skuMappingModelList.add(skuMappingModel);
     }
     *
     *
     *
     *
     *优化以上代码
     *
     */

    /**
     * 数据来源不定，不定，但是可以被认为Map<String,String>
     *     总共有四种情况：nike,addi,new balance,reebok
     *     共享所有的属性，或者说是一个属性
     *     但是属性值随着鞋的品牌而变化
     *     我们可以写如上的代码
     *     用if-else 来实现
     *     我们也可以用switch-case
     *     那么，我们改用什么设计模式呢？
     *
     *
     *
     */







}
