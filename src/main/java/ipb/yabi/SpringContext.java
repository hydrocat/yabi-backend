/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipb.yabi;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author hydrocat
 */
public class SpringContext implements ApplicationContextAware{

    private static ApplicationContext ap;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ap = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext() {
        return ap;
    }
    
}
