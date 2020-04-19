package mx.org.cadmin.persist;

import java.util.ArrayList;
import java.util.List;

import org.displaytag.pagination.PaginatedList;
import org.displaytag.properties.SortOrderEnum;

/**
 * Documentation for  class <code>CaPagedAdapter</code> .
 *
 * @author <a href="www.mexgrp.com/coffee"> Daniel Diaz </a>
 * @version 0.6
 */
public class CaPagedAdapter implements PaginatedList{

List list = new ArrayList();
private int page = 1;
private int objectsPerPage ;
private int fullListSize = 0;
String sortCriterion;
String sortDirection;
String searchId ;

  /**
   * Creates a new <code>CaPagedAdapter</code> instance.
   *
   * @param objPerPage an <code>int</code> value
   */
  public CaPagedAdapter(int objPerPage){
	this.objectsPerPage =	objPerPage;
}

	
  /**
   * Describe <code>getList</code> method here.
   *
   * @return a <code>List</code> value
   */
  public List getList() {
	
		return list;
	}

  /**
   * Describe <code>setList</code> method here.
   *
   * @param list a <code>List</code> value
   */
  public void setList(List list) {
	this.list = list;
}

	
  /**
   * Describe <code>getPageNumber</code> method here.
   *
   * @return an <code>int</code> value
   */
  public int getPageNumber() {
	
		return page;
	}

  /**
   * Describe <code>setPageNumber</code> method here.
   *
   * @param page an <code>int</code> value
   */
  public void setPageNumber(int page) {
	this.page = page;
}


	
  /**
   * Describe <code>getObjectsPerPage</code> method here.
   *
   * @return an <code>int</code> value
   */
  public int getObjectsPerPage() {
	
		return objectsPerPage;
	}
  /**
   * Describe <code>setObjectsPerPage</code> method here.
   *
   * @param i an <code>int</code> value
   */
  public void setObjectsPerPage(int i) {
		objectsPerPage = i;
	}

  /**
   * Describe <code>getFullListSize</code> method here.
   *
   * @return an <code>int</code> value
   */
  public int getFullListSize() {
	
		return fullListSize;
	}

  /**
   * Describe <code>setFullListSize</code> method here.
   *
   * @param size an <code>int</code> value
   */
  public void setFullListSize(int size) {
	this.fullListSize = size;
}

  /**
   * Describe <code>getSortCriterion</code> method here.
   *
   * @return a <code>String</code> value
   */
  public String getSortCriterion() {

					return sortCriterion;
			
	}

  /**
   * Describe <code>setSortCriterion</code> method here.
   *
   * @param string a <code>String</code> value
   */
  public void setSortCriterion(String string) {
		this.sortCriterion = string;
	}

  /**
   * Describe <code>getSortDirection</code> method here.
   *
   * @return a <code>SortOrderEnum</code> value
   */
  public SortOrderEnum getSortDirection() {

	if ( sortDirection == null || sortDirection.equals("asc") ) {
	  return SortOrderEnum.ASCENDING;
  } else {
	  return SortOrderEnum.DESCENDING;
  }

	}
  /**
   * Describe <code>setSortDirection</code> method here.
   *
   * @param enume a <code>String</code> value
   */
  public void setSortDirection(String enume) {
		this.sortDirection = enume;
	}

  /**
   * Describe <code>getSearchId</code> method here.
   *
   * @return a <code>String</code> value
   */
  public String getSearchId() {
		return Integer.toHexString(objectsPerPage * 10000 + page);
	}

  /**
   * Describe <code>clear</code> method here.
   *
   */
  public void clear() {
	
	list.clear();
	page = 1;
}



}
