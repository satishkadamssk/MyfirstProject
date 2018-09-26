package co.customer.info;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName="satish")
public interface CardProvider {

	@WebMethod(operationName = "getDisplay")
	public List<CardModel> getDisplay(String str);
}