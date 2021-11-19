package velo.ladaalpha.fields.life;

import java.util.ArrayList;

public class LifeReport {
	private ArrayList<LifeReportComponent> components;

	public LifeReport() {
		components = new ArrayList<LifeReportComponent>();
	}

	public void add(LifeReportComponent e) {
		this.components.add(e);
	}

	@Override
	public String toString() {
		String r = "";
		for (LifeReportComponent lrc : components) {
			r += lrc.toString() + "\n";
		}
		return r;
	}

}
