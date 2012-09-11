package geb.pages.event.register

import geb.Page

class RegisterPage extends Page
{
    static url = "http://localhost/web-basic_sample/event/new";    static at = { $( 'body', id :'eventer_register' )  }    static content =    {        eventname { $( "input#name") }        explanation { $( "textarea#eventDetail\\.content\\.explanation\\.explanation") }        dateOfDate { $( "input#eventDetail\\.content\\.dateOf\\.timeStampFormat\\.dateStamp\\.dateStamp") }        dateOfHour { $( "input#eventDetail\\.content\\.dateOf\\.timeStampFormat\\.hourMinute\\.hourMinute") }        headCount { $( "input#eventDetail\\.guideline\\.headCount\\.headCount") }        startDateDate { $( "input#eventDetail\\.guideline\\.period\\.startDate\\.timeStampFormat\\.dateStamp\\.dateStamp") }        startDateHour { $( "input#eventDetail\\.guideline\\.period\\.startDate\\.timeStampFormat\\.hourMinute\\.hourMinute") }        endDateDate { $( "input#eventDetail\\.guideline\\.period\\.endDate\\.timeStampFormat\\.dateStamp\\.dateStamp") }        endDateHour { $( "input#eventDetail\\.guideline\\.period\\.endDate\\.timeStampFormat\\.hourMinute\\.hourMinute") }        confirmButton { $( "input#confirm") }    }
}
