package com.steven.saar.common.web.upload.exception;

import org.apache.commons.fileupload.FileUploadException;

/**
 * 项目名称:com.steven.saar.common.web.upload.exception
 * 类名称:FileNameLengthLimitExceededException
 * 描述:
 * 创建人:steven
 * 创建时间:2018-05-20 00:13
 */
public class FileNameLengthLimitExceededException extends FileUploadException {

    private int length;
    private int maxLength;
    private String filename;

    public FileNameLengthLimitExceededException(String filename, int length, int maxLength) {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public int getLength() {
        return length;
    }


    public int getMaxLength() {
        return maxLength;
    }

}
