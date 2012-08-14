package geb.pages.dashboard

import geb.*

class DashBoardPage extends Page
{
    static url = "http://localhost/web-basic_sample";
    static at = { $( 'body', id :'dashboard' )  }

    static content =
    {
        enterEventerLink { $( 'div.well > a' ) }
    }
}
