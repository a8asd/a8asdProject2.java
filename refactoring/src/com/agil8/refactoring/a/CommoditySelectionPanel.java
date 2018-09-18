package com.agil8.refactoring.a;

/* Exercise: Using Automated Refactoring Tools
 * 
 * the update method of CommoditySelectionPanel displays 
 * commodities that are ready for update
 * Commodities are only displayed if they are twilight 
 * commodoties and the brokers match
 * 
 * It is difficult to understand and seems to be responsible for 
 * doing many things - SRP?
 * 
 * Using only your automated refactoring tool:
 * 	Extract methods to make it more readable
 * 		1. name the first condition "commoditiesAreReadyForUpdate"
 * 		2. extract listbox.clear to a method called "clearDisplay"
 * 		3. extract the loop to a method called "updateCommodities"
 * 	Remember: no typing code, you are only allowed to type responses to the tool
*/

public class CommoditySelectionPanel {
	private Commodities commodities;
	private ListBox listbox;
	private Broker broker;

	public void update() {
		if (isCommodities()) {
			clearList();
			updateCommodities();
		}
	}

	private void updateCommodities() {
		for(Commodity commodity:commodities) {
			if(shouldAddToView(commodity)) {
				listbox.add(commodity.getView());
			}
		}
	}

	private boolean shouldAddToView(Commodity commodity) {
		return commodity.isTwilight()&&commodity.match(broker);
	}

	private void clearList() {
		listbox.clear();
	}

	private boolean isCommodities() {
		return commodities.size()>0 && commodities.getSource().equals("local");
	}
}
