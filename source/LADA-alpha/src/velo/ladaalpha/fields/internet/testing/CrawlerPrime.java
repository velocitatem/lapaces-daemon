package velo.ladaalpha.fields.internet.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.parser.DTD;

import org.junit.jupiter.api.Test;

import velo.ladaalpha.fields.internet.Internet;
import velo.ladaalpha.fields.internet.crawler.HtmlParser;

class CrawlerPrime {

	@Test
	void test() throws IOException {
		// String html =
		// Internet.fetch("https://www.mintmobile.com/ryan-reynolds-announcement/");
		// String SRChtml2 = "<div><div class=\"ef eo fp fq fr fs\"></div><section
		// class=\"dn ft fu di fv\"><div class=\"\"><h1 id=\"cda0\" class=\"fx dl fy bb
		// fz je gb ij jg jh gf in jj zc gj zd ze zf gn zg zh zi gr zj zk gu gv\"
		// data-selectable-paragraph=\"\"><a class=\"dy bx\" rel=\"noopener\"
		// href=\"/my-bare-metal-rpi-journey-830464e6d50d?source=user_profile---------1-------------------------------\">My
		// Bare Metal RPi journey</a></h1></div><p id=\"5420\" class=\"ie if fy ig b ih
		// ii ij ik il im in io ip iq ir is it iu iv iw ix iy iz ja jb dn gv\"
		// data-selectable-paragraph=\"\">I bought a Raspberry Pi 3 B+ a few years ago
		// about the time I started learning Rust which was also about when I took OS
		// dev. I wanted to learn OS development and I’d heard about <a
		// href=\"https://cs140e.sergio.bz/\" class=\"dy ny\" target=\"_blank\"
		// rel=\"noopener ugc nofollow\">CS140e</a> so I thought it would be relatively
		// easy. And it has been…<em class=\"lm\"></em></p></section></div>";
		String SRChtml = "<html>\n" + "    <head>\n" + "        <title>My HTML Page</title>\n" + "    </head>\n"
				+ "    <body>\n" + "        <p style=\"special\">\n" + "            This paragraph has special style\n"
				+ "        </p>\n" + "        <p>\n" + "            This paragraph is not special\n" + "        </p>\n"
				+ "    </body>\n" + "</html>";

		ArrayList<String> tokens1 = new ArrayList<String>();
		String fox = "";
		int index = 0;
		String[] vec = SRChtml.split("");
		for (String s : vec) {
			String next = index < vec.length - 1 ? vec[index + 1] : null;
			if (fox.length() > 0 || !s.equals(" ")) {
				switch (s) {
				case "<":
					if (fox.length() > 0) {
						tokens1.add(fox);
						fox = "";
					}
					tokens1.add("<");
					break;
				case ">":
					if (fox.length() > 0) {
						tokens1.add(fox);
						fox = "";
					}
					tokens1.add(s);
					break;
				case "\\":

					switch (next) {
					case "\"":
						tokens1.add("\\\"");
						index++;
						break;
					}
					break;
				default:
					fox += s;
					break;
				}
			}
			index++;
		}

		index = 0;
		for (String m : tokens1) {
			if (index < vec.length - 1) {
				if (m.equals("<") && tokens1.get(index + 1).substring(0, 1).equals("/")) {
					tokens1.set(index, "</");
					tokens1.set(index + 1, tokens1.get(index + 1).substring(1));
				}
			}
			index += 1;
		}
		System.out.println(Arrays.toString(tokens1.toArray()));

		ArrayList<Tag> tokens2 = new ArrayList<Tag>();

		Tag current = null;
		index = 0;
		for (String m : tokens1) {
			if (current == null || m.contains("<")) {
				switch (m) {
				case "<":
					current = new Tag();
					if (index < tokens1.size() - 1) {
						current.name = tokens1.get(index + 1);
					}
					current.type = 0;
					break;
				case "</":
					current = new Tag();
					if (index < tokens1.size() - 1) {
						current.name = tokens1.get(index + 1);
					}
					current.type = 1;
					break;
				}

			} else {
				m = m.trim();
				if (m.equals(">")) {
					tokens2.add(current);
					current = null;
				}
			}
			index += 1;
		}
		ArrayList<Tag> open = new ArrayList<Tag>(), cls = new ArrayList<Tag>(); 
		for (Tag t : tokens2) {			
			if(t.type == 0) {
				open.add(t);
			}
			else {
				
				for(int i =0; i < open.size(); i+=1) {
					Tag tt = open.get(i);
					if(tt.name.contains(t.name)) {						
						open.remove(i);
						t.body = (ArrayList<Tag>) cls.clone();
						cls = new ArrayList<Tag>();
						cls.add(t);
					}					
				}
			}
		}
		
		for(Tag c : cls) {
			openTag(c);
		}
	}
	class Tag {
		public String name;
		public ArrayList<Tag> body;
		public ArrayList<String[]> params = new ArrayList<String[]>();
		public int type;
		@Override
		public String toString() {
			return name;				
		}
	}
	int c = 0;
	void openTag(Tag t) {
		if(t.body!=null) {
			System.out.println(c+ " - " +t.name + " - " + t.body.size());
			c+=1;
			for(Tag tt : t.body) {
				openTag(tt);
			}
		}
		else {
			
		}
	}

}
