package com.arvatosystems.t9t.services;

import java.io.IOException;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zul.Filedownload;

import com.arvatosystems.t9t.tfi.services.ReturnCodeException;
import com.arvatosystems.t9t.base.api.RequestParameters;
import com.arvatosystems.t9t.base.output.OutputSessionParameters;
import com.arvatosystems.t9t.base.search.SinkCreatedResponse;
import com.arvatosystems.t9t.io.DataSinkDTO;
import com.arvatosystems.t9t.io.SinkDTO;
import com.arvatosystems.t9t.io.SinkRef;
import com.arvatosystems.t9t.io.request.FileDownloadRequest;
import com.arvatosystems.t9t.io.request.FileDownloadResponse;
import com.arvatosystems.t9t.rep.ReportParamsRef;

import de.jpaw.bonaparte.pojos.api.media.MediaData;
import de.jpaw.util.ByteArray;



public interface IT9TMessagingDAO {

    /**
     * Invocation allows to output a simple header/footer document with no data items included.
     * In some cases it will be an empty file, but still useful to see generated filenames or test connectivity.
     * Intended to be used from the configuration UI, but also for remote tests.
     * @param dataSink
     * @param numDataRecords
     * @throws ReturnCodeException
     */
    public Long dataSinkTestRequest(DataSinkDTO dataSink, int numDataRecords) throws ReturnCodeException;

    /**
     * Prepare a ZK Media object that is needed for download content. This media object can be used with {@link Filedownload#save(Media)}.<br>
     * Used Request: {@link FileDownloadRequest}<br>
     * The meta data about the file (name, content-type and format) will collect from the {@link FileDownloadResponse}<br>
     * If more chunks of data are available, it will be handled internally to retrieve these.
     * @param sinkRef The reference for the download
     * @param chunkSizeInBytes Set the chunk size of the internal re-read mechanism
     * @return the filled Media object.
     * @throws ReturnCodeException
     */
    public Media downloadFileRequest(SinkRef sinkRef, Integer chunkSizeInBytes) throws ReturnCodeException;

    /**
     * Get from back-end the full Sink object by giving only the reference
     * @param sinkObjectRef Sink objectRef
     * @return Full Sink object
     * @throws ReturnCodeException
     */
    public SinkDTO retrieveSink(Long sinkObjectRef) throws ReturnCodeException;


    /**
     * Rerun a single Request
     * @param referencedRequestRef the cProcessRef of the request to be rerun.
     * @throws ReturnCodeException
     */
    public void rerunRequest(Long referencedRequestRef) throws ReturnCodeException;


    /**
     * The file upload request allows to create a sink entry for given upload data. It returns a sink reference in case of success.
     */
    public SinkCreatedResponse fileUploadRequest(OutputSessionParameters parameters, ByteArray data) throws ReturnCodeException;

    public void downloadSinkAndSave(Long sinkref);

    /** Run an arbitrary request which returns a FileDownloadResponse. */
    public void downloadFileAndSave(RequestParameters rp);

    /**
     * Just run the RunReportRequest. The request will be filled with ReportParamsRef.<br>
     * The response will be the sink-objectRef {@link SinkCreatedResponse#getSinkRef()}
     * @param paramsRef
     * @return sinkObjectRef
     * @throws ReturnCodeException
     */
    public Long runReportRequest(ReportParamsRef paramsRef) throws ReturnCodeException;

    /** entry used by the export button of grid28. */
    public void downloadFileAndSave(Long sinkRef) throws ReturnCodeException;

    public MediaData getUploadedData(UploadEvent ev) throws IOException;
}
