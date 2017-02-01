/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cycsystemsgt.student_control.util;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
/**
 *
 * @author angel
 */
public class comboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Object item;
    
    private ArrayList anArrayList;
    
    @Override
    public void setSelectedItem(Object anItem) {
        item = anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return item;
    }

    @Override
    public int getSize() {
        return anArrayList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return anArrayList.get(index);
    }
    
}
