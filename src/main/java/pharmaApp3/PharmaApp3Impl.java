package pharmaApp3;

import io.grpc.stub.StreamObserver;
import pharmaApp3.Service3Grpc.Service3ImplBase;

public class PharmaApp3Impl extends Service3ImplBase {

	@Override
	public StreamObserver<OrderRequest> orderRequest(StreamObserver<APIResponse> responseObserver) {
		return super.orderRequest(responseObserver);
		
		//Implementation of orderRequest should go below here (unable to comply with requirements)
	}
}
