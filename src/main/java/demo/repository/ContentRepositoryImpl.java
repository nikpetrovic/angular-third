/**
 * 
 */
package demo.repository;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * @author Nikola.Petrovic
 * @created Mar 26, 2015
 *
 */
@Repository
public class ContentRepositoryImpl implements ContentRepository {
    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Override
    public GridFSDBFile findByFileName(String fileName) {
	return getGridFsTemplate().findOne(
		new Query(Criteria.where("filename").is(fileName)));
    }

    @Override
    public GridFSDBFile findById(String id) {
	return getGridFsTemplate().findOne(
		new Query(Criteria.where("_id").is(id)));
    }

    @Override
    public GridFSDBFile findByUserId(String userId) {
	return getGridFsTemplate().findOne(
		new Query(Criteria.where("metadata.userId").is(userId)));
    }

    @Override
    public String store(InputStream inputStream, String fileName,
	    String contentType, DBObject metaData) {
	return getGridFsTemplate()
		.store(inputStream, fileName, contentType, metaData).getId()
		.toString();
    }

    private GridFsTemplate getGridFsTemplate() {
	return gridFsTemplate;
    }
}
