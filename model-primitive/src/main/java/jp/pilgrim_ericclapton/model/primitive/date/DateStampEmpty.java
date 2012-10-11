package jp.pilgrim_ericclapton.model.primitive.date;

import jp.pilgrim_ericclapton.model.primitive.date.format.DateStampFormat;

public class DateStampEmpty extends DateStamp
{
    @Override
    public DateStamp plus( int amount )
    {
        return this;
    }

    @Override
    public DateStamp minus( int amount )
    {
        return this;
    }

    @Override
    public DateStampFormat toFormat()
    {
        return new DateStampFormat( "" );
    }

    @Override
    public boolean isAfterToday()
    {
        return false;
    }

}
