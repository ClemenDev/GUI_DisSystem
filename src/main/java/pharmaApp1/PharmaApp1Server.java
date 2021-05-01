package pharmaApp1;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class PharmaApp1Server {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		PharmaApp1Impl pharmaApp1Impl = new PharmaApp1Impl();

		int port = 50051;
		String service_type = "_http._tpc.local.";
		String service_name = "GrpcPharmaApp1";
		
		PharmaApp1ServiceRegistration ssr2 = new PharmaApp1ServiceRegistration();
		ssr2.run(port, service_type, service_name);
		
		Server server = ServerBuilder.forPort(port)
				.addService(pharmaApp1Impl)
				.build()
				.start();
		
		System.out.println("PharmaApp1 server started and listening on port " + server.getPort());
		
		server.awaitTermination();
	}
}

