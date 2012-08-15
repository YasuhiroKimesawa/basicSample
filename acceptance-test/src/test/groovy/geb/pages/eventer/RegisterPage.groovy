package geb.pages.eventer

import geb.Page
import geb.*

class RegisterPage extends Page
{
    static url = "http://localhost/web-basic_sample/eventers/new";
    static at = { $( 'body', id :'eventer_register' )  }
    static content =
    {
        // こんな書き方もＯＫ↓がこれらは遅い。
        // firstName { $( "input" , name: "applicant.profile.name.firstName") }
        // lastName { $("form#entryData").find( "input" , name: "applicant.profile.name.lastName") }
        lastName { $( "input#profile\\.personName\\.lastName") }
        firstName { $( "input#profile\\.personName\\.firstName") }
        mailAddress { $( "input#contact\\.mailAddress\\.mailAddress") }
        number { $( "input#contact\\.telephoneNumber\\.number") }
        password { $( "input#passwords\\.password\\.password") }
        confirm { $( "input#passwords\\.confirm\\.password") }

        errorMessages { $( 'p.error-message' ) }

        buttonConfirm { $( "input[type='submit']") }
    }
}