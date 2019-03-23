package br.edu.saojudas.redesocial.domain.web;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("UsuarioLogado") == null)
                response.sendRedirect("login");

        return true;
    }

}//não ta funcionando shalom
// deixa eu fazer um test ok
