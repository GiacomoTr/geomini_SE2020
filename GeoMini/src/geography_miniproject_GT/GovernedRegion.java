package geography_miniproject_GT;

public abstract class GovernedRegion {
	
	private String Name;
	private double area;
	private int population;
	protected enum formOfGov {Democracy, Republic, Monarchy}
	
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
}