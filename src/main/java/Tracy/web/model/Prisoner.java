package Tracy.web.model;

import javax.persistence.*;

@Entity
@Table(name = "prisoners")
public class Prisoner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "prisoner_name")
	private String prisonerName;

	@Column(name = "victim_name")
	private String victimName;

	@Column(name = "description")
	private String description;

	@Column(name = "witness_name")
	private String witnessName;

	public Prisoner() {
	}

	public Prisoner(String prisonerName, String victimName, String description, String witnessName) {
		this.prisonerName = prisonerName;
		this.victimName = victimName;
		this.description = description;
		this.witnessName = witnessName;
	}

	public Prisoner(long id, String prisonerName, String victimName, String description, String witnessName) {
		this.id = id;
		this.prisonerName = prisonerName;
		this.victimName = victimName;
		this.description = description;
		this.witnessName = witnessName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrisonerName() {
		return prisonerName;
	}

	public void setPrisonerName(String prisonerName) {
		this.prisonerName = prisonerName;
	}

	public String getVictimName() {
		return victimName;
	}

	public void setVictimName(String victimName) {
		this.victimName = victimName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWitnessName() {
		return witnessName;
	}

	public void setWitnessName(String witnessName) {
		this.witnessName = witnessName;
	}
}
