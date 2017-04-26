package epam.javatr.parser.parsing;

import java.util.HashSet; 
import java.util.Set;

import epam.javatr.parser.flower.Flower; 

	public abstract class FlowersBuilder { 
		protected Set<Flower> flowers; 
		public FlowersBuilder() {
			flowers = new HashSet<Flower>(); 
			} 
		public FlowersBuilder(Set<Flower> flowers) {
			this.flowers = flowers; 
			} 
		public Set<Flower> getFlowers() {
			return flowers; 
			} 
		abstract public void buildSetFlowers(String fileName); 
}
