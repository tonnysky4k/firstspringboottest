package com.tonny.first.utils;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TonnyLocalResolver implements LocaleResolver {
    private static final  String  I18N_lanugage ="i18n_language";
    private static final String N18N_language_seesion="i18n_language_session";
    @Override
    public Locale resolveLocale(HttpServletRequest req)
    {
        String il8n_language =req.getParameter(I18N_lanugage);
        Locale locale= Locale.getDefault();
        if(!StringUtils.isEmpty(il8n_language))
        {
            String [] language =il8n_language.split("_");
            locale = new Locale(language[0],language[1]);
            HttpSession session = req.getSession();
            session.setAttribute(I18N_lanugage,locale);
        }else
        {
            HttpSession session =req.getSession();
            Locale localeSession =(Locale) session.getAttribute(N18N_language_seesion);
            if (localeSession!=null)
                locale =localeSession;
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest req, HttpServletResponse res, Locale locale) {

    }
}
