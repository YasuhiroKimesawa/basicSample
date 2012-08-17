package com.systemsekkei.base.web.view.velocity.tool;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.SkipSetters;
import org.apache.velocity.tools.config.ValidScope;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.util.JavaScriptUtils;

@DefaultKey("esc")
@SkipSetters
@ValidScope(Scope.APPLICATION)
public class EscapeTool
{
    public String html(Object value)
    {
        String stringValue = String.valueOf( value );
        return HtmlUtils.htmlEscape( stringValue );
    }

    public String javascript(Object value)
    {
        String stringValue = String.valueOf( value );
        return JavaScriptUtils.javaScriptEscape(stringValue);
    }
}
