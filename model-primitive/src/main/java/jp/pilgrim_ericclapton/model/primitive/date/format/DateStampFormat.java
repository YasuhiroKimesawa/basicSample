package jp.pilgrim_ericclapton.model.primitive.date.format;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateStampFormat
{
    private String dateStamp;

    public boolean isEmpty()
    {
        return dateStamp.isEmpty();
    }
}
