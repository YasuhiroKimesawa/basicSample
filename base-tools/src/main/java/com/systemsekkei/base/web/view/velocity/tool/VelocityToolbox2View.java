package com.systemsekkei.base.web.view.velocity.tool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.config.ConfigurationUtils;
import org.apache.velocity.tools.config.FactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.apache.velocity.tools.view.ViewToolManager;
import org.springframework.web.servlet.view.velocity.VelocityToolboxView;

import com.systemsekkei.base.exception.SystemException;

public class VelocityToolbox2View extends VelocityToolboxView {
    
    @Override
    protected Context createVelocityContext(
            Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {

        // autoConfigをtrueにするとバグと思われる現象が発生するためfalseに設定する
        ViewToolManager viewToolManager
            = new ViewToolManager(getServletContext(), false, true);
        viewToolManager.setVelocityEngine(getVelocityEngine());

        viewToolManager.configure(getFactoryConfiguration());

        ViewToolContext viewToolContext = viewToolManager.createContext(request, response);
        viewToolContext.putAll(model);
        
        return viewToolContext;
    }

    private FactoryConfiguration getFactoryConfiguration()
    {
        String[] pathes = getToolboxConfigLocation().split( "," );
        FactoryConfiguration toolbokConfiguration = new FactoryConfiguration();
        for (String path : pathes)
        {
            String trimedPath = path.trim(); // 改行、スペースを削除
            FactoryConfiguration configuration = ConfigurationUtils.find( trimedPath );
            if (configuration == null)
            {
                throw new SystemException("VelocityTools configuration not found :" + trimedPath);
            }
            toolbokConfiguration.addConfiguration( configuration );
        }

        return toolbokConfiguration;
    }
}
