package com.arvatosystems.t9t.itemConverter;

import de.jpaw.bonaparte.core.BonaPortable;
import de.jpaw.bonaparte.pojos.meta.FieldDefinition;

public interface IItemConverter<T> {

//    public default IItemConverter<T> getConverter(Object value, BonaPortable wholeDataObject, String fieldName, FieldDefinition d) {
//        return null;
//    }

    /** Return the alignment of this converter. Used for numeric fields. */
    public default boolean isRightAligned() { return false; }


    /**
     * This method is responsible to print the label in the correct way.<br>
     * e.g.:
     * <ul>
     * <li>Object like: Person</li>
     * <li>With properties: gender (Integer) 0=male / 1=female</li>
     * <li>the following value would be passed</li>
     * <ul>
     * <li>value: Integer(1)</li>
     * <li>wholeDataObject: Person-object</li>
     * <li>fieldName: gender</li>
     * </ul>
     * <li>Return: the string "Female"</li>
     * </ul>
     * @param value The value itself that should be formatted
     * @param wholeDataObject the whole Data Object will be passed for cases if you need additional values from other fields you want to combine
     * @param fieldName the property name of the object
     * @return your formatted label as String
     */
    public String getFormattedLabel(T value, BonaPortable wholeDataObject, String fieldName, FieldDefinition d);

    /**
     * This method is responsible to give back the correct object that the listbox can deal with it in a proper way like sorting, etc.<br>
     * e.g.:
     * <ul>
     * <li>Object like: Person</li>
     * <li>With properties: gender (Integer) 0=male / 1=female</li>
     * <li>the following value would be passed</li>
     * <ul>
     * <li>value: Integer(1)</li>
     * <li>wholeDataObject: Person-object</li>
     * <li>fieldName: gender</li>
     * </ul>
     * <li>Return: a the converted object like String("F")</li>
     * </ul>
     * @param value The value itself that should be formatted
     * @param wholeDataObject the whole Data Object will be passed for cases if you need additional values from other fields you want to combine
     * @param fieldName the property name of the object
     * @return your formatted label as String
     */
    public Object getConvertedValue(T value, BonaPortable wholeDataObject, String fieldName, FieldDefinition d);

}
