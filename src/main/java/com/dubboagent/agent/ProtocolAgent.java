package com.dubboagent.agent;

import com.dubboagent.agent.premain.AgentPremain;
import com.dubboagent.interceptor.Interceptor;
import com.dubboagent.utils.extension.AgentExtensionLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.instrument.Instrumentation;

/**
 * Date:2017/11/28
 *
 * @author:chao.cheng
 **/
public class ProtocolAgent {

    private static Logger LOGGER = LoggerFactory.getLogger(DubboAgent.class);

    private static AgentPremain agentPremain = AgentExtensionLoader.getExtensionLoader(AgentPremain.class).loadSettingClass();

    public static void premain(String argument, Instrumentation inst) {
        AgentPremain agentPremain = AgentExtensionLoader.getExtensionLoader(AgentPremain.class).loadSettingClass();


        if(null == agentPremain) {
            LOGGER.info("[AgentPremain error] 无法正确加载 AgentPremain.class拦截器,项目将继续启动不影响业务进行!");
            return;
        }

        agentPremain.premain(argument, inst);


    }

}
