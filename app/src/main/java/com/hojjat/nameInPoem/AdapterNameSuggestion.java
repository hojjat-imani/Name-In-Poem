package com.hojjat.nameInPoem;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.hojjat.nameInPoem.util.StringUtil;

public class AdapterNameSuggestion extends BaseAdapter implements Filterable {
	Context context;
	ArrayList<String> OriginalData;
	ArrayList<String> tempData;
	MyFilter filter;

	public AdapterNameSuggestion(Context context, ArrayList<String> OriginalData) {
		this.context = context;
		this.OriginalData = OriginalData;
		tempData = OriginalData;
		filter = new MyFilter();
	}

	@Override
	public int getCount() {
		return tempData.size();
	}

	@Override
	public String getItem(int position) {
		return tempData.get(position);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		if (convertView == null) {
			convertView = new TextView(context);
			((TextView) convertView).setTypeface(StringUtil.getFont(context,
                    StringUtil.FONT_NAZANIN_BOLD));
			((TextView) convertView)
					.setTextSize(StringUtil.APP_DEFAULT_FONT_SIZE_LARGE);
			((TextView) convertView).setTextColor(context.getResources().getColor(R.color.text_dark));
			((TextView) convertView).setPadding(5, 5, 5, 5);
		}
		((TextView) convertView).setText(tempData.get(position));
		return convertView;
	}

	private class ViewHolder {
		TextView text;
	}

	@Override
	public Filter getFilter() {
		return filter;
	}

	private class MyFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults filterResult = new FilterResults();
			ArrayList<String> nameResults = new ArrayList<String>();
			if (constraint == null) {
				filterResult.values = OriginalData;
			} else {
				for (String name : OriginalData) {
					if (name.startsWith(constraint.toString())) {
						nameResults.add(name);
					}
				}
				if (nameResults.size() == 0) {
					for (String name : OriginalData) {
						if (name.contains(constraint.toString())) {
							nameResults.add(name);
						}
					}
				}
				filterResult.values = nameResults;
			}
			return filterResult;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			tempData = (ArrayList<String>) results.values;
			notifyDataSetChanged();
		}

	}
}
