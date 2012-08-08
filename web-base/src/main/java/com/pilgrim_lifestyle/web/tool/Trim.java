package com.pilgrim_lifestyle.web.tool;

public class Trim
{
    public static String trim( String string )
    {
        return string.trim().replaceAll("^[\\s　]*", "").replaceAll("[\\s　]*$", "");
    }
}
