/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.interceptors;

import com.example.beans.CustomerController;
import com.example.beans.PreferredCustomerController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author admin
 */
@Interceptor
@Logged
public class LogInterceptor {
    private static final Logger logger = Logger.getLogger("LogInterceptor");
    @Inject CustomerController cust;
    @Inject PreferredCustomerController prefcust;
            
    @AroundInvoke
public Object LogAction(InvocationContext context) throws Exception {
    String className = context.getMethod().getDeclaringClass().getName();
    String method = context.getMethod().getName();
   // logger.log(Level.INFO, "Executing method : {0} in class : {1}", new String[]{method, className});
    Object[] parameters = context.getParameters();
    // If the class is EmployeeEJB, these are the methods
    if(method.contains("saveCustomer")){
   if (className.contains("PreferredCustomerController")){
        logger.log(Level.INFO, "Saving Preferred Customer Details", new String[]{method, prefcust.toString()});
    }
    else {
        
             logger.log(Level.INFO, "Saving Customer Details", new String[]{method, cust.toString()});
             
    }
    
    }    
    return context.proceed();
} 
    
}
