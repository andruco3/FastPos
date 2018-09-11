/**
 * 
 */
package com.witty.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.witty.entity.CamposConexion;
import com.witty.entity.Conexion;

/**
 * @author andruco3
 *
 */
public abstract class CrudPersistence<T> {

	    /**
	     * Returns the EntityManager used for all operations
	     * @return EntityManager
	     */
	    protected abstract EntityManager getEntityManager();

	    /**
	     * Gets the Class Type of the entity expected to use in CRUD operations
	     * @return Class Type of handled entity
	     */
	    protected abstract Class<T> getEntityClass();

	    /**
	     * Retrieves the ammount of records in the database for the handled entity
	     * @return Number of records of handled entity
	     */
	    public int count() {
	        Query count = getEntityManager().createQuery("select count(u) from " + getEntityClass().getSimpleName() + " u");
	        return Integer.parseInt(count.getSingleResult().toString());
	    }

	    /**
	     * Creates a new record in database for the handled instance
	     * @param entity Record information
	     * @return New instance of handled entity with it's ID
	     */
	    public T create(T entity) {
	    	Conexion coenexion=(Conexion)entity;
	    	System.out.print(coenexion.getId());
	    	getEntityManager().getTransaction().begin();
	        getEntityManager().persist(entity);
	        getEntityManager().getTransaction().commit();
	        getEntityManager().close();
	        return entity;
	    }

	    /**
	     * Updates an existing instance of handled entity.
	     *
	     * @param entity Updated instance
	     * @return Updated instance
	     */
	    public T update(T entity) {
	    	    getEntityManager().getTransaction().begin();
	    	    T entityN = getEntityManager().merge(entity);
		        getEntityManager().getTransaction().commit();
	        return entityN;
	    }

	    /**
	     * Deletes a record of handled entity from database.
	     * @param id ID of the record to delete
	     */
	    public void delete(int id) {
	    	
	        T entity = getEntityManager().find(getEntityClass(), id);
	        System.out.print("------ " + ((Conexion)entity).getCamposConexion().size()+ "   - - - - - ");
	        getEntityManager().getTransaction().begin();
	        getEntityManager().remove(entity);
	        getEntityManager().getTransaction().commit();
	    }

	    /**
	     * Retrieves an instance of handled entity by ID.
	     * @param id ID of the instance to retrieve
	     * @return Instance of handled entity
	     */
	    public T find(int id) {
	    	return getEntityManager().find(getEntityClass(), id);
	    }

	    /**
	     * Retrieves a collection of all instances of handled entity
	     * @return Colecction of instances of handled entity
	     */
	    public List<T> findAll() {
	        Query q = getEntityManager().createQuery("select u from " + getEntityClass().getSimpleName() + " u");
	        return q.getResultList();
	    }

	    /**
	     * Retrieves a collection of all instances of handled entity allowing pagination.
	     * @param page Number of page to retrieve
	     * @param maxRecords Number of records per page
	     * @return Colecction of instances of handled entity
	     */
	    public List<T> findAll(Integer page, Integer maxRecords) {
	        Query q = getEntityManager().createQuery("select u from " + getEntityClass().getSimpleName() + " u");
	        if (page != null && maxRecords != null) {
	            q.setFirstResult((page - 1) * maxRecords);
	            q.setMaxResults(maxRecords);
	        }
	        return q.getResultList();
	    }

	    /**
	     * Allows to execute a namedQuery that returns a collection.
	     * @param <V> Type of each element of the collection
	     * @param name Name of the namedQuery
	     * @return Collection of instances of V
	     */
	    public <V> List<V> executeListNamedQuery(String name) {
	        return getEntityManager().createNamedQuery(name).getResultList();
	    }

	    /**
	     * Allows to execute a namedQuery that returns a collection with pagination.
	     *
	     * @param <V> Type of each element of the collection
	     * @param name Name of the namedQuery
	     * @param params Map of parameters for the query, where the key is the name of the parameter
	     * @return Collection of instances of V
	     */
	    public <V> List<V> executeListNamedQuery(String name, Map<String, Object> params) {
	        Query q = getEntityManager().createNamedQuery(name);
	        for (Map.Entry<String, Object> entry : params.entrySet()) {
	            q.setParameter(entry.getKey(), entry.getValue());
	        }
	        return q.getResultList();
	    }

	    /**
	     * Allows to execute a namedQuery that returns a single instance.
	     * @param <V> Type of the instance to retrieve
	     * @param name Name of the namedQuery
	     * @return Instance of V
	     */
	    public <V> V executeSingleNamedQuery(String name) {
	        return (V) getEntityManager().createNamedQuery(name).getSingleResult();
	    }

	    /**
	     * Allows to execute a namedQuery that returns a single instance with pagination.
	     *
	     * @param <V> Type of the instance to retrieve
	     * @param name Name of the namedQuery
	     * @param params Map of parameters for the query, where the key is the name of the parameter
	     * @return Instance of V
	     */
	    public <V> V executeSingleNamedQuery(String name, Map<String, Object> params) {
	        Query q = getEntityManager().createNamedQuery(name);
	        for (Map.Entry<String, Object> entry : params.entrySet()) {
	            q.setParameter(entry.getKey(), entry.getValue());
	        }
	        return (V) q.getSingleResult();
	    }

	    /**
	     * Allows to search for all records of handled entity by a string contained in name.
	     * @param text String to search within names
	     * @return Collection of records with text contained in name
	     */
	    public List<T> findByName(String text) {
	        Query q = getEntityManager().createQuery("select u from " + getEntityClass().getSimpleName() + " u where u.name like :name");
	        q.setParameter("name", "%" + text + "%");
	        return q.getResultList();
	    }

	    /**
	     * Allows to search for all records of handled entity by a string contained in name with pagination.
	     *
	     * @param text String to search within names
	     * @param page page to retrieve
	     * @param maxRecords Ammount of records to retrieve
	     * @return Collection of records with text contained in name
	     */
	    public List<T> findByName(String text, Integer page, Integer maxRecords) {
	        Query q = getEntityManager().createQuery("select u from " + getEntityClass().getSimpleName() + " u where u.name like :name");
	        q.setParameter("name", "%" + text + "%");
	        if (page != null && maxRecords != null) {
	            q.setFirstResult((page - 1) * maxRecords);
	            q.setMaxResults(maxRecords);
	        }
	        return q.getResultList();
	    }
	
	
}
