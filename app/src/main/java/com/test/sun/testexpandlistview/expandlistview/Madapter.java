package com.test.sun.testexpandlistview.expandlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

import com.test.sun.testexpandlistview.R;
import com.test.sun.testexpandlistview.bean.TestBean;

import java.util.List;

/**
 * Created by ZS27 on 2016/12/12.
 */

public class Madapter extends BaseExpandableListAdapter {

    private Context context;
    private List<List<TestBean>> list;
    private LayoutInflater inflater;

    public Madapter(Context context, List<List<TestBean>> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.audio_item_parent, parent, false);
            holder = new GroupViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (GroupViewHolder) convertView.getTag();
        }
        initGroupHolder(convertView, holder, groupPosition, isExpanded);
        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.audio_item_child, parent, false);
            holder = new ChildViewHolder();
            convertView.setTag(holder);
        } else {
            holder = (ChildViewHolder) convertView.getTag();
        }
        initChildHolder(convertView, holder, groupPosition, childPosition, isLastChild);
        return convertView;
    }

    private void initGroupHolder(View convertView, GroupViewHolder holder, int groupPosition, boolean isExpanded) {
        holder.groupTv = (TextView) convertView.findViewById(R.id.audio_item_parent_tv);
        holder.groupTv.setText("group:" + groupPosition + " " + isExpanded);
    }

    private void initChildHolder(View convertView, ChildViewHolder holder, int groupPosition, int childPosition, boolean isLastChild) {
        holder.childTv = (TextView) convertView.findViewById(R.id.audio_item_child_tv);
        holder.childTv.setText("child:" + groupPosition + " " + childPosition + " " + isLastChild);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class GroupViewHolder {
        TextView groupTv;
    }

    class ChildViewHolder {
        TextView childTv;
    }
}
