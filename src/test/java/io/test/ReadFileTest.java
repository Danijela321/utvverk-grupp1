package io.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Contact;
import domain.ContactBook;
import io.ReadFile;
import io.WriteFile;

public class ReadFileTest {
	private ContactBook cb;

	/**
	 * Nadia H. ReadFile tester testar om filen existerar
	 * 
	 * @throws IOException
	 */

	@BeforeEach
	public void init() {
		cb = new ContactBook();

		cb.add(new Contact("Adam"));
		cb.add(new Contact("Bertil"));
		cb.add(new Contact("Caesar"));
		cb.add(new Contact("David"));
	}

	@Test
	public void ReadFileIsReading() throws IOException {
		ContactBook a = new ContactBook();
		WriteFile.writeToFile(a, "test2");
		ReadFile rf = new ReadFile();
		a = rf.readfile();
		assertFalse(a.isEmpty());		
	}

	@Test
	public void readFileReadCorrectTest() throws IOException {

		ContactBook c = new ContactBook();
		c.addAll(cb);
		WriteFile.writeToFile(c, "test2");
		ReadFile rf = new ReadFile();
		ContactBook a = rf.readfile("test2");
		assertEquals(a, c);

	}

	@AfterEach
	public void deleteFileTest() {
		File f = new File("test2");
		f.delete();
	}
}