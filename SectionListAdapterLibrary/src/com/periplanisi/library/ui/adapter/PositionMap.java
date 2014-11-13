package com.periplanisi.library.ui.adapter;

/**
 * Object to map adapter absolute position to an item within a section.
 * 
 * @author Ioannis
 * 
 */
public class PositionMap {

	private final SectionAdapterRowType rowType;
	private final int sectionIndex;
	private final int itemIndex;

	public PositionMap(final SectionAdapterRowType rowType, final int sectionIndex, final int itemIndex) {
		super();
		this.rowType = rowType;
		this.sectionIndex = sectionIndex;
		this.itemIndex = itemIndex;
	}

	/**
	 * Get row type (section title or item)
	 * 
	 * @return
	 */
	public SectionAdapterRowType getRowType() {
		return rowType;
	}

	/**
	 * Get section index
	 * 
	 * @return
	 */
	public int getSectionIndex() {
		return sectionIndex;
	}

	/**
	 * Get item index in the section it belongs to<br>
	 * Return value is invalid in case of section title row type
	 * 
	 * @return
	 */
	public int getItemIndex() {
		return itemIndex;
	}

}
