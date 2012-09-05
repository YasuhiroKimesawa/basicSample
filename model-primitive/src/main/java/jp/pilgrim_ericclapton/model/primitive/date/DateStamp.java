package jp.pilgrim_ericclapton.model.primitive.date;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
public class DateStamp
{
    @DateTimeFormat( pattern="yyyy/MM/dd" )
    private Date date;

    public DateStamp( Date date )
    {
        this.date = date;
    }

    public String asText()
    {
        return DateFormatUtils.format( date, "yyyy/MM/dd" );
    }

    public boolean before( DateStamp dateStamp )
    {
        return date.before( dateStamp.date );
    }

    public boolean isEmpty()
    {
        return false;
    }

}
