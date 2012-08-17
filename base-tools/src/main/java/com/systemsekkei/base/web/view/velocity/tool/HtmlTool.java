package com.systemsekkei.base.web.view.velocity.tool;

import org.apache.velocity.tools.Scope;
import org.apache.velocity.tools.config.DefaultKey;
import org.apache.velocity.tools.config.SkipSetters;
import org.apache.velocity.tools.config.ValidScope;

@DefaultKey("html")
@SkipSetters
@ValidScope(Scope.APPLICATION)
public class HtmlTool
{
    public String anchorPhone(String str)
    {
        if (str != null)
        {
            String regex = "([\\d]{2,5}-[\\d]{2,4}-[\\d]{3,4})";
            return str.replaceAll(regex, "<a href=\"tel:$1\">$1</a>");
        }
        return null;
    }
    
    public String anchorEmail(String str)
    {
        if (str != null)
        {
            String regex = "([\\w]+[\\w\\._-]*@[\\w_-]+[\\w\\._-]+)";
            return str.replaceAll(regex, "<a href=\"mailto:$1\">$1</a>");
        }
        return null;
    }
    
    public String anchorUrl(String str)
    {
        if (str != null)
        {
            String regex = "((http://|https://){1}[\\w\\(\\)\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+)";
            return str.replaceAll(regex, "<a href=\"$1\">$1</a>");
        }
        return null;
    }
}
