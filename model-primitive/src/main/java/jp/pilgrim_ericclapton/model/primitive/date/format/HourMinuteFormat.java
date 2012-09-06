package jp.pilgrim_ericclapton.model.primitive.date.format;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HourMinuteFormat
{
    private String hourMinute;

    public boolean isEmpty()
    {
        return hourMinute.isEmpty();
    }
}
