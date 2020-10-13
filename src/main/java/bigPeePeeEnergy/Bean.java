package bigPeePeeEnergy;

import java.util.UUID;

public class Bean {

	private String name;
	private String surname;
	private String number;
	private String sex;
	private UUID uuid = UUID.randomUUID();

	public Bean(String name, String surname, String number, String sex) {
		this.name = name;
		this.surname = surname;
		this.number = number;
		this.sex = sex;
		this.uuid = UUID.randomUUID();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Bean [name=" + name + ", surname=" + surname + ", number=" + number + ", sex=" + sex + ", uuid=" + uuid
				+ "]";
	}
}
