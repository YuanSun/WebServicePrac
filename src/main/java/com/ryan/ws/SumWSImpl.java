package com.ryan.ws;

import com.ryan.ws.dto.SumRequest;
import com.ryan.ws.dto.SumResponse;

public class SumWSImpl implements SumWS {
    @Override
    public SumResponse calculateSum(SumRequest request) {
        int result = request.getNum1() + request.getNum2();
        SumResponse sumResponse = new SumResponse();
        sumResponse.setResult(result);
        return sumResponse;

    }
}
