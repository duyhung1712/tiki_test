import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.*;

public class main {
	static ArrayList<Product> products;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "bin\\db.txt";
		File file = new File(fileName);
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String content = "";
		try {
			String line;
			while((line = br.readLine()) != null){
			    //process the line
			    content += line + "\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject result = null;
		JSONParser parser = new JSONParser();
		try {
			result = (JSONObject) parser.parse(content);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		products = new ArrayList<>();
		//get data from Json file
		JSONArray jsonArray = (JSONArray) result.get("product");
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArray.get(i);
			long id = (long) jsonObject.get("id");
			String name = (String) jsonObject.get("name");
			String color = (String) jsonObject.get("color");
			String storage = (String) jsonObject.get("storage");
			long sale_price = (long) jsonObject.get("sale_price");
			long market_price = (long) jsonObject.get("market_price");
			String origin = (String) jsonObject.get("origin");
			String description = (String) jsonObject.get("description");
			String factory_date = (String) jsonObject.get("factory_date");
			double d_weight = (double) jsonObject.get("weight");
			float weight = (float) d_weight;
			ArrayList<String> photo_link = new ArrayList<>();
			JSONArray photo_array = (JSONArray) jsonObject.get("link");
			for(int j = 0; j < photo_array.size(); j++)
			{
				photo_link.add((String) photo_array.get(j));
			}
			Product p = new Product(id, name, color, storage, sale_price, market_price, photo_link, description, origin, Timestamp.valueOf(factory_date), weight);
			products.add(p);
		}
		
		JSONArray jsonArrayCombo = (JSONArray) result.get("combo");
		for (int i = 0; i < jsonArrayCombo.size(); i++) {
			JSONObject jsonObject = (JSONObject) jsonArrayCombo.get(i);
			String name = (String) jsonObject.get("name");
			System.out.println(name);
			JSONArray product_array = (JSONArray) jsonObject.get("products");
			for(int j = 0; j < product_array.size(); j++)
			{
				System.out.println(product_array.get(j));
				long pro_id = (Long) product_array.get(j);
				Product p = GetProductByID(pro_id);
				if(p != null)
				{
					System.out.println(p.toString());
				}
			}
		}
	}

	public static Product GetProductByID(long id)
	{
		for (Product product : products) {
			if (product.getId() == id)
				return product;
		}
		return null;
	}
}
