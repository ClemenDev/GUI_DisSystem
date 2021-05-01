package pharmaApp1;

import io.grpc.stub.StreamObserver;
import pharmaApp1.PharmaApp1Grpc.Service1ImplBase;

public class PharmaApp1Impl extends Service1ImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		
		String username = request.getUserName();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
		if(username.equals("JOSE2021") && (password.equals("MALAKI"))){
			
			response.setResponseCode(0).setResponseMessage("WELL DONE, PASSWORD SUCCESSFUL");
		}else {
			
			response.setResponseCode(100).setResponseMessage("SORRY, INVALID PASSWORD");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
}
