package bigPeePeeEnergy;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public interface RubricaDAO {
	
	public void modify(UUID key, HashMap<String, String> modData) throws IOException;
	public void delete(UUID key) throws IOException;
	public void insert(HashMap<String, String> toAdd) throws IOException;
	public Bean get(UUID key);
}

