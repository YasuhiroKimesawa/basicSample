package geb.pages.eventer

import geb.Page
import geb.*

class ConfirmPage extends Page
{
    static url = "http://176.32.89.89/web-basic_sample/eventers/new?draft=yes";
    static at = { $( 'body', id :'eventer_register_confirm' )  }

    static content =
    {
        buttonRegister { $( "input[type='submit']", value : '登録' ) }
        buttonModify { $( "input[type='submit']" , value : '修正') }
    }
}
