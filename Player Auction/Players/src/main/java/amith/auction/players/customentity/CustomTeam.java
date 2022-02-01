package amith.auction.players.customentity;

public class CustomTeam {
	private String name;
	private int noofplayers;
	private float maxbudget;
	private String owner;
	
	public CustomTeam() {
		super();
	}

	public CustomTeam(String name, int noofplayers, float maxbudget, String owner) {
		super();
		this.name = name;
		this.noofplayers = noofplayers;
		this.maxbudget = maxbudget;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNoofplayers() {
		return noofplayers;
	}

	public void setNoofplayers(int noofplayers) {
		this.noofplayers = noofplayers;
	}

	public float getMaxbudget() {
		return maxbudget;
	}

	public void setMaxbudget(float maxbudget) {
		this.maxbudget = maxbudget;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "CustomTeam [name=" + name + ", noofplayers=" + noofplayers + ", maxbudget=" + maxbudget + ", owner="
				+ owner + "]";
	}
	
	
}
