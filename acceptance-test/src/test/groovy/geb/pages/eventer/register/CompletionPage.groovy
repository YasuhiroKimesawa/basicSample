package geb.pages.eventer.register

import geb.Page
import geb.*

class CompletionPage extends Page
{
    static url = "http://176.32.89.89/web-basic_sample/eventers/new?draft=no";
    static at = { $( 'body', id :'eventer_register_completion' )  }
}
