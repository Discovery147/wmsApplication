package Area;

import java.awt.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyRenderer extends DefaultTableCellRenderer {

  
    @Override public Component getTableCellRendererComponent(
    JTable aTable, Object aNumberValue, boolean aIsSelected, 
    boolean aHasFocus, int aRow, int aColumn
  ) {  
            if (aNumberValue == null) return this;
            Component renderer = super.getTableCellRendererComponent(
              aTable, aNumberValue, aIsSelected, aHasFocus, aRow, aColumn
            );
            System.out.println("Column: "+aColumn);
            if(aNumberValue.toString().equals("2")&&aColumn==2)
            {
                renderer.setBackground(Color.red);
                //AreaData.count++;
            }
            else 
            {
                renderer.setBackground(Color.green);
            }
            return this;
          }
	}