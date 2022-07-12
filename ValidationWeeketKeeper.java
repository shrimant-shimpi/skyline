package testCases;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationWeeketKeeper
{

	@Test
	public void weecketKeeper() throws IOException, ParseException
	{

		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader(".\\JsonFile\\JsonSource.json");

		Object obj = parser.parse(reader);

		JSONObject rcbjsonobj = (JSONObject) obj;

		JSONArray array = (JSONArray) rcbjsonobj.get("player");

		int WicketKeeper = 0;

		for (int i = 0; i < array.size(); i++)
		{
			JSONObject player = (JSONObject) array.get(i);

			String role = (String) player.get("role");

			if (role.equalsIgnoreCase("Wicket-keeper"))
			{
				WicketKeeper++;

			}
		}
		System.out.println("there is " + WicketKeeper + " WicketKeeper");
		int expected = 1;
		Assert.assertEquals(expected, WicketKeeper);
	}

}