package velo.ladaalpha.fields.internet.testing;

import velo.ladaalpha.fields.internet.crawler.HtmlParser;

public class Element {
	private String type;
	private Attribute[] attributes;
	
	public Element(String type, Attribute[] attributes) {
		super();
		this.type = type;
		this.attributes = attributes;
	}
	
	public Element(String type) {
		super();
		this.type = type;
	}

	public String getRegex() {		
		return HtmlParser.regexForTag("div");
	}
 	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Attribute[] getAttributes() {
		return attributes;
	}
	public void setAttributes(Attribute[] attributes) {
		this.attributes = attributes;
	}
	
}
