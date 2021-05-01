package pharmaApp2;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import pharmaApp1.PharmaApp1Impl;
import pharmaApp1.PharmaApp1ServiceRegistration;
import pharmaApp2.Service2Grpc.Service2ImplBase;

public class PharmaApp2Server extends Service2ImplBase{

public static void main(String[] args) throws IOException, InterruptedException {
		
		PharmaApp2Impl pharmaApp2Impl = new PharmaApp2Impl();

		int port = 50052;
		String service_type = "_http._tpc.local.";
		String service_name = "GrpcPharmaApp2";
		
		PharmaApp2ServiceRegistration ssr2 = new PharmaApp2ServiceRegistration();
		ssr2.run(port, service_type, service_name);
		
		Server server = ServerBuilder.forPort(port)
				.addService(pharmaApp2Impl)
				.build()
				.start();
		
		System.out.println("PharmaApp2 server started and listening on port " + server.getPort());
		
		server.awaitTermination();
	}
}
