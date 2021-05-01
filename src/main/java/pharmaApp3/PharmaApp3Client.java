package pharmaApp3;

import javax.jmdns.ServiceInfo;

public class PharmaApp3Client {

	public static void main(String[] args) {
		ServiceInfo serviceInfo;
		String service_type = "_http._tpc.local.";
		serviceInfo = PharmaApp3ServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";	
	}
	
	//Implementation of orderRequest should go below here (unable to comply with requirements)
	
}
