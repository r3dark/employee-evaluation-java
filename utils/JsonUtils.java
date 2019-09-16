package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private ObjectMapper objectMapper = new ObjectMapper();

	public Object toObject(String json, Object object) throws Exception {
		return objectMapper.readValue(json, object.getClass());
	}

	public String toJson(Object object) throws Exception {
		return objectMapper.writeValueAsString(object);
	}

	public void printObjectAndJson(Object object) throws Exception {

		String json = toJson(object);
		System.out.println(json);
		object = toObject(json, object);
		System.out.println(object);
	}
}
