package com.justin.ssm.utils;

import com.justin.ssm.service.IClientManageService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component
@Transactional(readOnly = true)
public class ContextListener implements ApplicationListener<ContextRefreshedEvent> {

    @Resource
    private IClientManageService clientManangeService;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            this.clientManangeService.synRegisteredApplication();
        }
    }
}
