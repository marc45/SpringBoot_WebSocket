package com.hello;

/**
 * Created by haribabu.ka on 02-02-2017.
 */
public class AddressBulkUpload {

    private String totalRecords;
    private String fileName;
    private String fileSize;
    private String uploadStatus;
    private String offset;
    private String success;
    private String failed;

    public String getFailed() {
        return failed;
    }

    public void setFailed(String failed) {
        this.failed = failed;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(String totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }

    @Override
    public String toString() {
        return "AddressBulkUpload{" +
                "failed='" + failed + '\'' +
                ", totalRecords='" + totalRecords + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", uploadStatus='" + uploadStatus + '\'' +
                ", offset='" + offset + '\'' +
                ", success='" + success + '\'' +
                '}';
    }
}
