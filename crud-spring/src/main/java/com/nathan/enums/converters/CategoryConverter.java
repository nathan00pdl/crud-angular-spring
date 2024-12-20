package com.nathan.enums.converters;

import java.util.stream.Stream;

import com.nathan.enums.Category;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/*
 *AtributeConverter é uma interface do JPA responsável por:  
 *1)Salvar o ENUM no BD como uma string  
 *2)Recuperar tal string e converter para o ENUM correspondente 
 *obs: por padrão o JPA salva os ENUM como inteiros e isso pode causar problemas
 */

 //Este conversor será automaticamente aplicado para todas as entidades que utilizam o tipo Category
@Converter(autoApply = true) 
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getValue();
    }

    @Override
    public Category convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Category.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    //Category.values() retorna um array de todos os valores do ENUM:  
    //[Category.BACK_END, Category.FRONT_END]
}
