package pharmaApp1;

import javax.jmdns.ServiceInfo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import pharmaApp1.PharmaApp1Grpc.Service1BlockingStub;

public class PharmaApp1Client {

	public static void main(String[] args) {
		
		ServiceInfo serviceInfo;
		String service_type = "_http._tpc.local.";
		serviceInfo = PharmaApp1ServiceDiscovery.run(service_type);
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",50051).usePlaintext().build();
		
		Service1BlockingStub userStub = PharmaApp1Grpc.newBlockingStub(channel);
		
		LoginRequest loginrequest = LoginRequest.newBuilder().setUserName("JOSE2021").setPassword("MALAKI").build();
		
		APIResponse response = userStub.login(loginrequest);
		
		System.out.println(response.getResponseMessage());
		
	}

}
