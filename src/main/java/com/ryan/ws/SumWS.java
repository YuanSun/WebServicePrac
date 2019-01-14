package com.ryan.ws;

import com.ryan.ws.dto.SumRequest;
import com.ryan.ws.dto.SumResponse;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(name="SumWs")
public interface SumWS {

    // @webResult and @WebParam are optional. The key is to annotate @WebService
    @WebResult(name="response") SumResponse calculateSum(@WebParam SumRequest request);
}
