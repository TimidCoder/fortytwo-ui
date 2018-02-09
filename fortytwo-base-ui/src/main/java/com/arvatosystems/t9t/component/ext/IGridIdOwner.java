package com.arvatosystems.t9t.component.ext;

/** Interface to add to custom components if they understand the concept of gridIds.
 * This is used to get grid IDs from parents.
 */
public interface IGridIdOwner extends IViewModelOwner {
    String getGridId();
    void setGridId(String gridId);
}
