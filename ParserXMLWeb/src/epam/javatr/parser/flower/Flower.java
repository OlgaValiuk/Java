package epam.javatr.parser.flower;

public class Flower {

	private String item;
	private String name;
	private String origin;
	private String soil;
	private String multiplying;
	private Visual visual = new Visual();
	public Visual getVisual() {
		return visual;
	}

	public void setVisual(Visual visual) {
		this.visual = visual;
	}

	public Growing getGrowing() {
		return growing;
	}

	public void setGrowing(Growing growing) {
		this.growing = growing;
	}

	private Growing growing = new Growing();

	public Flower(String item, String name, String origin, String soil, String multiplying, Visual visual,
			Growing growing) {
		super();
		this.item = item;
		this.name = name;
		this.origin = origin;
		this.soil = soil;
		this.multiplying = multiplying;
		this.visual = visual;
		this.growing = growing;
	}

	public Flower(){
		
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getSoil() {
		return soil;
	}

	public void setSoil(String soil) {
		this.soil = soil;
	}

	public String getMultiplying() {
		return multiplying;
	}

	public void setMultiplying(String multiplying) {
		this.multiplying = multiplying;
	}

	public String toString() {
		return "Flower item=" + item + ", name=" + name + ", origin=" + origin + ", soil=" + soil + ", multiplying="
				+ multiplying + ", " + visual + ", " + growing + "\n";
	}

	public static class Visual {

		private String stalkColour;
		private String leafColour;
		private Double avgSizeMeters;

		public Visual(String stalkColour, String leafColour, double avgSizeMeters) {
			this.stalkColour = stalkColour;
			this.leafColour = leafColour;
			this.avgSizeMeters = avgSizeMeters;
		}

		public Visual() {

		}

		public String getStalkColour() {
			return stalkColour;
		}

		public void setStalkColour(String stalkColour) {
			this.stalkColour = stalkColour;
		}

		public String getLeafColour() {
			return leafColour;
		}

		public void setLeafColour(String leafColour) {
			this.leafColour = leafColour;
		}

		public Double getAvgSizeMeters() {
			return avgSizeMeters;
		}

		public void setAvgSizeMeters(Double avgSizeMeters) {
			this.avgSizeMeters = avgSizeMeters;
		}

		public String toString() {
			return "visual(stalkColour=" + stalkColour + ", leafColour=" + leafColour + ", avgSizeMeters="
					+ avgSizeMeters + ")";
		}
	}

	public static class Growing {
		private Double temperature;
		private String lighting;
		private Integer waterMLWeek;

		public Growing(Double temperature, String lighting, Integer waterMLWeek) {
			this.temperature = temperature;
			this.lighting = lighting;
			this.waterMLWeek = waterMLWeek;
		}
		public Growing(){
			
		}
		public Double getTemperature() {
			return temperature;
		}
		public void setTemperature(Double temperature) {
			this.temperature = temperature;
		}
		public String getLighting() {
			return lighting;
		}
		public void setLighting(String lighting) {
			this.lighting = lighting;
		}
		public Integer getWaterMLWeek() {
			return waterMLWeek;
		}
		public void setWaterMLWeek(Integer waterMLWeek) {
			this.waterMLWeek = waterMLWeek;
		}
		public String toString() {
			return "growing(temperature=" + temperature + ", lighting=" + lighting + ", waterMLWeek=" + waterMLWeek
					+ ")";
		}

	}

}
