package geb.pages.eventer

import geb.Page
import geb.*

class CompletionPage extends Page
{
    static url = "http://localhost/web-basic_sample/eventers/new?draft=no";
    static at = { $( 'body', id :'eventer_register_completion' )  }
}
