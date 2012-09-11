package jp.pilgrim_ericclapton.model.primitive.date;

public class TimeStampEmpty extends TimeStamp
{
    @Override
    public boolean before( TimeStamp timeStamp )
    {
        return false;
    }


}
