package bigPeePeeEnergy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.util.*;

public class CSVReader {
	private static String[] HEADERS = { "Name", "Surname", "Number", "Sex", "Starred" };

	public static List<HashMap<String, String>> readCsv(String file) throws IOException {
		List<HashMap<String, String>> rawCsv = new ArrayList<HashMap<String, String>>();

		Reader in = new FileReader(file);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withHeader(HEADERS).withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
			HashMap<String, String> toAdd = new HashMap<String, String>();
			toAdd.put("Name", record.get("Name"));
			toAdd.put("Surname", record.get("Surname"));
			toAdd.put("Number", record.get("Number"));
			toAdd.put("Sex", record.get("Sex"));
			toAdd.put("Starred", record.get("Starred"));
			rawCsv.add(toAdd);
		}
		return rawCsv;
	}

	public static void updateCsv(String file, HashMap<UUID, Bean> data) throws IOException {
		FileWriter out = new FileWriter(file);
		try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.DEFAULT.withHeader(HEADERS))) {
			for (UUID i : data.keySet()) {
				Bean x = data.get(i);
				printer.printRecord(x.getName(), x.getSurname(), x.getNumber(), x.getSex(), x.getStarred());
			}
		}
	}
}