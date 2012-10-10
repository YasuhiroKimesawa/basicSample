package jp.pilgrim_ericclapton.model.primitive.date;

import java.util.Date;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TimeStamp
{
    private Date date;

    public TimeStamp( Date date )
    {
        this.date = date;
    }

    public boolean before( TimeStamp timeStamp )
    {
        if( timeStamp.getClass() == TimeStampEmpty.class) return false;

        return date.before( timeStamp.date );
    }

    public Date toDate()
    {
        return date;
    }

}
