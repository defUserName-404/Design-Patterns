package org.defusername.structural.adapter;

public class MediaPlayerAdapter {

	public static FileType convertAudioFile(FileType convertFrom, FileType convertTo) {
		System.out.println("Converting audio from " + convertFrom + " to " + convertTo);
		return convertTo;
	}

	public static FileType convertVideoFile(FileType convertFrom, FileType convertTo) {
		System.out.println("Converting video from " + convertFrom + " to " + convertTo);
		return convertTo;
	}
}