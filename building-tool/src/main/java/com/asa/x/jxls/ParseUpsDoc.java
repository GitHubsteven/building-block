package com.asa.x.jxls;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 14:06 2019/4/17.
 */
public class ParseUpsDoc {
    private final static String path = "G:\\private-pro\\building-block\\building-tool\\src\\main\\resources\\com.asa-x.tool";
    private final static Set<Class<?>> classSet = new HashSet<>();
    public final static ObjectMapper mapper = new ObjectMapper();
    public final static List<ClzInfo> tmpClassList = new ArrayList<>();

    static {
        List<String> packageNames = new ArrayList<>();
        packageNames.add("com.asa.x.jxls");
        for (String packageName : packageNames) {
            classSet.addAll(ClassUtil.getClassSet(packageName));
        }
    }

    public static void main(String[] args) {
        String sampleXmlFileName = "UPSRateShipDoc.xml";
//        String targetXlsName = "target.xlsx";
        String template = "template.xlsx";
//        List<ClzInfo> clsInfoList = getClsInfoList(sampleXmlFileName, template);
//        System.out.println(clsInfoList.size());

        List<ClzInfo> clzInfos = listClzInfos("com.asa.x.jxls.model");
        System.out.println(clzInfos.size());

        // TODO: 2019/4/18 在生成class的过程中确定类型关系，存在已有的class，
    }

    /**
     * 获取包下的所有的类的信息
     *
     * @param packageName 包名
     * @return 包下类的信息
     */
    public static List<ClzInfo> listClzInfos(String packageName) {
        List<ClzInfo> clzInfos = new ArrayList<>();
        Set<Class<?>> classSet = ClassUtil.getClassSet(packageName);
        for (Class<?> clz : classSet) {
            int superDeep = 0;
            ClzInfo clzInfo = new ClzInfo();
            clzInfo.setName(clz.getName());
            List<FieldInfo> fieldInfos = new ArrayList<>();
            while (superDeep < 2 && clz != null && !clz.getSimpleName().equals("Object")) {
                for (Field field : clz.getDeclaredFields()) {
                    Class<?> type = field.getType();
                    FieldInfo fieldInfo = new FieldInfo(field.getName(), type.getSimpleName());
                    fieldInfos.add(fieldInfo);
                }
                clz = clz.getSuperclass();
                superDeep++;
            }
            clzInfo.setFields(fieldInfos);
            clzInfos.add(clzInfo);
        }
        return clzInfos;
    }


    private static List<ClzInfo> getClsInfoList(String sampleXmlFileName, String template) {
        ItemNode fieldNetRoot = getFieldNet(sampleXmlFileName, template);
        if (fieldNetRoot == null) throw new RuntimeException("成员根节点为空！");
        List<ClzInfo> clzInfos = new ArrayList<>();
        //根据节点网来生成class
        List<ItemNode> curNodes = fieldNetRoot.getSubNodes();
        while (CollectionUtils.isNotEmpty(curNodes)) {
            List<ItemNode> tmpNodes = new ArrayList<>();
            //对每个节点进行循环
            for (ItemNode node : curNodes) {
                List<ItemNode> subNodes = node.getSubNodes();
                if (CollectionUtils.isEmpty(subNodes)) continue;
                tmpNodes.addAll(subNodes);
                if (node.getCur().getConstraint().contains("Container")) {
                    //那么这个节点就是一个对象，而不是一个string字段
                    ClzInfo clzInfo = new ClzInfo();
                    clzInfo.setName(node.getCur().getFieldName());
                    List<FieldInfo> fieldInfos = node.getSubNodes().stream()
                            .map(sub -> {
                                String fieldName = sub.getCur().getFieldName();
                                String type = sub.getCur().getConstraint().contains("Container") ? fieldName : "String";
                                return new FieldInfo(fieldName, type, sub.getCur().getConstraint());
                            }).collect(Collectors.toList());
                    clzInfo.setFields(fieldInfos);
                    clzInfos.add(clzInfo);
                }
            }
            curNodes.clear();
            curNodes.addAll(tmpNodes);
            tmpNodes.clear();
        }
        return clzInfos;
    }

    private static ItemNode getFieldNet(String sampleXmlFileName, String template) {
        RequestBean request = parseDoc(sampleXmlFileName, template);
        if (request == null) {
            System.out.println("解析xlsx得到的结果为空！");
            return null;
        }
        List<ItemBean> items = request.getItems();
        if (CollectionUtils.isEmpty(items)) return null;
        System.out.println(String.format("有%d个属性需要处理", items.size()));
        ItemNode head = new ItemNode();
        head.setPath("head");
        for (ItemBean itemBean : items) {
            String fieldPath = itemBean.getFieldPath();
            String realPath = fieldPath.replaceAll("[{}”“]", "");
            System.out.println(String.format("原始fieldPath：%s,纯内容的fieldPath为：%s", fieldPath, realPath));
            String[] pathArr = realPath.split(":");
            if (pathArr.length == 0) throw new RuntimeException(String.format("按：分割path：%s失败！", realPath));
            ItemNode curNode = head;
            //遍历路径
            for (String path : pathArr) {
                if (StringUtils.isBlank(path)) continue;
                ItemNode subNode = curNode.getSubNodes().stream()
                        .filter(it -> it.getPath().equals(path))
                        .findFirst()
                        .orElse(null);
                //如果没有找到，那么新建一个
                if (subNode == null) {
                    ItemNode tmpNode = new ItemNode();
                    tmpNode.setPath(path);
                    tmpNode.setCur(itemBean);
                    curNode.getSubNodes().add(tmpNode);
                    curNode = tmpNode;
                } else {
                    curNode = subNode;
                }
            }
            //结束一个path
        }
        return head;
    }

    /**
     * @param sampleXmlFileName 对应的xml  UPSRateShipDoc.xml
     * @param targetXlsName     目标xls文件 target.xlsx
     * @return 属性类
     */
    private static RequestBean parseDoc(String sampleXmlFileName, String targetXlsName) {
        Path xmlRoot = Paths.get(ParseUpsDoc.path);
        xmlRoot.resolve(targetXlsName);
        try (
                InputStream resource = new FileInputStream(xmlRoot.resolve(sampleXmlFileName).toFile())) {
            InputStream inputXLS = Files.newInputStream(xmlRoot.resolve(targetXlsName));
            XLSReader mainReader = ReaderBuilder.buildFromXML(resource);
            Map<String, RequestBean> context = new HashMap<>();
            RequestBean request = new RequestBean();
            context.put("request", request);
            //xlxs文件映射到bean中
            XLSReadStatus readStatus = mainReader.read(inputXLS, context);
            if (!readStatus.isStatusOK()) {
                throw new RuntimeException("read fail");
            }
            request = context.get("request");
            return request;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}