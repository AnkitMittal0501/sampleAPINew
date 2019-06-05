package org.sample.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class FetchResponse {
	public static List<HashMap<String, String>> list;
	public static HashMap<String, Object> jsonObjects;
	public static JSONObject json;

	public static List listOfheader;

	public static List getResponse(CloseableHttpResponse response) {
		try {
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			String res = EntityUtils.toString(response.getEntity(), "UTF-8");
			System.out.println(res);
			json = new JSONObject(res);
			//Object jsonToken = new JSONTokener(res).nextValue();
			System.out.println(json);
			jsonObjects = new HashMap<String, Object>();
			Iterator itr = json.keys();
			while (itr.hasNext()) {
				String it = itr.next().toString();
				if (json.get(it) instanceof JSONArray) {

					JSONArray jArray = new JSONArray(json.get(it).toString());
					System.out.println(jArray);
					HashMap<String, String> map = new HashMap<String, String>();
					list = new ArrayList<HashMap<String, String>>();

					JSONObject jsonArrayObj = null;
					for (int i = 0; i < jArray.length(); i++) {
						jsonArrayObj = jArray.getJSONObject(i);
						Set<String> setOfKeys = jsonArrayObj.keySet();
						for (String key : setOfKeys) {

							map.put(key, jsonArrayObj.get(key).toString());

						}

						list.add(map);
					}
					System.out.println("Json Array Parsing in HashMap " + list);

				} else {

					jsonObjects.put(it, json.get(it));
				}
			}
			System.out.println(jsonObjects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(response.getLastHeader("content/type"));
		System.out.println(response.getAllHeaders().toString());
		listOfheader = new ArrayList();
		for (Header header : response.getAllHeaders()) {
			System.out.println(header.toString());
			listOfheader.add(header.toString());
		}
		List l = new ArrayList();
		l.add(list);
		l.add(jsonObjects);
		l.add(listOfheader);
		return l;
	}
}
