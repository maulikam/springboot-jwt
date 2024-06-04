package com.example.config.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.security.web.access.channel.ChannelDecisionManagerImpl;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.access.channel.SecureChannelProcessor;

import java.io.IOException;
import java.util.Collections;

// this filter is used to filter requests that contains secured connections
public class CustomChannelProcessingFilter  extends ChannelProcessingFilter {

    public CustomChannelProcessingFilter() {
        ChannelDecisionManagerImpl channelDecisionManager = new ChannelDecisionManagerImpl();
        channelDecisionManager.setChannelProcessors(Collections.singletonList(new SecureChannelProcessor()));

        this.setChannelDecisionManager(channelDecisionManager);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        super.doFilter(req, res, chain);
    }
}
