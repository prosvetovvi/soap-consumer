package hello;

import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String name) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(name);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws",
                        request,
                        new SoapActionCallback("http:/localhost:8080/ws/getCountryRequest"));
    }

}
