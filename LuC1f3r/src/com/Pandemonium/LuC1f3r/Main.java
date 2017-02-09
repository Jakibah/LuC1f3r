package com.Pandemonium.LuC1f3r;

import com.Pandemonium.LuC1f3r.FileHandler;

public class Main {

	private static boolean Running;
	private static boolean First = true;
	private static boolean Started = true;

	public static void main(String[] args) {
		Update();

	}

	public static void Start() {
		First = FileHandler.checkFirst();
	}

	public static void Update() {

		Running = true;

		while (Running) {
			if (Started) {
				Started = false;
				Start();
			}

		}

		Stop();
	}

	public static void Stop() {

	}

	public static void Kill() {
		Running = false;
		System.out.println("Killing process");
	}

	
}