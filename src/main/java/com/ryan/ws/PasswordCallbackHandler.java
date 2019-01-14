package com.ryan.ws;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PasswordCallbackHandler implements CallbackHandler {

    Map<String, String> passwords = new HashMap<>();

    public PasswordCallbackHandler() {

        // In the reality, the password is extracted from some db or ldap server
        passwords.put("sumuser", "sumpass");
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (Callback callback: callbacks) {
            WSPasswordCallback wsPasswordCallback = (WSPasswordCallback) callback;
            String password = passwords.get(wsPasswordCallback.getIdentifier());
            wsPasswordCallback.setPassword(password);
            return;
        }
    }
}
