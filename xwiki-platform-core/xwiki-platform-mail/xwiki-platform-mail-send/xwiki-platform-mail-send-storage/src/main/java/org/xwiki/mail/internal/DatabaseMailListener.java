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
package org.xwiki.mail.internal;

import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.mail.internet.MimeMessage;

import org.xwiki.component.annotation.Component;
import org.xwiki.mail.MailListener;
import org.xwiki.mail.MailStatus;
import org.xwiki.mail.MailEventManager;

/**
 * @version $Id$
 * @since 6.4M2
 */
@Component
@Singleton
@Named("database")
public class DatabaseMailListener implements MailListener
{
    @Inject
    private MailEventManager mailEventManager;

    @Override
    public void onPrepare(MimeMessage message)
    {

    }

    @Override
    public void onSuccess(MimeMessage message)
    {
    }

    @Override
    public void onError(MimeMessage message, Exception e)
    {

    }

    @Override
    public Iterator<MailStatus> getErrors()
    {
        return null;
    }

    @Override
    public int getErrorsNumber()
    {
        return 0;
    }
}