/**
 * 
 */
package demo.controllers;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import demo.repository.ContentRepository;

/**
 * @author Nikola.Petrovic
 * @created Mar 26, 2015
 *
 */
@Controller
@RequestMapping("/content")
public class ContentController {
    private static final Log LOGGER = LogFactory
	    .getLog(ContentController.class);

    @Autowired
    private ContentRepository contentRepository;

    @RequestMapping("/user/{userId}")
    public void findContentByUserId(@PathVariable String userId,
	    HttpServletResponse response) {
	GridFSDBFile dbFile = getContentRepository().findByUserId(userId);
	if (dbFile == null) {
	    response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	    return;
	}

	try {
	    response.getOutputStream().write(
		    IOUtils.toByteArray(dbFile.getInputStream()));
	    response.setContentType(dbFile.getContentType());
	} catch (IOException e) {
	    LOGGER.error("Error while reading file from mongoDB", e);
	    response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	} finally {
	    try {
		dbFile.getInputStream().close();
	    } catch (IOException e) {
		LOGGER.error("Closing stream failed", e);
	    }
	}
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void upload(MultipartFile file, HttpServletResponse response,
	    String flowFilename, String userId) {
	DBObject metaData = new BasicDBObject();
	metaData.put("userId", userId);
	try {
	    getContentRepository().store(
		    new ByteArrayInputStream(file.getBytes()), flowFilename,
		    "image/png", metaData);
	} catch (IOException e) {
	    LOGGER.error("Error while storing file to mongoDB", e);
	}
    }

    private ContentRepository getContentRepository() {
	return contentRepository;
    }
}