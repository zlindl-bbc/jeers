package ch.bbc.uek223.jeers.entities;

import javax.persistence.*;

@Entity
@Table(name ="TICKET_KATEGORIE")
@NamedQueries({
		@NamedQuery(name = "TicketKategorie.findAll", query = "select tk from TicketKategorie tk order by tk.name desc"),
		@NamedQuery(name = "TicketKategorie.findByName", query = "select tk from TicketKategorie tk where tk.name like '%:name%'")
	})
public class TicketKategorie extends AbstractBaseEntity {

	@Column(name = "NAME", nullable = false)
	private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
