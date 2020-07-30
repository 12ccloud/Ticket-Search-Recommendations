package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import entity.Item;

public class RpcHelper {
	// Write a JSONArray to http response.
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws 
	IOException {
		response.setContentType("application/json");
		response.getWriter().print(array);
	}
	
	// Write a JSONObject to http response.
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws 
	IOException {
		response.setContentType("application/json");
		response.getWriter().print(obj);
		
	}
	// Parses a JSONObject from http request.
	public static JSONObject readJSONObject(HttpServletRequest request) {
		StringBuilder sBuilder = new StringBuilder();
		try (BufferedReader reader = request.getReader()) {
			String line = null;
			while((line = reader.readLine()) != null) {
				sBuilder.append(line);
			}
			return new JSONObject(sBuilder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new JSONObject();
	}
	
	 // Converts a list of Item objects to JSONArray.
	// To do a RpcHelperTest

	public static JSONArray getJSONArray(List<Item> listItem) {
		 JSONArray result = new JSONArray();
		    try {
		      for (Item item : listItem) {
		        result.put(item.toJSONObject());
		      }
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return result;
		  }
	}



