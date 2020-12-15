package com.jco.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileTransfom {
	
	public static ArrayList<Integer> fileToIntList(String fileName) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((i) -> list.add(Integer.parseInt(i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static ArrayList<String> fileToStringList(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((i) -> list.add(i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public static String[] inLineFileToStringArray(String fileName, String splitString) {
		String str = "";
		
		try (InputStream ips = new FileInputStream(fileName);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr)) {
			
			String line;
			while ((line = br.readLine()) != null){
				str = line;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		String inputs[] = str.split(splitString);
		
		return inputs;
	}
	
	
	public static int[] inLineFileToIntArray(String fileName, String splitString) {
		String ar[] = inLineFileToStringArray(fileName, splitString);
		
		int inputs[] = Arrays.stream(ar)
		        .mapToInt(Integer::valueOf)
		        .toArray();
		
		return inputs;
	}
	
	public static ArrayList<Integer> inLineFileToIntList(String fileName, String splitString) {
		String ar[] = inLineFileToStringArray(fileName, splitString);
		
		int inputs[] = Arrays.stream(ar)
		        .mapToInt(Integer::valueOf)
		        .toArray();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i : inputs) {
			list.add(i);
		}
		
		return list;
	}
	
	public static ArrayList<Long> fileToLongList(String fileName) {
		ArrayList<Long> list = new ArrayList<Long>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach((i) -> list.add(Long.parseLong(i)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static long[] inLineFileToLongArray(String fileName, String splitString) {
		String ar[] = inLineFileToStringArray(fileName, splitString);
		
		long inputs[] = Arrays.stream(ar)
		        .mapToLong(Long::valueOf)
		        .toArray();
		
		return inputs;
	}
	
	
	public static ArrayList<String> inLineFileToStringArrayList(String fileName) {
		ArrayList<String> al = new ArrayList<String>();
		
		try (InputStream ips = new FileInputStream(fileName);
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr)) {
			
			String line;
			while ((line = br.readLine()) != null){
				al.add(line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return al;
	}
	
	public static String[] splitEqually(String text, int size) {
	    // Give the list the right capacity to start with. You could use an array
	    // instead if you wanted.
		String[] ret = new String[((text.length() + size - 1) / size)];

	    for (int start = 0; start < text.length(); start += size) {
	    	ret[start/size] = text.substring(start, Math.min(text.length(), start + size));
	    }
	    return ret;
	}
}
