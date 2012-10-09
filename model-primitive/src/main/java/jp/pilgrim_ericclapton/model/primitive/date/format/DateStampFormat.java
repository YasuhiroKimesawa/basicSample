package jp.pilgrim_ericclapton.model.primitive.date.format;

import java.text.ParseException;

import jp.pilgrim_ericclapton.model.primitive.date.DateStamp;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateStampFormat
{
    private String dateStamp;

    public DateStampFormat( String dateStamp )
    {
        this.dateStamp = dateStamp;
    }

    public boolean isEmpty()
    {
        return dateStamp.isEmpty();
    }

    public boolean afterToday() throws ParseException
    {
        DateStamp date = DateStamp.create( this );

        return date.isAfterToday();
    }

    @Override
    public String toString()
    {
        return dateStamp;
    }
}
