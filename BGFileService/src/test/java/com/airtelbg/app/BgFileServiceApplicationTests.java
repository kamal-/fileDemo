package com.airtelbg.app;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.airtelbg.app.controller.AppController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgFileServiceApplicationTests {

	@Mock
	AppController appController;
	@Test
	public void contextLoads() {
	}

	@Test
	public void testFiles() throws Exception
	{
		List<String> filePath = new LinkedList<>();
		filePath.add("C:\\workspacelist\\Airtel\\BGFileService\\content.txt");
		filePath.add("C:\\workspacelist\\Airtel\\BGFileService\\content1.txt");
		filePath.add("C:\\workspacelist\\Airtel\\BGFileService\\content2.txt");
		appController.getCommonWords(filePath);
	}
}
