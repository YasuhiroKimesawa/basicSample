package jp.pilgrim_ericclapton.model.primitive.date.format;

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

    @Override
    public String toString()
    {
        return dateStamp;
    }
}
