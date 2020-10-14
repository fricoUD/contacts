package bigPeePeeEnergy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class RubricaDAOImplementation implements RubricaDAO {

	private HashMap<UUID, Bean> table;
	private String file = "C:\\Users\\m_aa\\eclipse-workspace\\MavenFoolID\\placeholder.csv";

	public RubricaDAOImplementation() throws IOException {
		super();
		List<HashMap<String, String>> rawData = CSVReader.readCsv(file);
		this.table = new HashMap<UUID, Bean>();
		for (HashMap<String, String> map : rawData) {

			String name = map.get("Name");
			String surname = map.get("Surname");
			String number = map.get("Number");
			String sex = map.get("Sex");
			String starred = map.get("Starred");
			Bean entry = new Bean(name, surname, number, sex, starred);

			this.table.put(entry.getUuid(), entry);
		}
	}

	@Override
	public String toString() {
		String r = "";
		r += "Table" + "\n" + "-------------------------" + "\n";
		for (UUID b : this.table.keySet()) {
			r += "Name: " + this.table.get(b).getName() + " Surname: " + this.table.get(b).getSurname() + "\n";
		}

		return r;
	}

	public HashMap<String, HashMap<UUID, Bean>> getTable() {
		HashMap<String, HashMap<UUID, Bean>> dataTable = new HashMap<String, HashMap<UUID, Bean>>();
		HashMap<UUID, Bean> contacts = new HashMap<UUID, Bean>();
		HashMap<UUID, Bean> starredContacts = new HashMap<UUID, Bean>();
		for (Bean b : this.table.values()) {
			if (StringUtils.equals("true", b.getStarred())) {
				starredContacts.put(b.getUuid(), b);
			} else {
				contacts.put(b.getUuid(), b);
			}
		}
		dataTable.put("Starred", starredContacts);
		dataTable.put("notStarred", contacts);

		return dataTable;
	}

	@Override
	public Bean get(UUID key) {
		return table.get(key);
	}

	@Override
	public void modify(UUID key, HashMap<String, String> modData) throws IOException {
		Bean toMod = table.get(key);
		toMod.setName(modData.get("Name"));
		toMod.setSurname(modData.get("Surname"));
		toMod.setNumber(modData.get("Number"));
		toMod.setSex(modData.get("Sex"));

		CSVReader.updateCsv(file, table);
	}

	@Override
	public void delete(UUID key) throws IOException {
		table.remove(key);

		CSVReader.updateCsv(file, table);
	}

	@Override
	public void insert(HashMap<String, String> toAdd) throws IOException {
		Bean newBean = new Bean(toAdd.get("Name"), 
				toAdd.get("Surname"), 
				toAdd.get("Number"), 
				toAdd.get("Sex"),
				"false");
		this.table.put(newBean.getUuid(), newBean);
		CSVReader.updateCsv(file, table);
	}

	public void setAsStarred(UUID key) throws IOException {
		this.table.get(key).setStarred("true");
		CSVReader.updateCsv(file, table);
	}

	public void setAsNormal(UUID key) throws IOException {
		this.table.get(key).setStarred("false");
		CSVReader.updateCsv(file, table);

	}

}