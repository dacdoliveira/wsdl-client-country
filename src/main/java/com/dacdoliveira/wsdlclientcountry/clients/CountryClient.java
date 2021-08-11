package com.dacdoliveira.wsdlclientcountry.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.dacdoliveira.wsdlclientcountry.wsdl.GetCountryRequest;
import com.dacdoliveira.wsdlclientcountry.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport
{
    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountryResponse getCountry(String countryName)
    {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(countryName);
        log.info("find data about country {}", countryName);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:8080/ws/countries", request,
                new SoapActionCallback("http://dacdoliveira.com/wsdlservercountry/assets/GetCountryRequest"));
        return response;
    }
}
