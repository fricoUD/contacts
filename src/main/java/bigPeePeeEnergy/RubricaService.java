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

		request.setAttribute("table", rubrica.getTable());
		String id = (String) request.getParameter("edit");
		System.out.println(id);

		if (id != null) {
			url = "/edit.jsp";
			Bean to_edit = (this.rubrica.get(UUID.fromString(id)));
			System.out.println(id);
			request.setAttribute("mario", to_edit);

		}
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
		return url;
	}
}
