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
package org.xwiki.rendering.macro.equation;

import org.xwiki.component.annotation.ComponentRole;

/**
 * Configuration properties for the {@link org.xwiki.rendering.internal.macro.equation.EquationMacro equation macro}.
 * <p>
 * You can override the default values for each of the configuration properties below by defining them in XWiki's global
 * configuration file using a prefix of "macro.equation" followed by the property name. For example:
 * <code>macro.equation.renderer = mathtran</code>
 * 
 * @version $Id$
 * @since 2.0M3
 */
@ComponentRole
public interface EquationMacroConfiguration
{
    /**
     * The hint of the {@link org.xwiki.equation.EquationRenderer} component implementation to use for rendering math
     * expressions into images.
     * 
     * @return the configured hint, for example {@code "native"} or {@code "snuggletex"}
     */
    String getRenderer();

    /**
     * The hint of {@link org.xwiki.equation.EquationRenderer} component implementation that is considered to be "safe",
     * meaning that it should always be available and always work, even if the quality of the resulting image is not the
     * best.
     * 
     * @return the hint of the "safe" renderer
     */
    String getSafeRenderer();
}
