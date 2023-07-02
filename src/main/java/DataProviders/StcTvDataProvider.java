
/*
 * Copyright (c) 2023.
 * Hesham Abd Elhamed Gharib
 */

package DataProviders;

import Utils.ExcelReader;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;

public class StcTvDataProvider {

	ExcelReader excelReader;

	@DataProvider(name = "DataProvider")
	public Object[][] DataProvider() throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Data.xlsx";
		excelReader = new ExcelReader(path);
		Object[][] data = excelReader.getDataObject(1, 8);
		return data;
	}
}