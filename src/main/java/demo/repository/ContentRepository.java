/**
 * 
 */
package demo.repository;

import java.io.InputStream;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * @author Nikola.Petrovic
 * @created Mar 26, 2015
 *
 */
public interface ContentRepository {
    GridFSDBFile findByFileName(String fileName);

    GridFSDBFile findById(String id);

    GridFSDBFile findByUserId(String userId);

    String store(InputStream inputStream, String fileName, String contentType,
	    DBObject metaData);
}