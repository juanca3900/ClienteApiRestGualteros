package com.entregable.ClienteApiRest.models.converters;

import java.time.LocalDate;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)//permite conversion automatica
public class DateTypeConverter implements AttributeConverter<LocalDate, Long> {
    //convierte de tipo fecha a Long para base de datos (attributeConverter)
    @Override
    public Long convertToDatabaseColumn(LocalDate localDate) {
        return localDate.toEpochDay();
    }
    //convierte de Long (base de datos) a tipo fecha
    @Override
    public LocalDate convertToEntityAttribute(Long timestamp) {
        return LocalDate.ofEpochDay(timestamp);
    }
}
