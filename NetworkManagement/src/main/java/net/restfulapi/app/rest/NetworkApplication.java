package net.restfulapi.app.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import net.restfulapi.app.rest.service.ConfigurationResource;

@ApplicationPath("/network-management")
public class NetworkApplication extends Application {

   private Set<Object> singletons = new HashSet<Object>();
   private Set<Class<?>> empty = new HashSet<Class<?>>();

   public NetworkApplication() {
      singletons.add(new ConfigurationResource());
   }

   @Override
   public Set<Class<?>> getClasses() {
      return empty;
   }

   @Override
   public Set<Object> getSingletons() {
      return singletons;
   }
}
