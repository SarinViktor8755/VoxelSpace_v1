package com.mygdx.voxel.space;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.voxel.space.VoxelSpace;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(35);
		config.setWindowSizeLimits(1280/3,720/3,1280,1280);
		config.setWindowedMode(1280/2,720/2);
		config.setTitle("VoxelSpace");
		config.setTitle("My GDX Game");
		new Lwjgl3Application(new VoxelSpace(), config);
	}
}
