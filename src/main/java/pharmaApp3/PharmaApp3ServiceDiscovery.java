package pharmaApp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class PharmaApp3ServiceDiscovery {

	private int port;
	private String host;
	
	//Service discovery implementation
	public static class MyServiceListener implements ServiceListener{

		private int port;
		private String host;
		private ServiceInfo serviceInfo;
		
		public void serviceAdded(ServiceEvent event) {
			
			System.out.println("\nService Added " + event.getInfo());
		}

		public void serviceRemoved(ServiceEvent event) {

			System.out.println("Service Removed " + event.getInfo());
		}

		public void serviceResolved(ServiceEvent event) {
		
			System.out.println("Service Resolved " + event.getInfo());
			
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			System.out.println("Host " + serviceInfo.getHostAddress());
			//this.setHost(serviceInfo.getHostAddress());
			System.out.println("Port " + serviceInfo.getPort());
			this.setPort(serviceInfo.getPort());
			System.out.println("Type " + serviceInfo.getType());
			System.out.println("Name " + serviceInfo.getName());
			System.out.println("Computername " + serviceInfo.getServer());
			System.out.println("Properties " + serviceInfo.getNiceTextString());
			
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}

		public ServiceInfo getServiceInfo() {
			return serviceInfo;
		}

		public void setServiceInfo(ServiceInfo serviceInfo) {
			this.serviceInfo = serviceInfo;
		}
		
	}

	public static ServiceInfo run(String service_type) {
		
		int port = 0;
		ServiceInfo serviceInfo = null;
				
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			MyServiceListener msl = new MyServiceListener();		
			jmdns.addServiceListener(service_type, msl);
			
			//Sleep for 10 seconds
			Thread.sleep(10000);
			
			serviceInfo = msl.getServiceInfo();
			port = msl.getPort();
			System.out.println("This is the port retreived from jmDNS: " + port);
			
			jmdns.close();
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		return serviceInfo;

	}
}
