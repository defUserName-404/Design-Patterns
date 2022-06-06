package org.defusername.structural.adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VLCMediaPlayerTest {

	@Test
	@DisplayName("Audio Player Test TC1")
	void shouldTestAudioPlayer1() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playAudio(FileType.WAV);
	}

	@Test
	@DisplayName("Audio Player Test TC2")
	void shouldTestAudioPlayer2() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playAudio(FileType.MP3);
	}

	@Test
	@DisplayName("Audio Player Test TC3")
	void shouldTestAudioPlayer3() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playAudio(FileType.MOV);
	}

	@Test
	@DisplayName("Audio Player Test TC4")
	void shouldTestAudioPlayer4() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playAudio(FileType.MKV);
	}

	@Test
	@DisplayName("Audio Player Test TC5")
	void shouldTestAudioPlayer5() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playAudio(FileType.MP4);
	}

	@Test
	@DisplayName("Video Player Test TC1")
	void shouldTestVideoPlayer1() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playVideo(FileType.WAV);
	}

	@Test
	@DisplayName("Video Player Test TC2")
	void shouldTestVideoPlayer2() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playVideo(FileType.MP3);
	}

	@Test
	@DisplayName("Video Player Test TC3")
	void shouldTestVideoPlayer3() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playVideo(FileType.MOV);
	}

	@Test
	@DisplayName("Video Player Test TC4")
	void shouldTestVideoPlayer4() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playVideo(FileType.MKV);
	}

	@Test
	@DisplayName("Video Player Test TC5")
	void shouldTestVideoPlayer5() {
		MediaPlayer vlcMediaPlayer = new VLCMediaPlayer("SomeFile");
		vlcMediaPlayer.playVideo(FileType.MP4);
	}
}