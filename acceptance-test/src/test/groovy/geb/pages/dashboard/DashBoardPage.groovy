package geb.pages.dashboard

import geb.*

class DashBoardPage extends Page
{
    static url = "http://176.32.89.89/web-basic_sample";
    static at = { $( 'body', id :'dashboard' )  }

    static content =
    {
        enterEventerLink { $( 'div.well > a' ) }
    }
}
