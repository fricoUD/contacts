package bigPeePeeEnergy;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class RubricaService {

	public RubricaDAOImplementation rubrica;

	public RubricaService() throws IOException {

		this.rubrica = new RubricaDAOImplementation();
	}

	public String handleRequest(HttpServletRequest request) throws IOException {
		String url = "/home.jsp";
		String id = (String) request.getParameter("edit");
		System.out.println(id);
		String action = request.getParameter("buttonPressed");

		if (StringUtils.equals(action, "Add")) {
			url = "/add.jsp";
		}

		if (id != null) {
			Bean focusID = (this.rubrica.get(UUID.fromString(id)));

			switch (action) {
			case "Edit":
				url = "/edit.jsp";
				request.setAttribute("toEdit", focusID);
				break;

			case "Delete":
				this.rubrica.delete(UUID.fromString(id));
				break;

			case "Fav":
				if (StringUtils.equals(focusID.getStarred(), "true")) {
					this.rubrica.setAsNormal(UUID.fromString(id));
				} else {
					this.rubrica.setAsStarred(UUID.fromString(id));
				}
				break;

			case "Show":
				System.out.println("i am here");
				url = "/focus.jsp";
				request.setAttribute("toEdit", focusID);
				break;
			}
		}

		HashMap<String, HashMap<UUID, Bean>> dataTable = rubrica.getTable();
		request.setAttribute("contactsTable", dataTable.get("notStarred"));
		request.setAttribute("starredTable", dataTable.get("Starred"));

		if (StringUtils.equals((request.getParameter("apply")), "pressed")) {

			String key = (String) request.getParameter("key");
			UUID to_edit = (UUID.fromString(key));
			HashMap<String, String> modData = new HashMap<String, String>();
			modData.put("Name", request.getParameter("name"));
			modData.put("Surname", request.getParameter("surname"));
			modData.put("Number", request.getParameter("number"));
			modData.put("Sex", request.getParameter("sex"));
			this.rubrica.modify(to_edit, modData);

		}
		if (StringUtils.equals((request.getParameter("create")), "pressed")) {

			HashMap<String, String> modData = new HashMap<String, String>();
			modData.put("Name", request.getParameter("name"));
			modData.put("Surname", request.getParameter("surname"));
			modData.put("Number", request.getParameter("number"));
			modData.put("Sex", request.getParameter("sex"));
			this.rubrica.insert(modData);
			
		}

		return url;
	}
}
