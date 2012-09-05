package jp.pilgrim_ericclapton.model.primitive.date;

import java.util.Date;

public class DataStampEmpty extends DateStamp
{

    public DataStampEmpty( Date date )
    {
        super( date );
    }

    public DataStampEmpty()
    {
    }

    @Override
    public boolean before( DateStamp dateStamp )
    {
        return false;
    }

    @Override
    public boolean isEmpty()
    {
        return true;
    }


}
