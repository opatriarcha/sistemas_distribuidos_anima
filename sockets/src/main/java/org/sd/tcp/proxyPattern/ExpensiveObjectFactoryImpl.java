package org.sd.tcp.proxyPattern;

/**
 *
 * @author orlando
 */
public class ExpensiveObjectFactoryImpl implements ExpensiveObjectFactory{

    @Override
    public ExpensiveObject getExpensiveObject() {
        return new ExpensiveObjectProxy();
    }
    
}
