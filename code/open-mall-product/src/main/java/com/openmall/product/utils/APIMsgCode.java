package com.openmall.product.utils;

/**
 * 服务请求状态API枚举
 * @author model-driven
 * @date 2020-01-24
 **/
public enum APIMsgCode {

	SUCCESS("200", "成功"),
	FAILURE("300", "失败"),
	BAD_REQUEST("400", "错误请求，参数不正确"),
	UNAUTHORIZED("401", "无权限请求,请联系管理员授权"),
	CONFLICT("409", "主键重复"),
	EXCEPTION("500", "服务器异常");

	private String code;

	private String value;

	APIMsgCode(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public static APIMsgCode getEmByCode(String code) {
		for (APIMsgCode em : APIMsgCode.values()) {
			if (em.getCode().equals(code)) {
				return em;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
