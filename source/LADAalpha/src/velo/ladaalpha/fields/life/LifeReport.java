package velo.ladaalpha.fields.life;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class LifeReport.
 */
public class LifeReport {
	
	/** The components. */
	private ArrayList<LifeReportComponent> components;

	/**
	 * Instantiates a new life report.
	 */
	public LifeReport() {
		components = new ArrayList<LifeReportComponent>();
	}

	/**
	 * Adds the.
	 *
	 * @param e the e
	 */
	public void add(LifeReportComponent e) {
		this.components.add(e);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String r = "";
		for (LifeReportComponent lrc : components) {
			r += lrc.toString() + "\n";
		}
		return r;
	}

}
