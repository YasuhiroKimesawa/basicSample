package geb.pages.eventer

import geb.Page
import geb.*

class ConfirmPage extends Page
{
    static url = "http://localhost/web-basic_sample/eventers/new?draft=yes";
    static at = { $( 'body', id :'eventer_register_confirm' )  }
}
