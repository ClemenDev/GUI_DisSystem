package pharmaApp2;

import javax.jmdns.ServiceInfo;

public class PharmaApp2Client {
	
	public static void main(String[] args) {
		
		ServiceInfo serviceInfo;
		String service_type = "_http._tpc.local.";
		serviceInfo = PharmaApp2ServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
	}
	
	//Implementation of ArrivalTimeUpdate should go below here (unable to fully comply with requirements)
	
	/*
	 * public static void ArrivalTimeUpdate() { // TimeUpdateRequest request =
	 * TimeUpdateRequest.newBuilder()
	 * 
	 * 
	 * try { //Iterator<APIResponse> responses =
	 * blockingStub.arrivalTimeUpdate(request);
	 * 
	 * while(responces.hasNext()) { APIResponse temp = responses.next();
	 * System.out.println(temp.getNumber()); }
	 * 
	 * } catch (StatusRuntimeException e) { e.printStackTrace(); }
	 * 
	 * }
	 * 
	 * 
	**/
}
