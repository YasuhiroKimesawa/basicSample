package jp.pilgrim_ericclapton.model.primitive.date;

public class DateStampEmpty extends DateStamp
{
    @Override
    public boolean afterToday()
    {
        return false;
    }

}
