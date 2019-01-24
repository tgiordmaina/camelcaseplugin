package de.netnexus.CamelCasePlugin;

import com.intellij.openapi.project.Project;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class OptionGui {
    private DefaultListModel model;
    private JCheckBox cb2;
    private JCheckBox cb3;
    private JCheckBox cb5;
    private JCheckBox cb4;
    private JCheckBox cb1;
    private JCheckBox cb6;
    private CamelCaseConfig mConfig;

    private JPanel rootPanel;
    private JButton upButton;
    private JButton downButton;
    private JList list1;

    OptionGui() {

        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedItem = (String) list1.getSelectedValue();
                int itemIndex = list1.getSelectedIndex();

                if(itemIndex > 0){
                    model.remove(itemIndex);
                    model.add(itemIndex - 1, selectedItem);
                    list1.setSelectedIndex(itemIndex - 1);
                }
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = (String) list1.getSelectedValue();
                int itemIndex = list1.getSelectedIndex();

                if( itemIndex < model.getSize() -1 ){
                    model.remove(itemIndex);
                    model.add(itemIndex + 1, selectedItem);
                    list1.setSelectedIndex(itemIndex + 1);
                }
            }
        });
    }

    public void createUI(Project project) {
        mConfig = CamelCaseConfig.getInstance(project);
        cb1.setSelected(mConfig.getcb1State());
        cb2.setSelected(mConfig.getcb2State());
        cb3.setSelected(mConfig.getcb3State());
        cb4.setSelected(mConfig.getcb4State());
        cb5.setSelected(mConfig.getcb5State());
        cb6.setSelected(mConfig.getcb6State());

        if (mConfig.getmodel()!=null){
            model = new DefaultListModel();
            for(Object obj : mConfig.getmodel()){
                model.addElement(obj);
            }
            list1.setModel(model);
        }else {
            model = (DefaultListModel)list1.getModel();
            list1.setModel(model);


        }
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }


    public void apply() {
        mConfig.setcb1State(cb1.isSelected());
        mConfig.setcb2State(cb2.isSelected());
        mConfig.setcb3State(cb3.isSelected());
        mConfig.setcb4State(cb4.isSelected());
        mConfig.setcb5State(cb5.isSelected());
        mConfig.setcb6State(cb6.isSelected());

        Object[] oValues= model.toArray();
        String[] sValues = new String[oValues.length];
        for (int index = 0; index < oValues.length; index++) {
            sValues[index] = oValues[index].toString();
        }
        mConfig.setListModel(sValues);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        cb1 = new JCheckBox();
        cb1.setSelected(true);
        cb1.setText("snake_case to snake-case");
        rootPanel.add(cb1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cb2 = new JCheckBox();
        cb2.setSelected(true);
        cb2.setText("snake-case to SNAKE_CASE");
        rootPanel.add(cb2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(270, 20), null, 0, false));
        cb3 = new JCheckBox();
        cb3.setSelected(true);
        cb3.setText("SNAKE_CASE to SnakeCase");
        rootPanel.add(cb3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(270, 20), null, 0, false));
        cb4 = new JCheckBox();
        cb4.setEnabled(true);
        cb4.setSelected(true);
        cb4.setText("CamelCase to camelCase");
        rootPanel.add(cb4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cb5 = new JCheckBox();
        cb5.setSelected(true);
        cb5.setText("camelCase to snake_case");
        rootPanel.add(cb5, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }
}
