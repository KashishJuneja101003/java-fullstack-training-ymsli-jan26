package com.dp.behavioural.a.iterator_dp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu implements Iterable<Item> {

	private List<Item> items = null;

	public Menu() {
		items = new ArrayList<>();
	}

	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public Iterator<Item> iterator() {
		return new MenuIterator();
	}

	class MenuIterator implements Iterator<Item> {
		int currentIndex = 0;

		@Override
		public boolean hasNext() {
			if (currentIndex >= items.size()) {
				return false;
			} else {
				return true;
			}
		}

		@Override
		public Item next() {
			return items.get(currentIndex++);
		}

		@Override
		public void remove() {
			items.remove(--currentIndex);
		}

	}
}
