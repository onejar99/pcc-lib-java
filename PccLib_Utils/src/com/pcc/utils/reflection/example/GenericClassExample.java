package com.pcc.utils.reflection.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.pcc.utils.reflection.ReflectionUtil;

public class GenericClassExample {
	public static void main(String[] args) {
		GoogleService google = new GoogleService();
		FacebookService fb = new FacebookService();
		google.loggingReqAndRespType(); // REQ Class=[com.pcc.utils.reflection.example.GoogleRequest] RES Class=[com.pcc.utils.reflection.example.GoogleResponse]
		fb.loggingReqAndRespType(); // REQ Class=[com.pcc.utils.reflection.example.FacebookRequest] RES Class=[com.pcc.utils.reflection.example.FacebookResponse]
	}
}

/**
 * Base Service/Request/Response stub
 */
abstract class BaseService<REQ extends BaseRequest, RESP extends BaseResponse> {
	private Log logger;

	public BaseService() {
		logger = LogFactory.getLog(this.getClass());
	}

	public void loggingReqAndRespType() {
		try {
			Class<?> reqClazz = ReflectionUtil.getGenericClassByIndex(this, 0);
			Class<?> resClazz = ReflectionUtil.getGenericClassByIndex(this, 1);
			logger.info(String.format("REQ Class=[%s] RES Class=[%s]", reqClazz.getName(), resClazz.getName()));
		} catch (Exception e) {
			logger.error("Out of boundary size:", e);
		}
	}
}

abstract class BaseRequest {
}

abstract class BaseResponse {
}

/**
 * Google Service/Request/Response stub
 */
class GoogleService extends BaseService<GoogleRequest, GoogleResponse> {
}

class GoogleRequest extends BaseRequest {
}

class GoogleResponse extends BaseResponse {
}

/**
 * Facebook Service/Request/Response stub
 */
class FacebookService extends BaseService<FacebookRequest, FacebookResponse> {
}

class FacebookRequest extends BaseRequest {
}

class FacebookResponse extends BaseResponse {
}
