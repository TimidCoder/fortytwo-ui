package com.arvatosystems.t9t.component.fields;

import org.zkoss.zk.ui.Component;

import com.arvatosystems.t9t.tfi.web.ApplicationSession;

import de.jpaw.bonaparte.pojos.meta.FieldDefinition;
import de.jpaw.bonaparte.pojos.ui.UIFilter;

/** Interface which must be implemented by custom filters. It is a factory for IField instances.
 * The actual filter usually will be implemented as a (probably static local) subclass of AbstractField.
 *
 * @param <E>
 */
public interface IFieldCustomFactory<E extends Component> {
    IField<E> createField(String fieldname, UIFilter cfg, FieldDefinition desc, String gridId, ApplicationSession session) throws Exception;
}
