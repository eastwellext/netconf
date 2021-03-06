/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.netconf.nettyutil.handler.ssh.authentication;

import java.io.IOException;
import org.opendaylight.netconf.shaded.sshd.client.future.AuthFuture;
import org.opendaylight.netconf.shaded.sshd.client.session.ClientSession;

/**
 * Class Providing username/password authentication option to
 * {@link org.opendaylight.netconf.nettyutil.handler.ssh.client.AsyncSshHandler}.
 */
public class LoginPasswordHandler extends AuthenticationHandler {
    protected final String username;
    protected final String password;

    public LoginPasswordHandler(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public AuthFuture authenticate(final ClientSession session) throws IOException {
        session.addPasswordIdentity(password);
        return session.auth();
    }
}
