package velo.ladaalpha.fields.internet.testing;

import velo.ladaalpha.fields.internet.crawler.HtmlParser;

// TODO: Auto-generated Javadoc

/**
 * The Class Element.
 */
public class Element {

    /**
     * The type.
     */
    private String type;

    /**
     * The attributes.
     */
    private Attribute[] attributes;

    /**
     * Instantiates a new element.
     *
     * @param type       the type
     * @param attributes the attributes
     */
    public Element(String type, Attribute[] attributes) {
        super();
        this.type = type;
        this.attributes = attributes;
    }

    /**
     * Instantiates a new element.
     *
     * @param type the type
     */
    public Element(String type) {
        super();
        this.type = type;
    }

    /**
     * Gets the regex.
     *
     * @return the regex
     */
    public String getRegex() {
        return HtmlParser.regexForTag("div");
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the attributes.
     *
     * @return the attributes
     */
    public Attribute[] getAttributes() {
        return attributes;
    }

    /**
     * Sets the attributes.
     *
     * @param attributes the new attributes
     */
    public void setAttributes(Attribute[] attributes) {
        this.attributes = attributes;
    }

}
