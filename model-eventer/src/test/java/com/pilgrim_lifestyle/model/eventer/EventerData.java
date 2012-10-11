package com.pilgrim_lifestyle.model.eventer;

import java.util.EnumMap;

public class EventerData
{
    public static enum Data
    {
        ID
        , 姓
        , 名
        , メールアドレス
        , 電話番号
        , パスワード
        , 確認パスワード
    }

    private EnumMap<Data, String> data = new EnumMap<Data, String>( Data.class );

    public EventerData()
    {
        data.put( Data.ID, "1" );
        data.put( Data.姓, "田中" );
        data.put( Data.メールアドレス, "t.tanaka@urawareds.com" );
        data.put( Data.パスワード, "urawa" );
        data.put( Data.電話番号, "090-1111-2222" );
        data.put( Data.確認パスワード, "urawa" );
    }

    public EnumMap<Data, String> getData()
    {
        return data;
    }
}