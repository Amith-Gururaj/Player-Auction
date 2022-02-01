package amith.auction.players.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	private Long pid;
	private String pname;
	private int page;
	private String tname;
	private String ptype;
	private float amount;
	
	public Player() {
		super();
	}

	public Player(Long pid, String pname, int page,String tname, String ptype, float amount) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.page = page;
		this.tname = tname;
		this.ptype = ptype;
		this.amount = amount;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "Player [pid=" + pid + ", pname=" + pname + ", page=" + page + ", tname=" + tname + ", ptype=" + ptype
				+ ", amount=" + amount + "]";
	}	
	
}
