package com.arvatosystems.t9t.components;

import org.zkoss.zul.Cell;
import org.zkoss.zul.Label;
import org.zkoss.zul.Row;

/**
 * An empty row, just to pad space.
 */
public class Cells8 extends Row {
    private static final long serialVersionUID = -7701935513940L;
    protected String cellHeight = "32px";

    public Cells8() {
        super();
        Cell cell1 = new Cell();
        cell1.setParent(this);
        Label label = new Label();
        label.setParent(cell1);
        if (cellHeight != null) {
            cell1.setHeight(cellHeight);
        }
    }
}
