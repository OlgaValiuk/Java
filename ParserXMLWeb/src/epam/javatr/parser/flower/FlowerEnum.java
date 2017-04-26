package epam.javatr.parser.flower;

public enum FlowerEnum {
		FLOWERS("flowers"), ITEM("item"), SOIL("soil"), MULTIPLYING("multiplying"), FLOWER("flower"), NAME("name"),
		ORIGIN("origin"), STALKCOLOUR("stalkColour"), LEAFCOLOUR("leafColour"), AVGSIZEMETERS("avgSizeMeters"), 
		TEMPERATURE("temperature"), WATERMLWEEK("waterMLWeek"), LIGHTING("lighting"),VISUAL("visual"), GROWING("growing");

		private String value;

		private FlowerEnum(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}
