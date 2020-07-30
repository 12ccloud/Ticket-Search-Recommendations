package rpc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import entity.Item;
import entity.Item.ItemBuilder;

public class RpcHelperTest {

	@Test
	public void testGetJSONArray() throws JSONException {
		List<Item> listItem = new ArrayList<Item>();
		Set<String> category = new HashSet<String>();
		category.add("category one");
		ItemBuilder builder = new ItemBuilder();
		
		builder.setName("one");
		builder.setAddress("111street");
		builder.setCategories(category);
		Item one = builder.build();
		listItem.add(one);
		

		ItemBuilder builder2 = new ItemBuilder();
		
		builder2.setName("two");
		builder2.setAddress("222street");
		builder2.setCategories(category);
		Item two = builder2.build();
		listItem.add(two);
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.put(one.toJSONObject());
		jsonArray.put(two.toJSONObject());
		
		JSONAssert.assertEquals(jsonArray, RpcHelper.getJSONArray(listItem), true);
	}
}


