package jp.pilgrim_ericclapton.model.primitive.date;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class HourAndMinute
{
    @DateTimeFormat( pattern="HH:mm" )
    private Date date;

    public HourAndMinute( Date date )
    {
        this.date = date;
    }

    public String asText()
    {
        return DateFormatUtils.format( date, "HH:mm" );
    }

}
