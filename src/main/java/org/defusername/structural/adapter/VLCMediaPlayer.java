package org.defusername.structural.adapter;

public class VLCMediaPlayer implements MediaPlayer {

	private final String fileName;

	public VLCMediaPlayer(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void playAudio(FileType fileType) {
		if (fileType == FileType.MKV
				|| fileType == FileType.MOV
				|| fileType == FileType.MP4)
			fileType = MediaPlayerAdapter.convertAudioFile(fileType, FileType.MP3);

		System.out.println("Playing " + fileName + " in " + fileType + " format");
	}

	@Override
	public void playVideo(FileType fileType) {
		if (fileType == FileType.MP3
				|| fileType == FileType.WAV)
			fileType = MediaPlayerAdapter.convertVideoFile(fileType, FileType.MP4);

		System.out.println("Playing " + fileName + " in " + fileType + " format");
	}
}