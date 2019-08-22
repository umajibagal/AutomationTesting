package ddt.csv;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class ReadCSV {
	public ArrayList<String[]> readAllDataAtOnce(String file) {
		ArrayList<String[]> data = new ArrayList<String[]>();
		try {
			FileReader filereader = new FileReader(file);

			CSVReader csvReader = new CSVReaderBuilder(filereader).withSkipLines(1).build();
			List<String[]> allData = csvReader.readAll();

			int csize = 0;
			String[] t = allData.get(0);
			for (String string : t) {
				for (String s : string.split(",")) {
					csize++;
				}
			}
			
			for (String[] row : allData) {
				String fields[] = new String[csize];
		    	int col = 0;  
				for (String cell : row) {
					for (String value : cell.split(",")) {
						fields[col] = value;
					}
				}
				data.add(fields);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
