package com.arvatosystems.t9t.tfi.general;

import de.jpaw.bonaparte.pojos.api.OperationType;

// converted in 3.0.4 to use the OperationType enum instead of Strings. Not all types have 1:1 corresponding enum instances!
public class PermissionOperations {
//    public static final String CREATE = "Create";
//    public static final String UPDATE = "Update";
//    public static final String DELETE = "Delete";
//    public static final String ASSIGN_PERMISSIONS = "AssignPermissions";
//    public static final String EXPORT = "Export";
//    public static final String TEST = "Test";
//    public static final String READ = "Read";
//    public static final String UPLOAD = "Upload";
//    public static final String DOWNLOAD = "Download";
//    public static final String VIEW = "View";
//    public static final String COMPLETE = "Complete";
//    public static final String START = "Start";

    public static final OperationType CREATE             = OperationType.CREATE;
    public static final OperationType UPDATE             = OperationType.UPDATE;
    public static final OperationType DELETE             = OperationType.DELETE;
    public static final OperationType ASSIGN_PERMISSIONS = OperationType.ADMIN;
    public static final OperationType EXPORT             = OperationType.EXPORT;
    public static final OperationType TEST               = OperationType.EXECUTE;
    public static final OperationType READ               = OperationType.READ;
    public static final OperationType UPLOAD             = OperationType.IMPORT;
    public static final OperationType DOWNLOAD           = OperationType.EXPORT;
    public static final OperationType VIEW               = OperationType.READ;
    public static final OperationType COMPLETE           = OperationType.EXECUTE;
    public static final OperationType START              = OperationType.EXECUTE;
    public static final OperationType ACCEPT             = OperationType.APPROVE;
    public static final OperationType REJECT             = OperationType.REJECT;
}
