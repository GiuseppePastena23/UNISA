package it.unisa;

import java.io.File;
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="/XUploadServlet", urlPatterns={"/xupload"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class XUploadServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;
	static String SAVE_DIR ="";

	public void init(){
	    // Get the file location where it would be stored.
		SAVE_DIR = getServletContext().getInitParameter("file-upload"); 
	 }	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setAttribute("message", "Error: GET method is used but POST method is required");
        getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);		
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
         
        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
         
        String names = null;
        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
	            if(fileName != null && !fileName.equals("")) {
		            part.write(savePath + File.separator + fileName);
		            if(names == null) {
		            	names = fileName;
		            } else names = names + ", " + fileName;
            }
        }
 
        if(names != null) {
        	request.setAttribute("message", "File(s) successfully uploaded: "+names);
        } else {
        	request.setAttribute("message", "File is not available.");
        }
        
        getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
    }
 
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
