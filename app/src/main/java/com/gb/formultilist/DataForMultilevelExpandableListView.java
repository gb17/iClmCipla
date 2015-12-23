package com.gb.formultilist;

import java.util.ArrayList;

/**
 * 
 * first level item
 * 
 */
public class DataForMultilevelExpandableListView {

	private String pName;

	private ArrayList<SubCategory> mSubCategoryList;

	public DataForMultilevelExpandableListView(String pName,
			ArrayList<SubCategory> mSubCategoryList) {
		super();
		this.pName = pName;
		this.mSubCategoryList = mSubCategoryList;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public ArrayList<SubCategory> getmSubCategoryList() {
		return mSubCategoryList;
	}

	public void setmSubCategoryList(ArrayList<SubCategory> mSubCategoryList) {
		this.mSubCategoryList = mSubCategoryList;
	}

	/**
	 * 
	 * second level item
	 * 
	 */

	public static class SubCategory {

		private String pSubCatName;
		private String pSubCatTime;
		private ArrayList<ItemList> mItemListArray;

		public SubCategory(String pSubCatName, String pSubCatTime,
				ArrayList<ItemList> mItemListArray) {
			super();
			this.pSubCatName = pSubCatName;
			this.mItemListArray = mItemListArray;
			this.pSubCatTime = pSubCatTime;
		}

		public String getpSubCatName() {
			return pSubCatName;
		}

		public void setpSubCatName(String pSubCatName) {
			this.pSubCatName = pSubCatName;
		}

		public String getpSubCatTime() {
			return pSubCatTime;
		}

		public void setpSubCatTime(String pSubCatTime) {
			this.pSubCatTime = pSubCatTime;
		}

		public ArrayList<ItemList> getmItemListArray() {
			return mItemListArray;
		}

		public void setmItemListArray(ArrayList<ItemList> mItemListArray) {
			this.mItemListArray = mItemListArray;
		}

		/**
		 * 
		 * third level item
		 * 
		 */
		public static class ItemList {

			private String itemName;
			private String itemPrice;
			private String itemClass;
			private String itemTime;

			public ItemList(String itemName, String itemPrice, String itemClass,String itemTime) {
				super();
				this.itemName = itemName;
				this.itemPrice = itemPrice;
				this.itemClass = itemClass;
				this.itemTime = itemTime;

			}

			public String getItemName() {
				return itemName;
			}

			public void setItemName(String itemName) {
				this.itemName = itemName;
			}

			public String getItemPrice() {
				return itemPrice;
			}

			public void setItemPrice(String itemPrice) {
				this.itemPrice = itemPrice;
			}

			public String getItemClass() {
				return itemClass;
			}

			public void setItemClass(String itemClass) {
				this.itemClass = itemClass;
			}

			public String getItemTime() {
				return itemTime;
			}

			public void setItemTime(String itemTime) {
				this.itemTime = itemTime;
			}

		}

	}

}
