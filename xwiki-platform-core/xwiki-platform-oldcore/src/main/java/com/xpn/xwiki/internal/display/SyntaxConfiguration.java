/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.xpn.xwiki.internal.display;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.parser.ParseException;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.rendering.syntax.SyntaxFactory;

import com.xpn.xwiki.internal.skin.EnvironmentSkin;
import com.xpn.xwiki.internal.skin.ResourceRepository;
import com.xpn.xwiki.internal.skin.SkinManager;

/**
 * Component to get the configuration of the syntaxes to use for the display.
 *
 * @version $Id$
 * @since 6.4
 */
@Component(roles = SyntaxConfiguration.class)
@Singleton
public class SyntaxConfiguration
{
    @Inject
    private SkinManager skinManager;

    @Inject
    private SyntaxFactory syntaxFactory;

    @Inject
    private Logger logger;

    /**
     * @return the HTML syntax to use according to the current skin
     */
    public Syntax getDefaultHTMLSyntax()
    {
        // The html syntax to use is defined on the "skin.properties" file of the current skin (or parent skin)
        ResourceRepository skin = skinManager.getCurrentSkin(false);
        // Get a parent skin which is on the FS
        while (skin != null && !(skin instanceof EnvironmentSkin)) {
            skin = skin.getParent();
        }
        // Fallback to the legacy syntax if the parent skin is still not a skin on the FS
        if (!(skin instanceof EnvironmentSkin)) {
            return Syntax.XHTML_1_0;
        }
        // Now we have a skin on the FS, we can load its properties
        EnvironmentSkin environmentSkin = (EnvironmentSkin) skin;
        String syntax = environmentSkin.getProperties().getString("html.syntax", "xhtml/1.0");
        try {
            return syntaxFactory.createSyntaxFromIdString(syntax);
        } catch (ParseException e) {
            logger.warn("Failed to parse the syntax [{}] configured by the skin [{}]. Fallback to XHTML 1.0 instead.",
                syntax, skin.getId());
            return Syntax.XHTML_1_0;
        }
    }
}
