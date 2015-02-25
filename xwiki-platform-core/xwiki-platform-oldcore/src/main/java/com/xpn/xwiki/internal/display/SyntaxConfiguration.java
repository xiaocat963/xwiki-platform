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

import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.syntax.Syntax;
import org.xwiki.skin.SkinManager;

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

    /**
     * @return the HTML syntax to use according to the current skin
     */
    public Syntax getDefaultHTMLSyntax()
    {
        // The html syntax to use is defined on the "skin.properties" file of the current skin (or parent skin)
        return skinManager.getCurrentSkin(false).getHTMLRenderingSyntax();
    }
}
