package formation.felix.tut1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class Activator implements BundleActivator , ServiceListener {

	/**
     * Implements ServiceListener.serviceChanged().
     * Prints the details of any service event from the framework.
     * @param event the fired service event.
    **/
	public void serviceChanged(ServiceEvent event) {
		String[] objectClass = (String[])
	            event.getServiceReference().getProperty("objectClass");

	        if (event.getType() == ServiceEvent.REGISTERED)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " registered.");
	        }
	        else if (event.getType() == ServiceEvent.UNREGISTERING)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " unregistered.");
	        }
	        else if (event.getType() == ServiceEvent.MODIFIED)
	        {
	            System.out.println(
	                "Ex1: Service of type " + objectClass[0] + " modified.");
	        }
		
	}
	
	 /**
     * Implements BundleActivator.start(). Prints
     * a message and adds itself to the bundle context as a service
     * listener.
     * @param context the framework context for the bundle.
    **/
	public void start(BundleContext context) throws Exception {
		 System.out.println("Starting to listen for service events.");
	     context.addServiceListener(this);
	}

	/**
     * Implements BundleActivator.stop(). Prints
     * a message and removes itself from the bundle context as a
     * service listener.
     * @param context the framework context for the bundle.
    **/
	public void stop(BundleContext context) throws Exception {
		
		context.removeServiceListener(this);
        System.out.println("Stopped listening for service events.");

        // Note: It is not required that we remove the listener here,
        // since the framework will do it automatically anyway.
		
	}

}