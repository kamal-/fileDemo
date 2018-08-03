package com.airtelbg.app.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
	 static Logger log = Logger.getLogger(AppController.class.getName());
	  
	@PostMapping("/file")
	public List<String> getCommonWords(@RequestBody final List<String> pathArr) throws Exception
	{
		if(pathArr.size()<3)
			throw new Exception("Minimum 3 files to be processed.");
		List<String> duplicate = new LinkedList<>();
		pathArr.forEach(path ->{
			File file = new File(path);
			String word=null;
			Set<String> tokens = new HashSet<>();
					{
				if(!file.exists())
				{
					log.error("File not found: "+path);
					log.error("Mininum 3 files to be processed.");
				}
				else {
					try {
						Scanner sc = new Scanner(file);
						while(sc.hasNext())
						{
							word=sc.next().toLowerCase().replaceAll("[^\\w\\s]", "");
						//	System.out.println("AppController.getCommonWords()"+word);
							if(null!=word && !tokens.add(word) && !duplicate.contains(word))
							{
								duplicate.add(word);
							}
							word=null;
						}		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					}
		});
		
		return duplicate;
	}
	
	@GetMapping("/hello")
	public String test()
	{
		return "test occured";
	}
		
}
