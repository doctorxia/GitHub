package com.road.httpclient.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtils {

	private static class JsonObjectMapper {
		private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	}

	public static String toJson(Object entity) throws Exception {
		ObjectMapper objectMapper = JsonObjectMapper.OBJECT_MAPPER;
		String json = objectMapper.writeValueAsString(entity);
		System.out.println("json: " + json);
		return json;
	}

	// public static String toXml(Object entity) {
	// ByteArrayOutputStream byteArrayOutputStream = null;
	// try {
	// JAXBContext context = JAXBContext.newInstance(entity.getClass());
	// byteArrayOutputStream = new ByteArrayOutputStream();
	// context.createMarshaller().marshal(entity, byteArrayOutputStream);
	// @SuppressWarnings("deprecation")
	// String xml = IOUtils.toString(byteArrayOutputStream.toByteArray(),
	// "UTF-8");
	// System.out.println("param entity: " + xml);
	// return xml;
	// } catch (Exception e) {
	// e.printStackTrace();
	// return null;
	// } finally {
	// IOUtils.closeQuietly(byteArrayOutputStream);
	// }
	// }

	public static <E> E jsonToObject(String json, Class<E> clazz) {
		try {
			return JsonObjectMapper.OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			return null;
		}
	}
}
