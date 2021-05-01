package pharmaApp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class PharmaApp3ServiceRegistration {
	
	public void run(int port, String service_type, String service_name) {

		try {
			
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//Service information						
			int service_port = port;
			String service_desc = "Integration of jmDNS for Service PharmaApp2";
				
			//Create ServiceInfo		
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
			
			//Register the service
			jmdns.registerService(serviceInfo);
			
			System.out.printf("Registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
			
			//Sleep for 10 seconds
			Thread.sleep(10000);
			System.out.println("\nService Registered");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
