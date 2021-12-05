package velo.ladaalpha.fields.internet.testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc

/**
 * The Class Html.
 */
public class Html {

    /**
     * The html.
     */
    private String html;

    /**
     * Instantiates a new html.
     *
     * @param html the html
     */
    public Html(String html) {
        super();
        this.html = html;
    }

    /**
     * Contains element.
     *
     * @param element the element
     * @return true, if successful
     */
    public boolean ContainsElement(Element element) {
        String patternString = element.getRegex();
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(this.html);

        return matcher.find();

    }

    /**
     * Gets the html.
     *
     * @return the html
     */
    public String getHtml() {
        return html;
    }

    /**
     * Sets the html.
     *
     * @param html the new html
     */
    public void setHtml(String html) {
        this.html = html;
    }

}
