package com.estraMyPime.backend.Model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeUserConverter implements AttributeConverter<TypeUser, String> {

    @Override
    public String convertToDatabaseColumn(TypeUser typeUser) {
        if (typeUser == null) {
            return null;
        }
        return typeUser.toString();
    }

    @Override
    public TypeUser convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return TypeUser.valueOf(dbData.toLowerCase());
    }
}

