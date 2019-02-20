package xstream.generic.custom.characteristic;

import com.thoughtworks.xstream.converters.reflection.FieldKey;
import com.thoughtworks.xstream.converters.reflection.FieldKeySorter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2018 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Author jet.xie
 * @Description:
 * @Date: Created at 19:28 2019/2/20.
 */
public class SequenceFieldKeySorter implements FieldKeySorter {
    @Override
    public Map sort(final Class type, final Map keyedByFieldKey) {
        Annotation sequence = type.getAnnotation(XMLSequence.class);
        if (sequence != null) {
            final String[] fieldsOrder = ((XMLSequence) sequence).value();
            Map result = new LinkedHashMap();
            Set<Map.Entry<FieldKey, Field>> fields = keyedByFieldKey.entrySet();
            for (String fieldName : fieldsOrder) {
                if (fieldName != null) {
                    for (Map.Entry<FieldKey, Field> fieldEntry : fields) {
                        if
                                (fieldName.equals(fieldEntry.getKey().getFieldName())) {
                            result.put(fieldEntry.getKey(),
                                    fieldEntry.getValue());
                        }
                    }
                }
            }
            return result;
        } else {
            return keyedByFieldKey;
        }
    }


}