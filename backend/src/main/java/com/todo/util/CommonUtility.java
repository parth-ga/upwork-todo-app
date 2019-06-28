package com.todo.util;

import java.util.HashMap;
import java.util.Map;

import com.todo.common.Constant;
import com.todo.exception.ErrorCodes;

public class CommonUtility {

	private CommonUtility() {

	}

	public static Map<String, Object> prepareResponse(Object responseObj) {
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put(Constant.RETURN_DATA, responseObj);
		responseMap.put(Constant.RESPONSE_MESSAGE, ErrorCodes.TRANSACTION_OK.getDescription());
		responseMap.put(Constant.RESPONSE_CODE, 200);
		return responseMap;
	}

}
