package jp.pilgrim_ericclapton.model.primitive.date;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DateStamp
{
    @DateTimeFormat( pattern="yyyy/MM/dd" )
    private Date date;

    public DateStamp( Date date )
    {
        this.date = date;
    }

    public boolean before( DateStamp dateStamp )
    {
        return date.before( dateStamp.getDate() );
    }

    public Date getDate()
    {
        return date;
    }

}
