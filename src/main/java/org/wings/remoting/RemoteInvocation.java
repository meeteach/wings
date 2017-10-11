package org.wings.remoting;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class RemoteInvocation implements Serializable {
    
    private static final long serialVersionUID = 4171405572547848461L;
    
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] arguments;
    private Map<String, Object> attributes;
    
    public RemoteInvocation() {
        
    }
    
    public RemoteInvocation(String methodName, Class<?>[] parameterTypes, Object[] arguments) {
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.arguments = arguments;
    }
    
    public String getMethodName() {
        return methodName;
    }

    
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    
    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    
    public Object[] getArguments() {
        return arguments;
    }

    
    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public void setAttribute(String name, Object value) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        attributes.put(name, value);
    }
    
    public void setAttributeIfAbsent(String name, Object value) {
        if(attributes == null) {
            attributes = new HashMap<>();
        }
        if (!attributes.containsKey(name)) {
            attributes.put(name, value);
        }
    }
    
    public Object getAttribute(String name) {
        if (attributes == null) {
            return null;
        }
        return attributes.get(name);
    }
    
    public Object removeAttribute(String name) {
        if (attributes == null) {
            return null;
        }
        return attributes.remove(name);
    }
    
    public boolean hasAttribute(String name) {
        if (attributes == null) {
            return false;
        }
        return attributes.containsKey(name);
    }
    
    public String[] getAttributeNames() {
        if (attributes == null) {
            return null;
        }
        return attributes.keySet().toArray(new String[attributes.size()]);
    }
}
