package com.demo.asa.building.reflect.type;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author asa.x
 * @Date: Created at 19:24 2020/3/10.
 */
public class GetOrderRequest extends BaseRequest<GetOrderResponse> {
    BaseRequest<GetOrderResponse> request = null;

    public static void main(String[] args) throws NoSuchFieldException, IOException, ClassNotFoundException {
//        parameterizedDirectly();
        inheritParameterizedType();
    }

    /**
     * direct parameterizedType
     *
     * @throws NoSuchFieldException
     */
    private static void parameterizedDirectly() throws NoSuchFieldException {
        Field fieldRequest = GetOrderRequest.class.getDeclaredField("request");
        Type type = fieldRequest.getGenericType();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        System.out.println(parameterizedType.getRawType().getTypeName());

        for (Type argType : parameterizedType.getActualTypeArguments()) {
            System.out.println(argType.getTypeName());
        }
    }

    /**
     * get when class inherit a parameterizedType and try to deserialize json.
     *
     * @throws ClassNotFoundException
     * @throws IOException
     */
    private static void inheritParameterizedType() throws ClassNotFoundException, IOException {
        Type superClzType = GetOrderRequest.class.getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) superClzType;
        System.out.println(parameterizedType.getRawType().getTypeName());
        for (Type argType : parameterizedType.getActualTypeArguments()) {
            System.out.println(argType.getTypeName());
        }

        Class<?> responseClz = GetOrderRequest.class.getClassLoader().loadClass(parameterizedType.getActualTypeArguments()[0].getTypeName());
        ObjectMapper objectMapper = new ObjectMapper();
        GetOrderResponse response = new GetOrderResponse();
        response.setName("name");
        response.setAge(1);
        GetOrderResponse res = (GetOrderResponse) objectMapper.readValue(objectMapper.writeValueAsString(response), responseClz);
        System.out.println(res);

    }
}