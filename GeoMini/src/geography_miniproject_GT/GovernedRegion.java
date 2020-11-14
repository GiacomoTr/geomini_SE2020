package geography_miniproject_GT;

public abstract class GovernedRegion {
	
	private String countryName;
	private double area;
	private int population;
	protected enum formOfGov {Democracy, Republic, Monarchy}
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
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