package geb.pages.dashboard

import geb.Page
import geb.*

class DashBoardPage extends Page
{
    static url = "http://localhost/web-basic_sample";
    static at = { $( 'body', id :'eventer_register' )  }

    static content = {
        button( to: GoogleResultsPage ) {
            enterEventer { $( "a", value: buttonValue ) }
        }
    }
}
