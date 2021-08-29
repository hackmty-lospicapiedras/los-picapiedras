package sounds;

import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

public class TranslatorSounds {

	public void playCharacterSound(char c) {
		c = Character.toLowerCase(c);
		
		if (c == 'a') {
			play(SoundsDictionary.a);
		}
		else if (c == 'b') {
			play(SoundsDictionary.b);
		}
		else if (c == 'c') {
			play(SoundsDictionary.c);
		}
		else if (c == 'd') {
			play(SoundsDictionary.d);
		}
		else if (c == 'e') {
			play(SoundsDictionary.e);
		}
		else if (c == 'f') {
			play(SoundsDictionary.f);
		}
		else if (c == 'g') {
			play(SoundsDictionary.g);
		}
		else if (c == 'h') {
			play(SoundsDictionary.h);
		}
		else if (c == 'i') {
			play(SoundsDictionary.i);
		}
		else if (c == 'j') {
			play(SoundsDictionary.j);
		}
		else if (c == 'k') {
			play(SoundsDictionary.k);
		}
		else if (c == 'l') {
			play(SoundsDictionary.l);
		}
		else if (c == 'm') {
			play(SoundsDictionary.m);
		}
		else if (c == 'n') {
			play(SoundsDictionary.n);
		}
		else if (c == 'o') {
			play(SoundsDictionary.o);
		}
		else if (c == 'p') {
			play(SoundsDictionary.p);
		}
		else if (c == 'q') {
			play(SoundsDictionary.q);
		}
		else if (c == 'r') {
			play(SoundsDictionary.r);
		}
		else if (c == 's') {
			play(SoundsDictionary.s);
		}
		else if (c == 't') {
			play(SoundsDictionary.t);
		}
		else if (c == 'u') {
			play(SoundsDictionary.u);
		}
		else if (c == 'v') {
			play(SoundsDictionary.v);
		}
		else if (c == 'w') {
			play(SoundsDictionary.w);
		}
		else if (c == 'x') {
			play(SoundsDictionary.x);
		}
		else if (c == 'y') {
			play(SoundsDictionary.y);
		}
		else if (c == 'z') {
			play(SoundsDictionary.z);
		}
		
		try {
			Thread.sleep(450);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void play(String[] files) {
		byte[] buffer = new byte[4096];
		for (String filePath : files) {
			URL url = getClass().getClassLoader().getResource(filePath + ".wav");
			try {
				AudioInputStream is = AudioSystem.getAudioInputStream(url);
				AudioFormat format = is.getFormat();
				SourceDataLine line = AudioSystem.getSourceDataLine(format);
				line.open(format);
				line.start();
				while (is.available() > 0) {
					int len = is.read(buffer);
					line.write(buffer, 0, len);
				}
				line.drain();
				line.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void playSpaceSound() {
		byte[] buffer = new byte[4096];
		URL url = getClass().getClassLoader().getResource("but" + ".wav");
		try {
			AudioInputStream is = AudioSystem.getAudioInputStream(url);
			AudioFormat format = is.getFormat();
			SourceDataLine line = AudioSystem.getSourceDataLine(format);
			line.open(format);
			line.start();
			while (is.available() > 0) {
				int len = is.read(buffer);
				line.write(buffer, 0, len);
			}
			line.drain();
			line.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
