package base.greendao;

import org.greenrobot.greendao.converter.PropertyConverter;

public class TypeConverter implements PropertyConverter<Types, String> {
    @Override
    public Types convertToEntityProperty(String databaseValue) {
        return Types.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(Types entityProperty) {
        return entityProperty.name();
    }
}
