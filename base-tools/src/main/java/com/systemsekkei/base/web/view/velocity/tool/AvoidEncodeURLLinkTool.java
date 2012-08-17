package com.systemsekkei.base.web.view.velocity.tool;

import java.net.URI;

import org.apache.velocity.tools.view.LinkTool;

public class AvoidEncodeURLLinkTool extends LinkTool
{
    // from generic.LinkTools
    private String createURIString()
    {
        URI uri = createURI();
        if (uri == null)
        {
            return null;
        }
        if (query != null)
        {
            return decodeQueryPercents(uri.toString());
        }
        return uri.toString();
    }

    @Override
    public String toString()
    {
        return createURIString();
    }
}
