package com.arvatosystems.t9t.tfi.web.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import com.arvatosystems.t9t.tfi.viewmodel.LoginHelper;
import com.arvatosystems.t9t.base.T9tConstants;

/**
 * AuthenticationFilter.
 *
 * @author INCI02
 *
 */
public class AuthenticationFilter extends FormAuthenticationFilter {
    /**
     * @param request ServletRequest
     * @param ae AuthenticationException
     */
    @Override
    protected final void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        String message = ae.getMessage();
        request.setAttribute(getFailureKeyAttribute(), message);
    }

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        LoginHelper.logRequestInfo(request);
        String username = null;
        String password = null;
        HttpServletRequest req = WebUtils.toHttp(request);
        String additionalParam = req.getParameter(LoginHelper.ADDITIONAL_PARAM);



        String sslClientSdn = LoginHelper.getSubjectDNHeader(request);
        if ((sslClientSdn != null) && (null != additionalParam) && LoginHelper.TOKEN_BUTTON.equals(additionalParam)) {
            username = sslClientSdn;
            password = T9tConstants.ANONYMOUS_USER_ID;
        } else {
            username = getUsername(request);
            password = getPassword(request);
        }
        return createToken(username, password, request, response);
    }
}
