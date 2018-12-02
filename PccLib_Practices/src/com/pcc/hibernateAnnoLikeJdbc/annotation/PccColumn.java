package com.pcc.hibernateAnnoLikeJdbc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.pcc.hibernateAnnoLikeJdbc.enums.DatatypeEnum;;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PccColumn
{
    String name();
    
    DatatypeEnum datatype();
}
