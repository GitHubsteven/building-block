package xstream.generic.xstream.custom.doc;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.Calendar;

/**
 * @author: jet.xie
 * @Date: 2018/9/26
 * @Description:
 * @version: 1.0.0
 */
public class BirthdayConverter implements Converter {
    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext context) {
        Birthday birthday = (Birthday) value;
        if (birthday.getGender() != '\0') {
            writer.addAttribute("gender", Character.toString(birthday.getGender()));
        }
        if (birthday.getPerson() != null) {
            writer.startNode("person");
            context.convertAnother(birthday.getPerson());
            writer.endNode();
        }
        if (birthday.getDate() != null) {
            writer.startNode("birth");
            context.convertAnother(birthday.getDate());
            writer.endNode();
        }
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Birthday birthday = new Birthday();
        String gender = reader.getAttribute("gender");
        if (gender != null) {
            if (gender.length() > 0) {
                if (gender.charAt(0) == 'f') {
                    birthday.setGenderFemale();
                } else if (gender.charAt(0) == 'm') {
                    birthday.setGenderMale();
                } else {
                    throw new ConversionException("Invalid gender value: " + gender);
                }
            } else {
                throw new ConversionException("Empty string is invalid gender value");
            }
        }
        while (reader.hasMoreChildren()) {
            reader.moveDown();
            if ("person".equals(reader.getNodeName())) {
                Person person = (Person) context.convertAnother(birthday, Person.class);
            } else if ("birth".equals(reader.getNodeName())) {
                Calendar date = (Calendar) context.convertAnother(birthday, Calendar.class);
                birthday.setDate(date);
            }
            reader.moveUp();
        }
        return birthday;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return Birthday.class == aClass;
    }
}