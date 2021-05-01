package pharmaApp3;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import pharmaApp3.Service3Grpc.Service3ImplBase;

public class PharmaApp3Server extends Service3ImplBase{

	public static void main(String[] args) throws IOException, InterruptedException {
		
		PharmaApp3Impl pharmaApp3Impl = new PharmaApp3Impl();

		int port = 50053;
		String service_type = "_http._tpc.local.";
		String service_name = "GrpcPharmaApp3";
		
		PharmaApp3ServiceRegistration ssr2 = new PharmaApp3ServiceRegistration();
		ssr2.run(port, service_type, service_name);
		
		Server server = ServerBuilder.forPort(port)
				.addService(pharmaApp3Impl)
				.build()
				.start();
		
		System.out.println("PharmaApp3 server started and listening on port " + server.getPort());
		
		server.awaitTermination();
	}
}
