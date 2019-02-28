import java.sql.Timestamp;
import java.util.ArrayList;

public class Product {

	private Long id;
	
	private String name;
	
	private String color;
	
	private String storage;
	
	private long sale_price;
	
	private long market_price;

	private ArrayList<String> link;
	
	private String description;
	
	private String origin;
	
	private Timestamp factory_date;
	
	private float weight;

	public Product(Long id, String name, String color, String storage, long sale_price, long market_price,
			ArrayList<String> link) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.storage = storage;
		this.sale_price = sale_price;
		this.market_price = market_price;
		this.link = link;
	}

	public Product(Long id, String name, String color, String storage, long sale_price, long market_price,
			ArrayList<String> link, String description, String origin, Timestamp factory_date, float weight) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.storage = storage;
		this.sale_price = sale_price;
		this.market_price = market_price;
		this.link = link;
		this.description = description;
		this.origin = origin;
		this.factory_date = factory_date;
		this.weight = weight;
	}

	public Product() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSale_price() {
		return sale_price;
	}

	public void setSale_price(long sale_price) {
		this.sale_price = sale_price;
	}

	public long getMarket_price() {
		return market_price;
	}

	public void setMarket_price(long market_price) {
		this.market_price = market_price;
	}

	public ArrayList<String> getLink() {
		return link;
	}

	public void setLink(ArrayList<String> link) {
		this.link = link;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Timestamp getFactory_date() {
		return factory_date;
	}

	public void setFactory_date(Timestamp factory_date) {
		this.factory_date = factory_date;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", color=" + color + ", storage=" + storage + ", sale_price="
				+ sale_price + ", market_price=" + market_price + ", link=" + link + ", description=" + description
				+ ", origin=" + origin + ", factory_date=" + factory_date + ", weight=" + weight + "]";
	}

}
