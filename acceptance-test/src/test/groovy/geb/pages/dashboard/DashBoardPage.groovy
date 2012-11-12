package geb.pages.dashboard

import geb.*

class DashBoardPage extends Page
{
    //static url = "http://176.32.89.89/web-basic_sample";
    static url = "http://localhost/web-basic_sample";
    static at = { $( 'body', id :'dashboard' )  }

    static content =
    {
        enterEventerLink { $( "div.well > a" ) }

        loginButton { $( "input#loginSubmit" ) }

        mailAddress { $( "input#loginEmail" ) }
        password{ $( "input#password" ) }

        loginUserName{ $( "div.well > p" ) }
        adminInfo{ $( "div.well > p > span" ) }

        logoutButton{ $( "a#logout" ) }

        loginFailureMessage{ $( "div.well > p.alert" ) }
    }
}
