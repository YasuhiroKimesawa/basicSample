package com.systemsekkei.base.utils;

import org.apache.commons.beanutils.PropertyUtils;

import com.systemsekkei.base.exception.SystemException;

public class BeanUtils
{
    private BeanUtils()
    {}

    public static void copyProperty(
        Object target, Object source, String propertyName)
    {
        Object sourceValue = getProperty( source, propertyName );
        setProperty(target, propertyName, sourceValue);
    }

    public static void copyProperties(
        Object target, Object source, String[] propertyNames)
    {
        for (String propertyName : propertyNames)
        {
            copyProperty( target, source, propertyName );
        }
    }

    public static Object getProperty(Object object, String propertyName)
    {
        Object value = null;
        try {
            value = PropertyUtils.getProperty( object, propertyName );
        } catch (Exception e) {
            throw new SystemException(
                "Can't get property[" + propertyName + "] from " + object, e);
        }
        return value;
    }

    public static void setProperty(Object object, String propertyName, Object value)
    {
        try {
            PropertyUtils.setProperty( object, propertyName, value );
        } catch (Exception e) {
            throw new SystemException(
                "Can't set property[" + propertyName + "] to " + object, e);
        }
    }
}
