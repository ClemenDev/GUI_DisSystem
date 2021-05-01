package pharmaApp2;

import io.grpc.stub.StreamObserver;
import pharmaApp2.Service2Grpc.Service2ImplBase;

public class PharmaApp2Impl extends Service2ImplBase{

	@Override
	public void arrivalTimeUpdate(TimeUpdateRequest request, StreamObserver<APIResponse> responseObserver) {
		
		//Implementation of ArrivalTimeUpdate should go below here (unable to fully comply with requirements)
		
	}
}
