package de.iu.mtshopbackend.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class HttpEnvironment {
    @Autowired
    private HttpServletRequest request;

    public String getBaseUrl() {
        try {
            URL url = new URL(request.getRequestURL().toString());
            String protocol = url.getProtocol();
            String host = url.getHost();
            return protocol + "://" + host;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return "";
    }
}
