package org.sample.utility;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public Properties prp;
	public FileInputStream file;

	public TestBase() {
		try {
			prp = new Properties();
			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\org\\sample\\config\\config.properties");
			prp.load(file);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

	}
}
