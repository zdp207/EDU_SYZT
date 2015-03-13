package com.syzton.sunread.dto.bookshelf;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hibernate.validator.constraints.Length;
import org.joda.time.DateTime;

import com.syzton.sunread.model.bookshelf.BookShelfOperation;
import com.syzton.sunread.model.bookshelf.Bookshelf;
import com.syzton.sunread.model.bookshelf.OperationType;

/*
 * @Date 2015/03/13
 * @Author Morgan-Leon
 */
public class BookShelfOperationDTO {
	
    private Long id;
    
    @Length(max = BookShelfOperation.MAX_LENGTH_DESCRIPTION)
    private String description;
	
    private DateTime creation_time;
    private DateTime modification_time;
    
    private OperationType operationType;
    
    private Bookshelf bookshelf;
    
    public BookShelfOperationDTO() {
		
	}
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id){
    	this.id = id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public DateTime getCreationTime() {
        return creation_time;
    }

    public void setCreationTime(DateTime create_time) {
        this.creation_time = create_time;
    }
    
    public DateTime getModificationTime() {
        return modification_time;
    }

    public void setModificationTime(DateTime modification_time) {
        this.modification_time = modification_time;
    }
    
    public OperationType getOperationType() {
		return operationType;
	}
    
    public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
    
    public Bookshelf getBookshelf(){
    	return bookshelf;
    }
    
    public void setBookshelf(Bookshelf bookshelf) {
		this.bookshelf = bookshelf;
	}
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);

    }
}