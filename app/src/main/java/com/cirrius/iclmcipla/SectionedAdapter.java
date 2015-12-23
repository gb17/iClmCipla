package com.cirrius.iclmcipla;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

abstract public class SectionedAdapter extends BaseAdapter {

    String TAG = getClass().getSimpleName();

    abstract protected View getHeaderView(String caption, String count,
                                          int index, View convertView, ViewGroup parent);

    private List<Section> sections = new ArrayList<Section>();
    private static int TYPE_SECTION_HEADER = 0;

    public SectionedAdapter() {
        super();
        sections.clear();
    }

    public void addSection(String caption, String count, Adapter adapter) {
        sections.add(new Section(caption, count, adapter));
    }

    public void clear() {
        sections.clear();
        notifyDataSetChanged();
    }

    public Object getItem(int position) {
        for (Section section : this.sections) {
            if (position == 0) {
                return (section);
            }

            int size = section.adapter.getCount() + 1;

            if (position < size) {
                return (section.adapter.getItem(position - 1));
            }
            position -= size;
        }
        return (null);
    }

    public int getCount() {
        int total = 0;

        for (Section section : this.sections) {
            total += section.adapter.getCount() + 1; // add one for header
        }

        return (total);
    }

    public int getViewTypeCount() {
        int total = 1; // one for the header, plus those from sections

        for (Section section : this.sections) {
            total += section.adapter.getViewTypeCount();
        }

        return (total);
    }

    public int getItemViewType(int position) {
        int typeOffset = TYPE_SECTION_HEADER + 1; // start counting from here

        for (Section section : this.sections) {
            if (position == 0) {
                return (TYPE_SECTION_HEADER);
            }

            int size = section.adapter.getCount() + 1;

            if (position < size) {
                int value = (typeOffset + section.adapter
                        .getItemViewType(position - 1));
                return value;
            }

            position -= size;
            typeOffset += section.adapter.getViewTypeCount();
        }

        return (-1);
    }

    public boolean areAllItemsSelectable() {
        return (false);
    }

    public boolean isEnabled(int position) {
        return (getItemViewType(position) != TYPE_SECTION_HEADER);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        int sectionIndex = 0;

        for (Section section : this.sections) {
            if (position == 0) {
                return (getHeaderView(section.caption, section.count,
                        sectionIndex, convertView, parent));
            }

            int size = section.adapter.getCount() + 1;

            if (position < size) {
                return (section.adapter.getView(position - 1, convertView,
                        parent));
            }

            position -= size;
            sectionIndex++;
        }
        return (null);
    }

    public long getItemId(int position) {
        return (position);
    }

    class Section {
        String caption = null;
        String count = null;
        Adapter adapter = null;

        Section(String caption, String count, Adapter adapter) {
            this.caption = caption;
            this.count = count;
            this.adapter = adapter;
        }
    }
}