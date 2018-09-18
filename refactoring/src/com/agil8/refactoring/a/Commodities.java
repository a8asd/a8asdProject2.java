package com.agil8.refactoring.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Commodities implements Iterable<Commodity> {
	private List<Commodity> commodities = new ArrayList<Commodity>();

	public Iterator<Commodity> iterator() {
		return commodities.iterator();
	}

	public int size() {
		return commodities.size();
	}

	public String getSource() {
		return null;
	}
}
