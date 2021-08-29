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

	public void playStringSound(String s) {
		s = s.replace(".png", "");

		if (s.equalsIgnoreCase("a")) {
			play(SoundsDictionary.a);
		}
		else if (s.equalsIgnoreCase("and")) {
			play(SoundsDictionary.and);
		}
		else if (s.equalsIgnoreCase("ar")) {
			play(SoundsDictionary.ar);
		}
		else if (s.equalsIgnoreCase("b, but")) {
			play(SoundsDictionary.but);
		}
		else if (s.equalsIgnoreCase("by, was")) {
			play(SoundsDictionary.byWas);
		}
		else if (s.equalsIgnoreCase("c, can")) {
			play(SoundsDictionary.c);
		}
		else if (s.equalsIgnoreCase("cc, con")) {
			play(SoundsDictionary.ccCon);
		}
		else if (s.equalsIgnoreCase("ch, child")) {
			play(SoundsDictionary.chChild);
		}
		else if (s.equalsIgnoreCase("com")) {
			play(SoundsDictionary.com);
		}
		else if (s.equalsIgnoreCase("d")) {
			play(SoundsDictionary.d);
		}
		else if (s.equalsIgnoreCase("dd, dis")) {
			play(SoundsDictionary.ddDis);
		}
		else if (s.equalsIgnoreCase("e, every")) {
			play(SoundsDictionary.e);
		}
		else if (s.equalsIgnoreCase("ea")) {
			play(SoundsDictionary.ea);
		}
		else if (s.equalsIgnoreCase("ed")) {
			play(SoundsDictionary.ed);
		}
		else if (s.equalsIgnoreCase("en, enough")) {
			play(SoundsDictionary.enEnough);
		}
		else if (s.equalsIgnoreCase("er")) {
			play(SoundsDictionary.er);
		}
		else if (s.equalsIgnoreCase("f, from")) {
			play(SoundsDictionary.f);
		}
		else if (s.equalsIgnoreCase("ff, to")) {
			play(SoundsDictionary.ffTo);
		}
		else if (s.equalsIgnoreCase("for")) {
			play(SoundsDictionary.forWord);
		}
		else if (s.equalsIgnoreCase("g, go")) {
			play(SoundsDictionary.g);
		}
		else if (s.equalsIgnoreCase("gg, were")) {
			play(SoundsDictionary.ggWere);
		}
		else if (s.equalsIgnoreCase("gh")) {
			play(SoundsDictionary.gh);
		}
		else if (s.equalsIgnoreCase("h, have")) {
			play(SoundsDictionary.h);
		}
		else if (s.equalsIgnoreCase("i")) {
			play(SoundsDictionary.i);
		}
		else if (s.equalsIgnoreCase("in")) {
			play(SoundsDictionary.in);
		}
		else if (s.equalsIgnoreCase("ing")) {
			play(SoundsDictionary.ing);
		}
		else if (s.equalsIgnoreCase("j, just")) {
			play(SoundsDictionary.j);
		}
		else if (s.equalsIgnoreCase("k, knowledge")) {
			play(SoundsDictionary.k);
		}
		else if (s.equalsIgnoreCase("l, like")) {
			play(SoundsDictionary.l);
		}
		else if (s.equalsIgnoreCase("m, more")) {
			play(SoundsDictionary.m);
		}
		else if (s.equalsIgnoreCase("n, not")) {
			play(SoundsDictionary.n);
		}
		else if (s.equalsIgnoreCase("o")) {
			play(SoundsDictionary.o);
		}
		else if (s.equalsIgnoreCase("of")) {
			play(SoundsDictionary.of);
		}
		else if (s.equalsIgnoreCase("ou, out")) {
			play(SoundsDictionary.ouOut);
		}
		else if (s.equalsIgnoreCase("ow")) {
			play(SoundsDictionary.ow);
		}
		else if (s.equalsIgnoreCase("p, people")) {
			play(SoundsDictionary.p);
		}
		else if (s.equalsIgnoreCase("q, quite")) {
			play(SoundsDictionary.quite);
		}
		else if (s.equalsIgnoreCase("r, rather")) {
			play(SoundsDictionary.rather);
		}
		else if (s.equalsIgnoreCase("s")) {
			play(SoundsDictionary.s);
		}
		else if (s.equalsIgnoreCase("sh, shall")) {
			play(SoundsDictionary.very);
		}
		else if (s.equalsIgnoreCase("st, still")) {
			play(SoundsDictionary.stStill);
		}
		else if (s.equalsIgnoreCase("t, that")) {
			play(SoundsDictionary.that);
		}
		else if (s.equalsIgnoreCase("th, this")) {
			play(SoundsDictionary.thThis);
		}
		else if (s.equalsIgnoreCase("the")) {
			play(SoundsDictionary.the);
		}
		else if (s.equalsIgnoreCase("u, us")) {
			play(SoundsDictionary.us);
		}
		else if (s.equalsIgnoreCase("v, very")) {
			play(SoundsDictionary.very);
		}
		else if (s.equalsIgnoreCase("w, will")) {
			play(SoundsDictionary.wil);
		}
		else if (s.equalsIgnoreCase("wh, which")) {
			play(SoundsDictionary.whWhich);
		}
		else if (s.equalsIgnoreCase("with")) {
			play(SoundsDictionary.with);
		}
		else if (s.equalsIgnoreCase("x, it")) {
			play(SoundsDictionary.it);
		}
		else if (s.equalsIgnoreCase("y, you")) {
			play(SoundsDictionary.you);
		}
		else if (s.equalsIgnoreCase("z, as")) {
			play(SoundsDictionary.as);
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
