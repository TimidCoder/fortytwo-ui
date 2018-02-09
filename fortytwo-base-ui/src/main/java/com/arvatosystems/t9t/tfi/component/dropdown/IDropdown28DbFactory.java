package com.arvatosystems.t9t.tfi.component.dropdown;

import com.arvatosystems.t9t.base.search.LeanSearchRequest;

import de.jpaw.bonaparte.pojos.apiw.Ref;

/** Describes a factory for a Dropdown Combobox which is populated via a DB query.
 * By convention, LeanSearchRequests are used.
 *
 * @since 3.0.2
 */
public interface IDropdown28DbFactory<REF extends Ref> extends IDropdown28BasicFactory<Dropdown28Db<REF>> {

    /** Returns an instance of the search request which queries data. */
    LeanSearchRequest getSearchRequest();

    /** Creates a type safe Ref object which contains the Ref. */
    REF createRef(Long ref);

    /** Creates a type safe Ref (Key) object by alphanumeric identifier. */
    REF createKey(String id);

    /** Returns the identifier if the REF is a KEY. */
    String getIdFromKey(REF key);
}
