package geb.pages.eventer.register

import geb.Page
import geb.*

class RegisterPage extends Page
{
    // static url = "http://176.32.89.89/web-basic_sample/eventers/new";
    static url = "http://localhost/web-basic_sample/eventers/new";
    static at = { $( 'body', id :'eventer_register' )  }
    static content =
    {
        // こんな書き方もＯＫ↓がこれらは遅い。
        // firstName { $( "input" , name: "applicant.profile.name.firstName") }
        // lastName { $("form#entryData").find( "input" , name: "applicant.profile.name.lastName") }
        lastName { $( "input#eventerDetail\\.personalInfomation\\.profile\\.personName\\.lastName") }
        firstName { $( "input#eventerDetail\\.personalInfomation\\.profile\\.personName\\.firstName") }
        mailAddress { $( "input#eventerDetail\\.personalInfomation\\.contact\\.mailAddress\\.mailAddress") }
        number { $( "input#eventerDetail\\.personalInfomation\\.contact\\.telephoneNumber\\.number") }
        password { $( "input#eventerDetail\\.passwords\\.password\\.password") }
        confirm { $( "input#eventerDetail\\.passwords\\.confirm\\.password") }

        errorMessages { $( 'p.error-message' ) }

        buttonConfirm { $( "input[type='submit']") }
    }
}
