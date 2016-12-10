package com.tutorialspoint.struts2.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * Created by fulinhua on 2016/12/10.
 */
public class uploadAction extends ActionSupport {
    public File getFile () {
        return file;
    }

    public void setFile ( File file ) {
        this.file = file;
    }

    private File file;


    public String getFileContentType () {
        return fileContentType;
    }

    public void setFileContentType ( String fileContentType ) {
        this.fileContentType = fileContentType;
    }

    private String fileContentType;

    public String getFileFileName () {
        return fileFileName;
    }

    public void setFileFileName ( String fileFileName ) {
        this.fileFileName = fileFileName;
    }

    private String fileFileName;
    public String execute(){

        return "input";
    }
    public String upload() throws IOException {
        File saved=new File(ServletActionContext.getServletContext().getRealPath("upload"),fileFileName);
        InputStream ins=null;
        OutputStream ous=null;
        saved.getParentFile().mkdirs();
        try {
            ins=new FileInputStream(file);
            ous=new FileOutputStream(saved);
            byte[] b=new byte[1024];
            int len=0;
            while((len=ins.read(b))!=-1){
                ous.write(b,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(ous!=null) ous.close();

            if(ins!=null) ins.close();

        }
return "list";
    }

}
