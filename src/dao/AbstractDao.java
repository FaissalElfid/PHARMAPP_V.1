/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.DaoEngigne;

/**
 *
 * @author moulaYounes
 */
public class AbstractDao<T> {

    private Class<T> entityClass;

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public int save(T t) throws Exception {
        String requette = DaoEngigne.constructDaoSaveRequette(t);
        return ConnectDB.exec(requette);
    }

    public int delete(T t) throws Exception {
        String requette = DaoEngigne.constructDaoDeleteRequette(t);
        return ConnectDB.exec(requette);
    }

    public List<T> findAll() throws Exception {
        String requette = "SELECT * FROM " + DaoEngigne.transformeToSqlName(entityClass) + "";
        return load(requette);
    }

    public T findById(Object id) throws Exception {
        String requette = "SELECT * FROM " + DaoEngigne.transformeToSqlName(entityClass) + " WHERE id='" + id + "'";
        List<T> list = load(requette);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    public int update(T object, Object id) throws Exception {
        String requette = DaoEngigne.constructDaoUpdateRequette(object, id);
        System.out.println("ha requette de update(T,id)==>" + requette);

        return ConnectDB.exec(requette);

    }

    public int update(T object) throws Exception {
        String requette = DaoEngigne.constructDaoUpdateRequette(object, DaoEngigne.lunchGetter(object, DaoEngigne.getId(entityClass)));
        System.out.println("ha requette de update(T)==>" + requette);
        return ConnectDB.exec(requette);

    }

    public List<T> load(String requette) throws Exception {
        ResultSet resultSet = ConnectDB.load(requette);
        List<Method> setters = DaoEngigne.getSetterList(entityClass);
        List<Class> paramTypes = DaoEngigne.getParameterType(setters);
        List<T> result = new ArrayList<>();
        while (resultSet.next()) {
            T myObject = entityClass.newInstance();
            for (int i = 0; i < paramTypes.size(); i++) {
                Class type = paramTypes.get(i);

                if (DaoEngigne.isGenericType(type.getSimpleName())) {
                    String getterName = DaoEngigne.constructGetterName(type.getSimpleName());
                    Method getterMethod = DaoEngigne.lunchGetterByName(resultSet, getterName);
                    String inputName = DaoEngigne.getParameterName(setters.get(i));
                    Object resultatExec = DaoEngigne.lunchGetterWithParams(resultSet, getterMethod, inputName);
                    DaoEngigne.lunchSetter(myObject, setters.get(i), resultatExec);
                } else if (!type.getSimpleName().equals("List")) {
                    String getterName = DaoEngigne.constructGetterName(DaoEngigne.getId(type).getReturnType().getSimpleName());
                    Method getterMethod = DaoEngigne.lunchGetterByName(resultSet, getterName);
                    String inputName = DaoEngigne.getParameterName(setters.get(i));
                    Object resultatExec = DaoEngigne.lunchGetterWithParams(resultSet, getterMethod, inputName);
                    Class typeSortieSetter = setters.get(i).getParameterTypes()[0];
                    Object objectSortieSetter = typeSortieSetter.newInstance();
                    DaoEngigne.lunchSetter(objectSortieSetter, DaoEngigne.setId(objectSortieSetter), resultatExec);
                    DaoEngigne.lunchSetter(myObject, setters.get(i), objectSortieSetter);
                }
            }
            result.add(myObject);

        }
        return result;
    }

}
