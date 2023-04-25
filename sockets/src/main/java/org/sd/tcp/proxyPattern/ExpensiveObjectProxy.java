package org.sd.tcp.proxyPattern;

/**
 *
 * @author orlando
 */
public class ExpensiveObjectProxy implements ExpensiveObject {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObjectImpl();
        }
        object.process();
    }
    
    public static void main(String[] args) {
        ExpensiveObjectFactory factory = new ExpensiveObjectFactoryImpl();
        
        ExpensiveObject object = factory.getExpensiveObject();
        object.process();
        object.process();
    }
}
